package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.BoardDTO;
import services.WriteServices;

@WebServlet("/WriteController")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteController() {
        super();
    }
	
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int size = 10 * 1024 * 1024;
		String Path = "D:/Project/Jsp1126/WebContent/UploadFile";
		
		MultipartRequest mr = new MultipartRequest(
				request, // 담아온 정보
				Path,
				size,
				"UTF-8",
				new DefaultFileRenamePolicy() // 중복 방지
		);
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle(mr.getParameter("bTitle"));
		dto.setName(mr.getParameter("bName"));
		dto.setPassword(mr.getParameter("bPass"));
		dto.setContent(mr.getParameter("bContent"));
		dto.setFile(mr.getOriginalFileName((String)mr.getFileNames().nextElement()));
		
		WriteServices ws = new WriteServices();
		
		int result = ws.Write(dto);
		
		if(result > 0) {
			response.sendRedirect("BoardListController");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WriteFail.jsp");
			request.setAttribute("Writefail", "글작성 실패 !");
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
