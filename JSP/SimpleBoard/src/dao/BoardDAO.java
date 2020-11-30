package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.BoardDTO;
import static db.JdbcUtil.*;

public class BoardDAO {
	private static BoardDAO dao2;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// getInstance메소드
	public static BoardDAO getInstance() {
		if (dao2 == null) {
			dao2 = new BoardDAO();
		}
		return dao2;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	public int Write(BoardDTO dto) {
		String sql = "INSERT INTO BOARD_SY VALUES (SEQ_SOYUN.NEXTVAL,?,?,?,?,SYSDATE,0,?)";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, dto.getTitle());
			pstmt.setNString(2, dto.getName());
			pstmt.setNString(3, dto.getPassword());
			pstmt.setNString(4, dto.getContent());
			pstmt.setNString(5, dto.getFile());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int BoardCount() {
		String sql = "SELECT COUNT(*) FROM BOARD_SY";
		
		int boardCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return boardCount;
	}

	public ArrayList<BoardDTO> boardList(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLIST_SY WHERE RN BETWEEN ? AND ?";
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setNum(rs.getInt(1));
				dto.setName(rs.getNString(2));
				dto.setPassword(rs.getNString(3));
				dto.setTitle(rs.getNString(4));
				dto.setContent(rs.getNString(5));
				dto.setDate(rs.getNString(6));
				dto.setHit(rs.getInt(7));
				dto.setFile(rs.getNString(8));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(list.toString());
		return list;
	}

	public BoardDTO BoardDetail(int num) {
		BoardDTO dto = new BoardDTO();
		String sql = "SELECT * FROM BOARD_SY WHERE BNUM = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getInt(1));
				dto.setName(rs.getNString(2));
				dto.setPassword(rs.getNString(3));
				dto.setTitle(rs.getNString(4));
				dto.setContent(rs.getNString(5));
				dto.setDate(rs.getNString(6));
				dto.setHit(rs.getInt(7));
				dto.setFile(rs.getNString(8));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return dto;
	}

	public int Boardhit(int num) {
		String sql = "UPDATE BOARD_SY SET BHIT = BHIT+1 WHERE BNUM=?";
		int hit = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			hit = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return hit;
	}

}
