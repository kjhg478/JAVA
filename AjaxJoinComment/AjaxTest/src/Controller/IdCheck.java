package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import Service.IdCheckService;



@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("id");
		int result = 0;
		System.out.println(userId);

		String Url = request.getRequestURL().toString();
		System.out.println("URL : " + Url);
		IdCheckService mis = new IdCheckService();
		result = mis.IdCheck(userId);
		System.out.println(result);
		
		JSONObject obj = new JSONObject();
		
		obj.put("cnt",result);
		System.out.println(obj);
		String data = obj.toString();
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().write(data);	

	}

}
