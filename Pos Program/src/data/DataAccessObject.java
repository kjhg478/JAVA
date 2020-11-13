package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DataAccessObject {

	Connection ct;
	PreparedStatement query;
	ResultSet rs;


	public void setAutoTransaction(boolean tran) {
		try {
			if(ct != null && !ct.isClosed()) {
				ct.setAutoCommit(tran);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public void endAutoTransaction(boolean tran) {
		try {
			if(!ct.isClosed()) {
				if(tran) {
					ct.commit();
				}else {
					ct.rollback();
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {

				if(ct != null && !ct.isClosed()) ct.close();
				if(query != null && !query.isClosed()) query.close();
				if(rs != null &&!rs.isClosed()) rs.close();

			} catch (SQLException e) {e.printStackTrace();}
		}
	}



	/*JDBC - ORACLE
	 * 1. DRIVER LOAD
	 * 2. CONNECTION 생성 :: DriverManager.getConnection(servInfo,uid,pwd)
	 * 3. DML OR QL 작성
	 * 4. Statement or PreparedStatement 로 데이터 요청
	 * 5. int or Resuultset 으로 데이터 받기
	 * 6. Resultset 을 사용한 경우 ArrayList<E>에 담기
	 * 7. 요청클래스에서 필요로 하는 데이터 리턴 :: boolean, ArrayList<E>, int
	 */


	// 생성자에서 DB연동
	public DataAccessObject(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ct = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.220:1521:xe","DOOLY","0000");

		} catch (Exception e) {
			System.out.println("Error of Failed");
		}
	}




	// 직원코드 여부 확인
	public boolean isEmployee(UserInfoBean uib) {
		boolean result = false;

		// statement  방식이라면 "SELECT COUNT(*)  FROM EM WHERE EM_STCODE = \'"+uib.getStCode()+"\' AND EM_CODE = \'"+uib.getEmployeeCode()+"\'"
		String sql = "SELECT COUNT(*) AS ISEM FROM EM WHERE EM_STCODE = ? AND EM_CODE = ?";

		try {
			// prepared statement 사용준비 
			query = ct.prepareStatement(sql);
			// nstring으로 보내주고 첫번째 ? 값을 가져온다
			query.setNString(1, uib.getStCode());
			query.setNString(2, uib.getEmployeeCode());
			// excute로 보내면 이건 resultset으로 반환되기에 resultset 타입으로 받아준다.
			rs = query.executeQuery();

			//resultset의 next는 한줄이 있으면 값이 ture 아니면 false를 반환한다.
			while(rs.next()) {
				// as 값을 입력하여 이값이 있으면 true 아니면 false를 result에 넣어준다.
				result = (rs.getInt("ISEM")==1)?true:false;

			}
		} catch (SQLException e) {
			System.out.println(" [아이디가 달라요!]");
		}

		return result;
	}



	// 패스워드 여부 확인
	public boolean isAccess(UserInfoBean uib) { 
		boolean result = false;



		String sql = "SELECT COUNT(*) AS ISAC FROM EM WHERE EM_STCODE = ? AND EM_CODE = ? AND EM_PWD = ?";

		try {

			query = ct.prepareStatement(sql);

			query.setNString(1, uib.getStCode());
			query.setNString(2, uib.getEmployeeCode());
			query.setNString(3, uib.getAccessCode());

			rs = query.executeQuery();

			while(rs.next()) {

				result = (rs.getInt("ISAC")==1)?true:false;

			}
		} catch (SQLException e) {
			System.out.println(" [비밀번호가 달라요!]");
		}

		return result;
	}


	// 특정 직원정보 가져오기
	public void getUserInfo(UserInfoBean uib, ArrayList<UserInfoBean> userinfo) {

		String sql = "SELECT STCODE, EMCODE, EMNAME, EMLEVEL, MAX(ACC) AS ACC\r\n"
				+ "FROM ACCINFO\r\n"
				+ "WHERE EMCODE = ? AND STCODE = ?\r\n"
				+ "GROUP BY  STCODE, EMCODE, EMNAME, EMLEVEL";

		try {

			query = ct.prepareStatement(sql);

			query.setNString(1, uib.getEmployeeCode());
			query.setNString(2, uib.getStCode());


			rs = query.executeQuery();

			while(rs.next()) {

				uib.setEmployeeCode(rs.getNString("EMCODE"));
				uib.setUserName(rs.getNString("EMNAME"));
				uib.setUserLevel((rs.getNString("EMLEVEL").equals("M"))?true:false);
				uib.setAccessTime(rs.getNString("ACC"));
				uib.setStCode(rs.getString("STCODE"));

				userinfo.add(uib);

			}

		} catch (SQLException e) {
			System.out.println(" [직원 정보가 없네요!]");
		}

	}



	// 로그인기록 남기기
	public boolean setLogInInfo(UserInfoBean uib) {

		boolean result = false;
		String sql = "INSERT INTO HI(HI_EMCODE, HI_ACCDATE, HI_STATE, HI_EMSTCODE) VALUES (?,DEFAULT,?,?)";

		try {

			query = ct.prepareStatement(sql);

			query.setNString(1, uib.getEmployeeCode());
			query.setInt(2, uib.getAccessState());
			query.setNString(3, uib.getStCode());


			if(query.executeUpdate()==1) {
				result = true;
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result; 
	}

	// 사용자 정보 저장
	public boolean setUserReg(UserInfoBean uib) {
		boolean result = false;

		String sql = "INSERT INTO EM(EM_STCODE, EM_CODE, EM_PWD, EM_NAME, EM_LEVEL) VALUES (?,?,?,?,?)"; 
		try {

			query = ct.prepareStatement(sql);
			query.setNString(1,uib.getStCode());
			query.setNString(2,uib.getEmployeeCode());
			query.setNString(3,uib.getAccessCode());
			query.setNString(4,uib.getUserName());
			query.setNString(5,uib.isUserLevel()?"M":"A");

			result = (query.executeUpdate()==1)?true:false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 빈 리스트 안에 값넣기
	public ArrayList<UserInfoBean> getUserInfoMod() {
		ArrayList<UserInfoBean> al = new ArrayList<UserInfoBean>();




		return al;
	}
	// 빈 리스트값 덮어씌우기
	public boolean setUserInfoMod(UserInfoBean uib) {
		boolean result = false;

		String sql = "UPDATE EM SET EM_PWD = ? WHERE EM_CODE = ?";

		try {

			query = ct.prepareStatement(sql);
			query.setNString(1, uib.getAccessCode());
			query.setNString(2, uib.getEmployeeCode());

			result = (query.executeUpdate()==1)? true:false;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return result;
	}
	// 상품정보 가져오기
	public boolean getGoodsInfo(GoodsInfoBean gib) {
		boolean result = false;
		String sql = "SELECT GO_CODE AS GOCODE, GO_NAME AS GONAME, GO_PRICE AS PRICE, MIN(SC_EXPIRE) AS EXPIRE\r\n"
				+ "FROM GO INNER JOIN SC ON GO.GO_CODE = SC.SC_GOCODE\r\n"
				+ "WHERE GO_CODE = ? AND SYSDATE <= SC_EXPIRE\r\n"
				+ "GROUP BY GO_CODE, GO_NAME, GO_PRICE";

		try {
			query = ct.prepareStatement(sql);
			query.setNString(1, gib.getGoodsCode());

			rs = query.executeQuery();

			while(rs.next()) {
				gib.setGoodsCode(rs.getNString("GOCODE"));
				gib.setGoodsName(rs.getNString("GONAME"));
				gib.setGoodsPrice(rs.getInt("PRICE"));
				gib.setGoodsqty(1);
				gib.setExpireDate(rs.getNString("EXPIRE"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	// 상품 정보 등록하기
	public boolean stackSalesInfo(GoodsInfoBean gib, int count, UserInfoBean uib) {
		String sql;
		boolean result = false;
		if(count==0) {

			sql = "INSERT INTO OD(OD_CODE, OD_EMSTCODE, OD_EMCODE, OD_CMCODE, OD_STATE) VALUES (TO_DATE(?,\'YYYYMMDDHH24MISS\'),?,?,?,?)";

			try {
				query = ct.prepareStatement(sql);
				query.setNString(1, uib.getToday());
				query.setNString(2, uib.getStCode());
				query.setNString(3, uib.getEmcode());
				query.setNString(4, uib.getCmcode());
				query.setNString(5, "P");

				query.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		sql = "INSERT INTO OT(OT_ODCODE,OT_GOCODE,OT_QTY,OT_STATE) VALUES (TO_DATE(?, \'YYYYMMDDHH24MISS\'),?,?,?)";
		try {
			query = ct.prepareStatement(sql);
			query.setNString(1, uib.getToday());
			query.setNString(2, gib.getGoodsCode());
			query.setInt(3, gib.getGoodsqty());
			query.setNString(4, "P");


			query.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}






public boolean stackSalesInfo(int fileIndex,GoodsInfoBean gib) {
	boolean result = false;

	return result;
}

public ArrayList<GoodsInfoBean> getSalesList(GoodsInfoBean gib,int fileIndex) {
	ArrayList<GoodsInfoBean> salesList = new ArrayList<GoodsInfoBean>();

	return salesList;
}

public void goodsReg(int fileIndex, GoodsInfoBean gib) {

}


public ArrayList<GoodsInfoBean> goodsGetAll(int fileIndex) {

	ArrayList<GoodsInfoBean> goodsList = new ArrayList<GoodsInfoBean>();

	return goodsList;
}




// GOODS HISTORY 가져오기
public ArrayList<GoodsInfoBean> goodsGetHis(GoodsInfoBean gib) {

	ArrayList<GoodsInfoBean> goodsList = new ArrayList<GoodsInfoBean>();
	String temp = gib.getUniqCode();
	String sql;
	if (temp.length()==8) {
		sql = "SELECT GOCODE, GONAME, GOPRICE, SUM(QTY) AS QTY, SUM(AMOUNT) AS AMOUNT\r\n"
				+ "FROM HISGOINFO\r\n"
				+ "WHERE TO_CHAR(ODCODE,'YYYYMMDD') = ?\r\n"
				+ "GROUP BY GOCODE, GONAME, GOPRICE";
	}else {
		sql = "SELECT GOCODE, GONAME, GOPRICE, SUM(QTY) AS QTY, SUM(AMOUNT) AS AMOUNT\r\n"
				+ "FROM HISGOINFO\r\n"
				+ "WHERE TO_CHAR(ODCODE,'YYYYMM') = ?\r\n"
				+ "GROUP BY GOCODE, GONAME, GOPRICE";
	}


	try {
		query = ct.prepareStatement(sql);
		query.setNString(1,temp);

		rs = query.executeQuery();

		while(rs.next()) {
			gib = new GoodsInfoBean();

			gib.setGoodsCode(rs.getNString("GOCODE"));
			gib.setGoodsName(rs.getNString("GONAME"));
			gib.setGoodsPrice(rs.getInt("GOPRICE"));
			gib.setGoodsqty(rs.getInt("QTY"));
			gib.setAmount(rs.getInt("AMOUNT"));

			goodsList.add(gib);
		}


	} catch (SQLException e) {
		System.out.println(" [등록된 정보가 없어요]");
	}



	return goodsList;
}



public void goodsPriceMod(int fileIndex, ArrayList<GoodsInfoBean> goodsList) {


}
}



