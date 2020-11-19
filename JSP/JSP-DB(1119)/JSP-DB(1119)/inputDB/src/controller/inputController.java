package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.inputService;

/**
 * Servlet implementation class inputServlet
 */
@WebServlet("/inputdb")
public class inputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public inputController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /*
     	DB에 data를 저장하는 과정
     	(1)input.jsp → (2)inputController("/inputdb")
     	→ (3)inputService → (4)inputDAO → (5)DB
     	→ (6)inputDAO → (7)inputService → (8)inputController
     	→ (9)inputSuccess.jsp
     
     
     */
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("(2)inputController");
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String input1 = request.getParameter("data1");
    	String input2 = request.getParameter("data2");

    	
    	// service 패키지의 inputService를 import
    	inputService inputsvc = new inputService();
    	
    	// input결과를 담기 위한 boolean타입의 inputResult 선언
    	boolean svcResult = inputsvc.inputDB(input1, input2);
    	
    	System.out.println("(8)inputController로 돌아옴");
		System.out.println("inputService에서 svcResult값을 return받음");
    	if(svcResult) {
    		// 성공페이지로 이동
    		RequestDispatcher dispatcher 
    		= request.getRequestDispatcher("inputSuccess.jsp");
    		dispatcher.forward(request, response);
    		System.out.println("(9)성공하면 success페이지 이동");
    		
    	} else {
    		// 실패페이지로 이동
    		RequestDispatcher dispatcher 
    		= request.getRequestDispatcher("inputFail.jsp");
    		dispatcher.forward(request, response);
    		System.out.println("(9)실패하면 fail페이지 이동");
    	}
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
