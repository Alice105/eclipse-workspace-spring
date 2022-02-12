package com.study.springcore.tx.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.springcore.tx.dao.BookDao;
import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor = {InsufficientAmount.class, InsufficientQuantity.class},
			noRollbackFor = {ArithmeticException.class}
	)
	// getConnection() , setAutocommit(false) , commit()
	@Override
	public void buyOne(Integer wid, Integer bid) throws InsufficientAmount, InsufficientQuantity {
		// 減去一本庫存
		bookDao.updateStock(bid, 1);
		// 取得書籍價格
		//System.out.println(10/0); // 產生 ArithmeticException 錯誤（根據上面的定義資料庫會不做回滾）
		Integer price = bookDao.getPrice(bid);
		// 減去錢包裡的金額
		bookDao.updateWallet(wid, price);
		
		//hw
		// Log ...
	}
	
	@Transactional(
			propagation = Propagation.REQUIRED, 
			rollbackFor = {InsufficientAmount.class, InsufficientQuantity.class},
			noRollbackFor = {ArithmeticException.class}
	)
	// getConnection() , setAutocommit(false) , commit()
	@Override
	public void buyMany(Integer wid, Integer... bids) throws InsufficientAmount, InsufficientQuantity {
		// 重複執行 buyOne
		for(Integer bid : bids) {
			buyOne(wid, bid);
		}
		//hw
		// Log ...
	}

}
