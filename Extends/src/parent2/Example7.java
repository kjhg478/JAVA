package parent2;


class Sample2 {
	int cnt1;
	static int cnt2;
	public Sample2() {
		cnt1++;
		cnt2++;
	}
}

public class Example7 {
	public static void main(String[] args) {
		Sample2 ob1 = new Sample2();
		Sample2 ob2 = new Sample2();
		new Sample2();
		new Sample2();
		System.out.println(ob1.cnt1);
		System.out.println(ob1.cnt2);
		System.out.println(ob2.cnt1);
		System.out.println(ob2.cnt2);
	}
}
