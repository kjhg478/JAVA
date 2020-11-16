package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class stuInfo
 */
@WebServlet({ "/stuInfo", "/stuInfo1" })
public class stuInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stuInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	// 1. 이동할 JSP를 설정해주는 dispatcher 방식
    	RequestDispatcher dispatcher = request.getRequestDispatcher("FormResult.jsp");
    	
    	String sName = request.getParameter("sName");
    	String sId = request.getParameter("sId");
    	String value = request.getParameter("value");
    	
    	System.out.println("sName : " + sName);
    	System.out.println("sId : " + sId);
    	System.out.println("임의의 값 : " + value);
    	
    	// 2. 정보를 저장
    	request.setAttribute("sName1", sName);
    	request.setAttribute("sId1", sId);
    	request.setAttribute("sInfo1", value);
    	// Attribute : String 외에 Object, Array등 다양한 데이터 타입 입력가능 !
    	
    	
    	// 3. 실제로 jsp로 정보를 담아서 이동하는 구간
    	dispatcher.forward(request, response);
    	
//    	PrintWriter out = response.getWriter();
    	// html의 body 부분이라고 생각

//    	out.println("<h1>학생 정보 받아오기</h1>");
//    	out.println("<h3>이름 : "+ sName + "</h3>");
//    	out.println("<h3>아이디 : " + sid + " </h3>");
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doget !");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost !");
		doProcess(request, response);
	}

}
