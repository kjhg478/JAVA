package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import services.LoginServices;

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
		response.setContentType("text/html; charset=UTF-8");
		MemberDTO mem = new MemberDTO();
		
		HttpSession session = request.getSession();
		
		
		mem.setUserId(request.getParameter("userId"));
		mem.setUserPw(request.getParameter("userPw"));
		
		LoginServices login = new LoginServices();
		
		boolean result = login.Login(mem);
		String loginid = null;
		System.out.println(result);
		
		
		if(result) {
			loginid = login.LoginSession(mem);
			System.out.println(loginid);
		}else {
			
		}
		
		if(loginid != null) {
			session.setAttribute("loginSession", loginid);
			response.sendRedirect("Main.jsp"); // session을 저장하면 jsp 어디에서든지 그 세션을 유지함 !
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFail.jsp");
			request.setAttribute("fail", "로그인 실패 !");
			dispatcher.forward(request, response);
		}
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);

	}

}
