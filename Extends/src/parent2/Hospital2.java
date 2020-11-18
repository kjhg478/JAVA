package parent2;

// 추상 메소드 : 구현하지 않은 메소드 ( {}가 없는 메소드 )
// 추상 클래스 : 추상 메소드를 가진 클래스 -> new 불가능 // 객체 생성 불가능 

// 인터페이스 : 추상메소드만 가진다
interface Cryable {
	public void cry();
}
interface Movable {
	public void move();
}


class Cat implements Cryable, Movable {
	public void cry() {System.out.println("야옹 야옹");}
	public void move() {System.out.println("뛰어갑니다");}
}
class 비둘기 implements Cryable, Movable{
	//	public void mung() {System.out.println("멍멍멍");}
	// 어노테이션 (annotation) 
	@Override
	public void cry() {
		System.out.println("멍멍멍");

	}
	public void move() {System.out.println("날아갑니다");}
}

/* 그러면 이름 어떻게 맞출꺼냐
    method(중괄호)를 지우고 세미콜론

class 동물병원 {
	public void inject(가축 ob) {
		ob.cry();
	}
		public void inject(고양이 ob) { 필요가 없어짐 위쪽에서 변경이 되도 이 밑에는 변동사항이 없어야 함! (영향을 주고받지 않음)
			ob.cry();
		}
} */

public class Hospital2 {

}
