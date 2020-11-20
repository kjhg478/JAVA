package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public void Login(SrpBean sb) {
		
		String sql = "SELECT TE_CODE, TE_PWD FROM TE WHERE TE_CODE = ? AND TE_PWD = ?"; 
	
		try {
			ps = con.prepareStatement(sql);
			
			ps.setNString(1, sb.getId());
			ps.setNString(2, sb.getPw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				sb.setId(rs.getNString(1));
				sb.setPw(rs.getNString(2));
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
				
	}
	
	
	public ArrayList<SrpBean> SrpDao(ArrayList<SrpBean> list) {
		SrpBean sb = new SrpBean();

		String sql = "SELECT TENAME, SUNAME, TELEVEL, TEGRCODE, TECLCODE, STCLCODE FROM A1 INNER JOIN A2 ON A1.TESUCODE = A2.SUCODE";
		
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery(sql);
			
			while(rs.next()) {
				
				sb.setTename(rs.getNString("TENAME"));
				sb.setSuname(rs.getNString("SUNAME"));
				sb.setTelevel(rs.getNString("TELEVEL"));
				sb.setGrcode(rs.getNString("TEGRCODE"));
				sb.setClcode(rs.getNString("TECLCODE"));
				sb.setStclcode(rs.getNString("STCLCODE"));
				
				list.add(sb);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
			
	}



}
