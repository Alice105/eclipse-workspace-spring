package com.study.springcore.tx.dao;

import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;

public interface BookDao {
	Integer getPrice(Integer bid);
	Integer getStockAmount(Integer bid);
	Integer getWalletMoney(Integer wid);
	Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity; // 減去庫存
	Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount; // 減去餘額
	//Integer updateStock(Integer bid,Integer amount) throws Exception;//有變動要考慮拋出例外
}

	
