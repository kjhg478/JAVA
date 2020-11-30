package services;

import static dao.BoardDAO.getInstance;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class WriteServices {

	public int Write(BoardDTO dto) {
		BoardDAO dao2 = getInstance();
		Connection con = getConnection();
		dao2.setConnection(con);
		
		int result = dao2.Write(dto);
		if(result > 0) {
			commit(con);
			close(con);
		}else {
			rollback(con);
			close(con);
		}
		
		return result;
	}

}
