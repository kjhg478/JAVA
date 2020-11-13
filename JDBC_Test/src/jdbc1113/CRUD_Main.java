package jdbc1113;

import java.util.Scanner;

public class CRUD_Main {
	public static void main(String[] args) {
		// CRUD_Main 클래스만 main()함수 생성
		// CRUD_DTO, CRUD_SQL은 생성 X

		// CRUD
		// CREATE (생성)
		// READ(읽다), RETRIEVE(검색)
		// UPDATE(수정)
		// DELETE(삭제)

		// SQL문을 실행하기 위한 crud객체 선언
		CRUD_SQL crud = new CRUD_SQL();

		// 학생 정보를 담아오는 stu 객체 선언
		CRUD_DTO stu = new CRUD_DTO();

		Scanner sc = new Scanner(System.in);

		boolean run = true;
		int menu = 0;

		while(run) {
			System.out.println("=======================");
			System.out.println("1. DB접속	2. DB해제");
			System.out.println("3. 학생등록 	4. 학생조회");
			System.out.println("5. 데이터수정 	6. 학생삭제");
			System.out.println("7. 종료 ");
			System.out.println("=======================");
			System.out.println("메뉴선택 >> ");
			menu = sc.nextInt();


			switch (menu) {
			case 1:
				crud.connect();
				break;
			case 2:
				crud.conClose();
				break;
			case 3:
				System.out.println("학생 정보를 입력해주세요 !");
				System.out.println("이름 >> ");
				// 입력받은 값을 s_name에 담는다.
				String s_name = sc.next();
				//s_name의 값을 stu(CRUD_DTO)의 setStuName을 통해 stuName에 저장한다.
				stu.setStuName(s_name);
				System.out.println("나이 >> ");
				int s_age = sc.nextInt();
				stu.setStuAge(s_age);

				crud.stuJoin(stu);
				break;
			case 4:
				crud.select();
				break;
			case 5:
				System.out.println("바꿀 정보를 입력해주세요 !");
				System.out.println("원래 이름 >>");
				String s_name3 = sc.next();
				stu.setStuName2(s_name3);
				
				System.out.println("바꿀 이름 >> ");
				
				String s_name2 = sc.next();
				
				stu.setStuName(s_name2);
				System.out.println("바꿀나이 >> ");
				int s_age2 = sc.nextInt();
				stu.setStuAge(s_age2);
				
				crud.Modify(stu);
				break;
			case 6:
				System.out.println("삭제할 이름 >> ");
				String delName = sc.next();
				stu.setStuName(delName);
				crud.Delete(stu);
				break;
			case 7:
				run = false;
				System.out.println("시스템이 종료되었습니다 !");
				break;

			default:
				break;
			}
		}
	}
}

