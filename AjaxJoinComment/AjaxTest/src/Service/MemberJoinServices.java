package Service;

import static Db.JdbcUtil.close;
import static Db.JdbcUtil.commit;
import static Db.JdbcUtil.getConnection;
import static Db.JdbcUtil.rollback;

import java.sql.Connection;

import Dto.MemberDTO;
import Dao.DAO;

public class MemberJoinServices {

	public int memberJoin(MemberDTO member) {
		DAO dao = DAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int result = dao.memberJoin(member);
		
		if(result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}
