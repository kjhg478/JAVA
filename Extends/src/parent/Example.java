package parent;

// 소프트웨어의 위기 --> 생산성 향상 -> 재사용

//상속
class Parent {
	int a = 1000;
}
class Child extends Parent {
	int b = 2000;
}

public class Example {
	public static void main(String[] args) {
		Child ob = new Child();
		System.out.println(ob.a);
		System.out.println(ob.b);
		
	}
}
