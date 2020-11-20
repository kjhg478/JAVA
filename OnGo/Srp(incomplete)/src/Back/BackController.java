package Back;

import java.util.ArrayList;

import dto.SrpBean;
import service.SrpServices;

public class BackController {
	
	public BackController() {
		
	}
	
	public String[] Login(String id, String pw) {
		SrpBean sb = new SrpBean();
		sb.setId(id);
		sb.setPw(pw);
		sb.setServicecode(1);
		SrpServices ss = new SrpServices();

		ss.entrance(sb, null);
		
		String[] str = new String[2];
		
		str[0] = sb.getId();
		str[1] = sb.getPw();
		
		return str;
	}
	public String[] stuinfo(ArrayList<SrpBean> list) {
		
		SrpBean sb = new SrpBean();
		SrpServices ss = new SrpServices();
		sb.setServicecode(2);
		
		list = ss.entrance(sb, list);
		
		String[] info = new String[6];
		
		info[0] = list.get(0).getTename();
		System.out.println(info[0]);
		
		
		return info;
		
		
	}

}
