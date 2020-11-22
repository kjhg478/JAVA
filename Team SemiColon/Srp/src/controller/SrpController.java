package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SrpDao;
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
    	
    
    	SrpServices ss = new SrpServices();
    	SrpBean sb = new SrpBean();
    	
    	
    	String id = request.getParameter("TeId");
    	String pw = request.getParameter("TePw");
    	
		sb.setId(id);
		sb.setPw(pw);
    	
		if(ss.SrpDb(sb)) {	
    		RequestDispatcher dispatcher = request.getRequestDispatcher("SrpInfo.jsp");
    		String[] str = new String[6];
    		str[0] = sb.getTename();
    		str[1] = sb.getSuname();
    		str[2] = sb.getTelevel();
    		str[3] = sb.getGrcode();
    		str[4] = sb.getClcode();
    		str[5] = sb.getStclcode();
    		request.setAttribute("info", str);
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
