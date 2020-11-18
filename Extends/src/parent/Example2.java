package parent;


class AAA {
	int a;
}
class BBB extends AAA {
	int b;
}

public class Example2 {
	public static void main(String[] args) {
		BBB ob1 = new BBB();
		AAA ob2 = new AAA();
		AAA ob3 = new BBB();
//		BBB ob4 = new AAA();
	}
	
}
