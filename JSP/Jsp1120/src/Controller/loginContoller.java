package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.UserInfoBean;
import Service.loginService;

/**
 * Servlet implementation class loginContoller
 */
@WebServlet("/loginContoller")
public class loginContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserInfoBean uib = new UserInfoBean();
		
		uib.setUserId(request.getParameter("id"));
		uib.setUserPwd(request.getParameter("pwd"));
		
		loginService is = new loginService();
		
		String loginId = is.getloginfo(uib);
		
		HttpSession session = request.getSession();
		
		if (loginId!=null) {
			session.setAttribute("loginId", loginId);
			response.sendRedirect("loginSuccess.jsp");
		}else {
			response.sendRedirect("loginFailjsp.jsp");}
//		if (loginId!=null) {
//			RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
//			request.setAttribute("name", loginId);
//			rd.forward(request, response);
//		} else {
//			RequestDispatcher rd = request.getRequestDispatcher("loginFailjsp.jsp");
//		rd.forward(request, response); }
		
	}

}










