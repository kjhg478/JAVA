package parent2;


// static은 this가지고 이해하면 된다. 

class Sample {
	int a= 10;
	static int b = 20;
	void funcA() { // this가 있음
		System.out.println(a);
		System.out.println(b);
	}
	static void funcB() { // this가 없음
//		System.out.println(a);
		System.out.println(b);
	}
}


public class Example6 {
	public static void main(String[] args) {
		// a는 일반멤버라 this로 식별해야 함
		
	}
}
