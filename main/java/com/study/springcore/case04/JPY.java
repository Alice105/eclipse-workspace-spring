package com.study.springcore.case04;

public class JPY extends CurrencyImpl{
	private double value; 
	
	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}
	
	
}
