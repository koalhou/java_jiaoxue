package servlet;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6606712356970582929L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request,response);
		// System.out.println();
		ServletInputStream sis = request.getInputStream();
		DataInputStream dataInStream = new DataInputStream(sis);
		byte[] buf = new byte[1024];
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		int n = dataInStream.read(buf);
		while (n != -1) {
			os.write(buf, 0, n);
			n = dataInStream.read(buf);
		}
		byte[] res = os.toByteArray();
		System.out.println(new String(res));
		
//		
//		
//		String para = getInitParameter("");
//		
//		String x = getServletInfo();
//		
//		System.out.println(x);
//		
//		
//		
//		ServletContext sc = getServletContext();
//		RequestDispatcher rd = sc.getRequestDispatcher("");
//		rd.forward(request, response);
		response.getWriter().write("These words is from HttpServer , the POST method is called  !!!");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String pageflag = request.getParameter("pageflag");
		String pageno = request.getParameter("pageno");
		System.out.println("-------------");
		response.getWriter().write("These words is from HttpServer , the GET method is called  !!!");
	}
}
