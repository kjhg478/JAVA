package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import services.NickCheckServices;


@WebServlet("/nickCheck")
public class NickCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NickCheckController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("nick");
		System.out.println(id);
		
		NickCheckServices nc = new NickCheckServices();
		
		String result = nc.NickCheck(id);
		
		
		System.out.println(result);
		JSONObject obj = new JSONObject();
		
		obj.put("nick", result);
		
		String total = obj.toString();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(total);
		
		
	}

}
