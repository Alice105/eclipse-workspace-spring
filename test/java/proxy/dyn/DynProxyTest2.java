package proxy.dyn;


public class DynProxyTest2 {

	public static void main(String[] args) {
		Calc calc = (Calc)new DynProxy(new CalcImpl()).getProxy();
		System.out.println(calc.add(10, 20));
		System.out.println("-----------------------------------");
		
		Calc calc2 = (Calc)new DynProxy(new CalcImpl()).getProxy();
		//自行可以維護錯誤
		System.out.println(calc2.div(10, 0));
	}

}
