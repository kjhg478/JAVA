package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserInfoBean;
import Service.memberservice;

/**
 * Servlet implementation class memberJoin
 */
@WebServlet("/memberJoin")
public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinController() {
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
		memberservice membersvc = new memberservice();
		
		uib.setUserId(request.getParameter("id"));
		uib.setUserPwd(request.getParameter("pwd"));
		uib.setUserName(request.getParameter("name"));
		uib.setUserBirth(request.getParameter("birth"));
		uib.setUserGender(request.getParameter("gender"));
		uib.setUserEmail(request.getParameter("email"));
		
		int result = membersvc.memberjoin(uib);
		if (result>0) {
			response.sendRedirect("joinSuccess.jsp");
		}else {
			response.sendRedirect("joinFail.jsp");
		}
		
	}

}

















