/* 10*10 2차원배열
 * 무조건 오른쪽으로 이동 벽 또는 장해물을 만나면 아래쪽으로 이동
 * 먹이를 발견하거나 맨 아래의 가장 오른쪽에 도착한 경우,
 * 더 이상 움직일 수 없는 경우 멈춤
 * 2,2에서 출발
 * 지나간 곳은 9로 표현
 * 0 : 갈 수 있는 곳 
 * 1 : 벽 또는 장해물
 * 2 : 먹이
 * */
package OnGo;

import java.util.Scanner;

public class Problem9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[][] str = new String[10][];
	
		for(int i = 0; i < str.length; i++) {
			str[i] = sc.nextLine().split(" ");
		}
		int x = 1;
		int y = 1;
		while(true) {
			if(str[x][y].equals("2") ) {
				str[x][y] = "9";
				break;
			}
			str[x][y] = "9";
			if(str[x][y+1].equals("0")) {
				y++;
			}else if(str[x][y+1].equals("1")){
				x++;
			}else {
				str[x][y+1] = "9";
				break;
			}
			if(x == 9 || y == 9){
				break;
			}
		}
		
	
		for(String[] i : str) {
			for(String j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
	}

}
