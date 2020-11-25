package service;

import static dao.BoardDAO.*;
import static db.JdbcUtil.*;


import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import dto.BoardDTO;

public class PageService {

	public int ListCount() {
		
		// 공통부분
		BoardDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		int listCount = dao.ListCount();
		close(con);
		return listCount;
	}

	public ArrayList<BoardDTO> BoardList(int startRow, int endRow) {
		// 공통부분
		BoardDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		System.out.println(startRow);
		System.out.println(endRow);
		
		ArrayList<BoardDTO> boardList = dao.BoardList(startRow, endRow);
		close(con);
		
		return boardList;
	}

}
