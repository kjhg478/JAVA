package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.WriteService;

@WebServlet("/boardWrite")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public WriteController() {
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
		System.out.println("1.controller");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BoardDTO board = new BoardDTO();
		
		board.setbWriter(request.getParameter("bWriter"));
		board.setbPassword(request.getParameter("bPassword"));
		board.setbTitle(request.getParameter("bTitle"));
		board.setbContent(request.getParameter("bContent"));
		
		System.out.println("1-1." +board.toString());
		
		WriteService writesvc = new WriteService();
		int writeResult = writesvc.bWrite(board);
		System.out.println("7.controller : " + writeResult);
		
		if(writeResult>0) {
			response.sendRedirect("bList");
		} else {
			response.sendRedirect("WriteFail.jsp");
		}
	}

}
