

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AdminLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String passwd=request.getParameter("pass");
		if(name.toLowerCase().equals("admin")) {
			ServletContext context = getServletContext();
			String fullPath = context.getRealPath("/WEB-INF/pass.conf");
			File file =new File(fullPath);
			Scanner sc = new Scanner(file);
			String pass=sc.next();
			if(pass.equals(passwd)) {
				out.print("WELCOME ADMIN<br>");
				out.print("<a href="+response.encodeURL("/SportyShoe/changepass.html")+">Would You like to Change your Password</a><br>");
				out.print("<a href="+response.encodeURL("/SportyShoe/StoreProducts")+">All store products</a><br>");
				out.print("<a href="+response.encodeURL("/SportyShoe/RegUsers")+">registered User Names</a><br>");
				out.print("<a href="+response.encodeURL("/SportyShoe/Reports")+">Sales Reports</a><br>");
			}else {
				out.print("Wrong Username/Password");
			}
		}else {
			out.print("Wrong Username/Password");
		}

	}

}
