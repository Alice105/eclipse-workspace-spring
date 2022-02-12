package com.study.springcore.jdbc.entity;

import java.util.Date;

public class hw_Invoice {
	private Integer ItPrid;
	private String text;
	private Integer price;
	private Integer invantory;
	
	private Integer Inid;
	private Date invdate;
	
	private Integer Itid;
	private Integer ipid;
	private Integer invid;
	private Integer amount;
	
	
	public Integer getItPrid() {
		return ItPrid;
	}
	public void setItPrid(Integer itPrid) {
		ItPrid = itPrid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getInvantory() {
		return invantory;
	}
	public void setInvantory(Integer invantory) {
		this.invantory = invantory;
	}
	public Integer getInid() {
		return Inid;
	}
	public void setInid(Integer inid) {
		Inid = inid;
	}
	public Date getInvdate() {
		return invdate;
	}
	public void setInvdate(Date invdate) {
		this.invdate = invdate;
	}
	public Integer getItid() {
		return Itid;
	}
	public void setItid(Integer itid) {
		Itid = itid;
	}
	public Integer getIpid() {
		return ipid;
	}
	public void setIpid(Integer ipid) {
		this.ipid = ipid;
	}
	public Integer getInvid() {
		return invid;
	}
	public void setInvid(Integer invid) {
		this.invid = invid;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "hw_Invoice [ItPrid=" + ItPrid + ", text=" + text + ", price=" + price + ", invantory=" + invantory
				+ ", Inid=" + Inid + ", invdate=" + invdate + ", Itid=" + Itid + ", ipid=" + ipid + ", invid=" + invid
				+ ", amount=" + amount + "]";
	}
	
	
	
}
