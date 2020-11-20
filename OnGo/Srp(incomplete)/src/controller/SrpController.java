package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Back.BackController;
import dto.SrpBean;
import service.SrpServices;

/**
 * Servlet implementation class srpcontroller
 */
@WebServlet(name = "SrpController", urlPatterns = { "/SrpController" })
public class SrpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SrpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	
    	
    	ArrayList<SrpBean> list = new ArrayList<SrpBean>();
    	String[] str;
    	String[] str2;
    	String id = request.getParameter("TeId");
  
    	String pw = request.getParameter("TePw");
    	
    	BackController bc = new BackController();
    
    	str = bc.Login(id, pw);

    
   
    	str2 = bc.stuinfo(list);

    		

    
    	
    	if(str[0].equals(id) && str[1].equals(pw)) {
        	
    		request.setAttribute("srp", list.get(0).getTename());
    		request.setAttribute("srp1", list.get(0).getSuname());
    		request.setAttribute("srp2", list.get(0).getTelevel());
    		request.setAttribute("srp3", list.get(0).getGrcode());
    		request.setAttribute("srp4", list.get(0).getClcode());
    		request.setAttribute("srp5", list.get(0).getStclcode());
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("SrpInfo.jsp");
    		
    		dispatcher.forward(request, response);
    		
    	}else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("fail.jsp");
    		dispatcher.forward(request, response);
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
