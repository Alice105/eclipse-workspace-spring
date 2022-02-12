package proxy.cglib;

public class EnhancerTest {

	public static void main(String[] args) {
		// 使用子類別（加強）來代理
		Customer customer = new EnhancerCustomer();
		System.out.println(customer.buy("麵包"));
	}
}