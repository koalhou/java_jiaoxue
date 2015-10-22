package struts_pre;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCommon extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5780044566203134699L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("您的请求已经到达ServletCommon的Get方法。");
		String flag = req.getParameter("flag");
		if(flag==null){
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp"); //定向的页面
			rd.forward(req, resp);
		}else{
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/login.jsp"); //定向的页面
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	
}
