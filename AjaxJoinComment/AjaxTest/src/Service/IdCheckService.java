package Service;

import java.sql.Connection;

import Dao.DAO;
import static Db.JdbcUtil.*;

public class IdCheckService {

	public int IdCheck(String userId) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		int result = 0;
		
		result = dao.IdCheck(userId);
		close(con);
		
		return result;
	}

}