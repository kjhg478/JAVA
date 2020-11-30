package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import services.MemberViewServices;

/**
 * Servlet implementation class MemberViewController
 */
@WebServlet("/MemberViewController")
public class MemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//MemberDTO mem = new MemberDTO();
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
	/*	mem.setUserId(request.getParameter("userId"));
		mem.setUserPw(request.getParameter("안보이지롱"));
		mem.setUserName(request.getParameter("userName"));
		mem.setUserBirth(request.getParameter("userBirth"));
		mem.setUserGender(request.getParameter("userGender"));
		mem.setUserMail(request.getParameter("userEmail"));*/
		
		MemberViewServices mvs = new MemberViewServices();
		
		mvs.MemberList(list);
		
		request.setAttribute("member", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberList.jsp");
		
		dispatcher.forward(request, response);
		
		
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
