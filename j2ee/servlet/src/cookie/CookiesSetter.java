package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesSetter extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6944684661736956506L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie cookie = new Cookie("Session-Cookie-" + 1,"Cookie-Value-s" + 1);
		resp.addCookie(cookie);
		cookie = new Cookie("Persistent-Cookie-" + 1,"Cookie-Value-P" + 1);
		cookie.setMaxAge(3600);
		resp.addCookie(cookie);
	}
	
}
