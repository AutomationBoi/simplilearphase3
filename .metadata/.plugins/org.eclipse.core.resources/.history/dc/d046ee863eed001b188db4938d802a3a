

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
@WebServlet("/done")
public class done extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public done() {
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
		BufferedReader br = new BufferedReader(new FileReader(fullPath));
		String line = "";  
		String splitBy = ",";  
		boolean bool=false;
		Integer ct=0;
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
			ct+=1;
			String[] flight_data = line.split(splitBy);
			out.write("<table border=\"1\">"
					+"<th>Source</th>"
					+"<th>Destination</th>"
					+ "<th>Airlines</th>"
					+ "<th>Price Per Head</th>"
					+ "<th>Total Price</th>"
					+"<th>Link To Register"
					+ "<tr>"
					+"<td>"+flight_data[0]+"</td>"
					+"<td>"+flight_data[1]+"</td>"
					+ "<td>"+flight_data[2]+"</td><td>"+flight_data[3]+"</td><td>"+flight_data[4]+"</td></tr></table>");

	}

}
}
