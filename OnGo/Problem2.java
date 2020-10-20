/* 마라톤 심사위원 --> 화장실이 너무 가고싶음 
 * 그래서 선수들이 마라톤 완주를 했는지 안했는지 알아보고 싶음
 * 완주하지 못한 마지막 선수*/

package OnGo;

public class Problem2 {

	public static void main(String[] args) {

		String[] str = {"1", "2", "3", "4", "5", "6"};
		String[] str2 = {"2", "3", "4", "5", "6"};

		for (int i = 0; i < str.length; i++) {
			for(int j =0; j< str2.length; j++ ) {
				if(str[i].equals(str2[j])) {
					str[i] = "";
					str2[j] = "";
 
				}
			}
		}
		for (String aa : str) {
			System.out.print(aa);
		}
	}


}
