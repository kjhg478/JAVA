package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.UserInfoBean;
import Service.LoginServices;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		UserInfoBean uib = new UserInfoBean();
//		String id = request.getParameter("userId");
//		String pw = request.getParameter("userPwd");
		
		uib.setUserId(request.getParameter("userId"));
		uib.setUserPwd(request.getParameter("userPwd"));
		LoginServices ls = new LoginServices();
		System.out.println(uib.getUserId());
		
		String loginid = ls.login(uib);
		
		HttpSession session = request.getSession();
		
		
		if(loginid != null) {
			session.setAttribute("loginid", loginid);
			response.sendRedirect("loginSuccess.jsp");
		}else {
			response.sendRedirect("loginFail.jsp");
		}
		
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
