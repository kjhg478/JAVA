package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.memberDTO;
import service.mListService;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/memberList")
public class mListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public mListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ArrayList<memberDTO> memberList = new ArrayList<memberDTO>();
		mListService listsvc = new mListService();
		
		memberList = listsvc.memberList();
		// service에서 return받은 memberList
		
		request.setAttribute("member1", memberList);
		RequestDispatcher dispatcher 
		= request.getRequestDispatcher("MemberList.jsp");
		dispatcher.forward(request, response);
		// memberList의 값을 member1에 담아서
		// MemberList.jsp로 이동한다.
		
		
	}
	

}















