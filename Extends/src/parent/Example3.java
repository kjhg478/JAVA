package parent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 정사원 {
	public void calc() {
		
	}
}

class 계약직 {
	public void pay() {
		
	}
}

class 파트타이머 {
	public void getSalary() {
		
	}
}

public class Example3 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 22, 33);
		List<Object> list2 = Arrays.asList(new 정사원(), new 계약직(), new 파트타이머());
		// 바람직하지 않다.
		// 1. 했던 작업을 다시 한다.
		// 2. 복잡한 if문은 가능한한 사용을 자제
		for(Object ob : list) {
			if(ob instanceof 정사원)
				((정사원)ob).calc();
			else if (ob instanceof 계약직)
				((계약직)ob).pay();
		}
	}
}
