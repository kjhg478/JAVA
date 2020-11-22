package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.JdbcUtil;
import dto.SrpBean;

public class SrpDao {
	
	private static SrpDao dao;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public static SrpDao getInstance() {
		if(dao == null) {
			dao = new SrpDao();
		}
		
		return dao;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	public boolean Login(SrpBean sb) {
		boolean result = false;
		String sql = "SELECT COUNT(*) FROM TE WHERE TE_CODE = ? AND TE_PWD = ?"; 
	
		try {
			ps = con.prepareStatement(sql);
			
			ps.setNString(1, sb.getId());
			ps.setNString(2, sb.getPw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = (rs.getInt(1)==1)? true:false;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
				
	}
	
	
	public void SrpDao(SrpBean sb) {
		ArrayList<SrpBean> list = new ArrayList<SrpBean>();

		String sql = "SELECT TE_NAME TE, SU_NAME SU, TE_LEVEL TL, TE_GRCODE TR, TE_CLCODE TC, COUNT(ST_CLCODE) ST \r\n" + 
					  "FROM TE INNER JOIN SU ON TE_SUCODE = SU_CODE INNER JOIN ST ON ST_GRCODE = TE_GRCODE AND ST_CLCODE = TE_CLCODE \r\n" + 
					  "WHERE TE_CODE = ? \r\n" + 
					  "GROUP BY TE_NAME, SU_NAME, TE_LEVEL, TE_GRCODE, TE_CLCODE";
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setNString(1, sb.getId());
			
			rs = ps.executeQuery(); // 쿼리를 설정시켜놨어 sql로 쓰면 저 쿼리문 가지고 다시간다? 준비했던거 다 무시하고
			
			while(rs.next()) {
		
				sb.setTename(rs.getNString("TE"));
				sb.setSuname(rs.getNString("SU"));
				sb.setTelevel(rs.getNString("TL"));
				sb.setGrcode(rs.getNString("TR"));
				sb.setClcode(rs.getNString("TC"));
				sb.setStclcode(rs.getNString("ST"));
	
				
			}
			JdbcUtil.close(ps);
			JdbcUtil.close(rs);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}



}
