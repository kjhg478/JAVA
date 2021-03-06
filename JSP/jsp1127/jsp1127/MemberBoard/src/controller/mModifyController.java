package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDTO;
import service.mViewService;

/**
 * Servlet implementation class modifyController
 */
@WebServlet("/mmodifyForm")
public class mModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public mModifyController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		System.out.println("doGet으로 오냐?");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		System.out.println("doPost으로 오냐?");
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId1 = request.getParameter("userId1");
		
		
		
		  memberDTO memberModify = new memberDTO();
		  
		  mViewService viewsvc = new mViewService(); 
		  memberModify = viewsvc.memberView(userId1);
		  
		  System.out.println(memberModify.toString());
		  
		  RequestDispatcher dispatcher =
				  request.getRequestDispatcher("MemberModify.jsp");
		  System.out.println("durlRkwl");
		  request.setAttribute("memberModify", memberModify); 
		  dispatcher.forward(request, response);
		 
		
	}

}