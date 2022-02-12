package com.study.springcore.jdbc.template;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.springcore.jdbc.entity.hw_Invoice;

@Repository
public class hw_InvoiceDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<hw_Invoice> queryhw_Invoices() {
		//每一張發票有哪些商品?
		/*
		String sql ="select i.id , t.ipid, p.text ";
		List<hw_Invoice> hw_Invoices = jdbcTemplate.query(sql, (ResultSet rs,int rowNum)->{
			hw_Invoice hw_In = new hw_Invoice();
			//設定欄位
			hw_In.setInid(rs.getInt("id"));
			hw_In.setIpid(rs.getInt("ipid"));
			hw_In.setText(rs.getString("text"));
		*/
		
		String sql2="select i.id, t.ipid, p.text from invoice as i left join item as t on i.id=t.invid left join itemproduct as p on t.ipid = p.id;";
		
		List<Map<String, Object>> hw_Ins=jdbcTemplate.queryForList(sql2);  //.query(sql2) //, new BeanPropertyRowMapper(hw_Invoice.class));
		System.out.println(hw_Ins);	
			//設定關聯
			//hw_In.sethw_Invoice(hw_Ins);
				
			//return hw_Ins;
		//return hw_Invoices;
		return null;
	}
}
/*	
		
		
	public List<hw_Invoice> queryhw_Invoices2() {
		//每一張發票有幾件商品?
		String sql ="select i.id , t.ipid,t.amount, p.text";
		List<hw_Invoice> hw_Invoices = jdbcTemplate.query(sql, (ResultSet rs,int rowNum)->{
			hw_Invoice hw_In = new hw_Invoice();
			//設定欄位
			hw_In.setInid(rs.getInt("id"));
			hw_In.setIpid(rs.getInt("ipid"));
			hw_In.setAmount(rs.getInt("amount"));
			hw_In.setTest(rs.getString("test"));
				
		String sql2="from invoice as i   \r\n"
				+ "left join item as t on i.id=t.invid\r\n"
				+ "left join itemproduct as p on t.ipid = p.id;";
		List<hw_Invoice> hw_Ins=jdbcTemplate.query(sql2, new BeanPropertyRowMapper(hw_Invoice.class));
				
			//設定關聯
			hw_In.sethw_Invoice(hw_Ins);
				
			return hw_In;
		});
		return hw_Invoices;
	}
		
		
		
	public List<hw_Invoice> queryhw_Invoices3() {
		//每一張發票價值多少錢?
		String sql ="select i.id , sum(t.amount*p.price)";
		List<hw_Invoice> hw_Invoices = jdbcTemplate.query(sql, (ResultSet rs,int rowNum)->{
			hw_Invoice hw_In = new hw_Invoice();
			//設定欄位
			hw_In.setInid(rs.getInt("id"));
			hw_In.setAmount(rs.getInt("amount"));
			hw_In.setPrice(rs.getInt("price"));
				
		String sql2="from invoice as i   \r\n"
				+ "left join item as t on i.id=t.invid\r\n"
				+ "left join itemproduct as p on t.ipid = p.id\r\n"
				+ "group by i.id ;\r\n";
		List<hw_Invoice> hw_Ins=jdbcTemplate.query(sql2, new BeanPropertyRowMapper(hw_Invoice.class));
				
			//設定關聯
			hw_In.sethw_Invoice(hw_Ins);
				
			return hw_In;
		});
		return hw_Invoices;
	}
		
		
		
	public List<hw_Invoice> queryhw_Invoices4() {
		//每一樣商品個賣了多少錢?
		String sql ="select p.text, sum(p.price*i.amount)";
		List<hw_Invoice> hw_Invoices = jdbcTemplate.query(sql, (ResultSet rs,int rowNum)->{
			hw_Invoice hw_In = new hw_Invoice();
			//設定欄位
			hw_In.setTest(rs.getString("test"));
			hw_In.setPrice(rs.getInt("price"));
			hw_In.setAmount(rs.getInt("amount"));
				
		String sql2="from itemproduct as p\r\n"
				+ "left join item as i on i.ipid=p.id\r\n"
				+ "group by p.id;";
		List<hw_Invoice> hw_Ins=jdbcTemplate.query(sql2, new BeanPropertyRowMapper(hw_Invoice.class));
				
			//設定關聯
			hw_In.sethw_Invoice(hw_Ins);
				
			return hw_In;
		});
		return hw_Invoices;
	}
		
		
		
	public List<hw_Invoice> queryhw_Invoices5() {
		//哪一件商品賣的錢最多?
		String sql ="select temp.text, max(fee) from (\r\n"
				+ "select p.text, sum(p.price*i.amount) as fee";
		List<hw_Invoice> hw_Invoices = jdbcTemplate.query(sql, (ResultSet rs,int rowNum)->{
			hw_Invoice hw_In = new hw_Invoice();
			//設定欄位
			hw_In.setTest(rs.getString("test"));
			hw_In.setPrice(rs.getInt("price"));
			hw_In.setAmount(rs.getInt("amount"));
				
		String sql2="from itemproduct as p\r\n"
				+ "left join item as i on i.ipid=p.id\r\n"
				+ "group by p.id) as temp;";
		List<hw_Invoice> hw_Ins=jdbcTemplate.query(sql2, new BeanPropertyRowMapper(hw_Invoice.class));
				
			//設定關聯
			hw_In.sethw_Invoice(hw_Ins);
				
			return hw_In;
		});
		return hw_Invoices;
	}
		
		
		
	public List<hw_Invoice> queryhw_Invoices6() {
		//哪一張發票價值最高?
		String sql ="select temp.id, temp.idate, max(fee) from \r\n"
				+ "(select i.id , i.invdate as idate, sum(t.amount*p.price) as fee";
		List<hw_Invoice> hw_Invoices = jdbcTemplate.query(sql, (ResultSet rs,int rowNum)->{
			hw_Invoice hw_In = new hw_Invoice();
			//設定欄位
			hw_In.setInid(rs.getInt("id"));
			hw_In.setInvdate(rs.getInvdate("invdate"));
			hw_In.setTest(rs.getString("test"));
			hw_In.setPrice(rs.getInt("price"));
			hw_In.setAmount(rs.getInt("amount"));
				
		String sql2="from invoice as i   \r\n"
				+ "left join item as t on i.id=t.invid\r\n"
				+ "left join itemproduct as p on t.ipid = p.id\r\n"
				+ "group by i.id) as temp ;";
		List<hw_Invoice> hw_Ins=jdbcTemplate.query(sql2, new BeanPropertyRowMapper(hw_Invoice.class));
				
			//設定關聯
			hw_In.sethw_Invoice(hw_Ins);
				
			return hw_In;
		});
		return hw_Invoices;
	}
}
*/