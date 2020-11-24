package service;

import static dao.BoardDAO.*;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class ViewService {

	public BoardDTO BoardView(String bTitle) {
		// 공통부분
		BoardDAO dao = getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		// 여기까지
		
		BoardDTO board = dao.BoardView(bTitle);
		close(con);
		return board;
	}

}
