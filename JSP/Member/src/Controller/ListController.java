package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserInfoBean;
import Service.ListServices;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/ListController")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserInfoBean uib = new UserInfoBean();
		
		ArrayList<UserInfoBean> list = new ArrayList<UserInfoBean>();
		ListServices ls = new ListServices();
		
		list = ls.memberList();
		System.out.println(list.get(0).getUserId());
		
//		request.setAttribute("id", list.get(0).getUserId());
//		request.setAttribute("pw", list.get(0).getUserPwd());
//		request.setAttribute("name", list.get(0).getUserName());
//		request.setAttribute("birth", list.get(0).getUserBirth());
//		request.setAttribute("gender", list.get(0).getUserGender());
//		request.setAttribute("email", list.get(0).getUserEmail());
		
		request.setAttribute("member1", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberList.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
