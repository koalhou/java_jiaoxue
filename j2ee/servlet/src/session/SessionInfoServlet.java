package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5738650562913624012L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//true：如果没有，则创建一个
		HttpSession mySession = req.getSession(true);
		
		PrintWriter out = resp.getWriter();
		out.println("New session ? "+mySession.isNew());
		out.println("Session ID :" + mySession.getId());
		out.println("Session Create time : " + mySession.getCreationTime());
		out.println("Session last accessed time : " + mySession.getLastAccessedTime());
		out.println("Session ID from request : " + req.getRequestedSessionId());
		out.println("Session ID via Cookie : " + req.isRequestedSessionIdFromCookie());
		out.println("Session ID via rewritten URL : " + req.isRequestedSessionIdFromURL());
		out.println("Session ID is valid : " + req.isRequestedSessionIdValid());
		mySession.setAttribute("FUCK", "Sucks!!!");
		out.println("<a href="+resp.encodeRedirectURL("SessionInfoServlet")+">");
		
		
		Integer accessCount = (Integer)mySession.getAttribute("accessCount");
		String heading ;
		if(accessCount == null){
			accessCount = new Integer(0);
			heading = "Welcome newcommer !";
		}else{
			accessCount = new Integer(accessCount.intValue() +1);
			heading = "Welcome back !";
		}
		out.println(heading + ",This is your " + accessCount + " times come.");
	}
	
}
