package Image;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class image
 */
@WebServlet("/image")
public class image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String[] background = request.getParameterValues("a1");
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("imageResult.jsp");
    	
//    	request.setAttribute("background1", background);
    	
    	for(int i = 0; i<background.length; i++) {
    		request.setAttribute("background"+i, background[i]);
    	}
    	
    	request.setAttribute("num", background.length);
    	
    	dispatcher.forward(request, response);
    	
    	
//    	PrintWriter out = response.getWriter();
//    	
//    	out.println("<html>");
//    	out.println("<head>");
//    	out.println("<title> 이미지 선택 page </title>");
//    	out.println("<style>");
//    	out.println("body { background-color : orange; }");
//    	out.println("table { background-color : yellow }");
//    	out.println("</style>");
//    	out.println("</head>");
//    	out.println("<body>");
//    	out.println("<table>");
//    	out.println("<tr>");
//    	
//
//    	
//    
//    	out.println("</tr>");
//    	out.println("</table>");
//    	out.println("</body>");
//    	out.println("</html>");
    	

	}
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
