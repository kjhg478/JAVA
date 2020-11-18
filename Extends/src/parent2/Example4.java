package parent2;

import java.util.Arrays;
import java.util.List;

class 사원 {
	public void pay() {
		
	}
}
class 정사원 extends 사원 {
	public void pay() {
		
	}
}
class 계약직 extends 사원 {
	public void pay() {
		
	}
}
class 파트타이머 extends 사원 {
	public void pay() {
		
	}
}
public class Example4 {
	public static void main(String[] args) {
		
		List<사원> list = Arrays.asList(new 정사원(), new 계약직(), new 파트타이머());
		// 부모와 자식이 똑같은 메소드를 가질 경우 자식 것을 호출한다 : override
		// 부모를 만든다
		// 자식의 메소드 이름을 통일한다
		// 부모에 메소드를 추가해 오버라이드 한다.
		for(사원 ob:list) {
			ob.pay();
		}
	}

}
