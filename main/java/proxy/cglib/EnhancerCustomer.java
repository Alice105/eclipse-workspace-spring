package proxy.cglib;

//Enhancer 增強型的 Customer
public class EnhancerCustomer extends Customer {

	@Override
	public String buy(String data) {
		return super.buy(data) + " 請先出示實聯";
	}
}

