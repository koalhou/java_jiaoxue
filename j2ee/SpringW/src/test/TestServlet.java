package test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TestServlet extends HttpServlet {

	private static Logger logger = LoggerFactory.getLogger(TestServlet.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5457331617913325845L;
	TestAction ta;

	public TestServlet() {
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		logger.info("This is in the init method..");  
		servletConfig.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletConfig.getServletContext());
		this.ta = (TestAction) ctx.getBean("TestAction", TestAction.class);
		this.ta.sayHello();
		System.out.println("TestServlet init");
		// TestAction ta = new TestAction();
		// ta.sayHello();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)	throws IOException, ServletException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		this.ta.sayHello();
	}

	public void destroy() {
		
	}
}
