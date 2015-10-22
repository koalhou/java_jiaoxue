package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesGetter extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9150775514836119486L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null){
			Cookie cookie;
			for(int i=0;i<cookies.length;i++){
				cookie = cookies[i];
				System.out.println(cookie.getName() + ":" + cookie.getValue()); 
				resp.getWriter().write(cookie.getName() + ":" + cookie.getValue());
			}
		}
	}
}
