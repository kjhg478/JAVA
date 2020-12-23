package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDTO;
import Service.MemberJoinServices;

@WebServlet("/memberJoin")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
    	String id = request.getParameter("id");
    	String pw = request.getParameter("password");
    	String name = request.getParameter("name");
    	String team = request.getParameter("team");

    	
    	MemberDTO member = new MemberDTO();
    	member.setUserId(id);

    	member.setUserPw(pw);
    	member.setUserName(name);
    	member.setUserGroup(team);

    	
    	MemberJoinServices mjs = new MemberJoinServices();
    	int result = mjs.memberJoin(member);
    	PrintWriter out = response.getWriter();
    	if(result > 0) {
    		out.println("<script>alert('SUCCESS!');</script>");
			out.println("<script>location.href='index.html';</script>");
    	} else {
    		out.println("<script>alert('FAIL!');</script>");
			out.println("<script>location.href='index.html';</script>");
    	}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
