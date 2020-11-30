package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import services.JoinServices;


/**
 * Servlet implementation class JoinController
 */
@WebServlet("/JoinController")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDTO mem = new MemberDTO();
		
		mem.setUserId(request.getParameter("userId"));
		mem.setUserPw(request.getParameter("userPw"));
		mem.setUserName(request.getParameter("userName"));
		mem.setUserGender(request.getParameter("userGender"));
		mem.setUserBirth(request.getParameter("userBirth"));
		mem.setUserMail(request.getParameter("userEmail"));
	
		
		JoinServices js = new JoinServices();
		
		int result = js.UserInfo(mem);
		System.out.println(result);
		if(result > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("JoinSuccess.jsp");
			request.setAttribute("success", "회원가입 완료!");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("JoinFail.jsp");
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
