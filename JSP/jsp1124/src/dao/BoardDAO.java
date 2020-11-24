package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static db.JdbcUtil.*;

import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// getInstance메소드
	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	// setConnection 메소드
	public void setConnection(Connection con) {
		this.con = con;
	}

	// 글작성하기
	public int bWrite(BoardDTO board) {
		System.out.println("3.dao");
		String sql = "INSERT INTO BOARDT VALUES(?,?,?,?,sysdate)";
		int writeResult = 0;
		
		try {
			System.out.println("4.DB");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getbWriter());
			pstmt.setString(2, board.getbPassword());
			pstmt.setString(3, board.getbTitle());
			pstmt.setString(4, board.getbContent());
			writeResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("5.dao : " + writeResult);
		return writeResult;
	}

	public ArrayList<BoardDTO> BoardList() {
		String sql = "SELECT * FROM BOARDT";
		
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		BoardDTO board= null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardDTO();
				
				board.setbWriter(rs.getString(1));
				board.setbPassword(rs.getString(2));
				board.setbTitle(rs.getString(3));
				board.setbContent(rs.getString(4));
				board.setbDate(rs.getString(5));
				
				boardlist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardlist;
	}

	public int BoardDel(String bTitle) {
		int delResult = 0;
		String sql = "DELETE BOARDT WHERE bTitle=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			delResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return delResult;
	}

	public BoardDTO BoardView(String bTitle) {
		BoardDTO board = new BoardDTO();
		String sql = "SELECT * FROM BOARDT WHERE BTITLE = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setbWriter(rs.getString(1));
				board.setbPassword(rs.getString(2));
				board.setbTitle(rs.getString(3));
				board.setbContent(rs.getString(4));
				board.setbDate(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println("dao :: "+board.toString());
		return board;
	}

	public int modiPro(BoardDTO board) {
		String sql = "UPDATE BOARDT SET BWRITER=?, BPASSWORD=?, BCONTENT=? WHERE BTITLE=?";
		int proResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getbWriter());
			pstmt.setString(2, board.getbPassword());
			pstmt.setString(3, board.getbContent());
			pstmt.setString(4, board.getbTitle());
			proResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return proResult;
	}
}












