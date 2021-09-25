

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet("/complete")
public class complete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public complete() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/WEB-INF/booking.txt");
		String report=context.getRealPath("/WEB-INF/report.txt");
		BufferedReader br = new BufferedReader(new FileReader(fullPath));
		String line = "";  
		String splitBy = ",";  
		boolean bool=false;
		Integer ct=0;
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
			ct+=1;
			String[] flight_data = line.split(splitBy);
			out.write("<h1>Shoes Bought Succesfully</h1>");
			out.write("<table border=\"1\">"
					+"<th>Size</th>"
					+"<th>Color</th>"
					+ "<th>Brand</th>"
					+ "<th>Price Per Pair</th>"
					+ "<th>Total Price</th>"
					+ "<tr>"
					+"<td>"+flight_data[0]+"</td>"
					+"<td>"+flight_data[1]+"</td>"
					+ "<td>"+flight_data[2]+"</td><td>"+flight_data[3]+"</td><td>"+flight_data[4]+"</td></tr></table>");
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String data = df.format(new Date());
			String to_Write=flight_data[0]+","+flight_data[1]+","+flight_data[2]+","+flight_data[3]+","+flight_data[4]+","+data;
			FileWriter fw = new FileWriter(report, true);	
			fw.write(to_Write);
			fw.close();
			out.write("<a href=\""+response.encodeURL("/FlyAway/")+"\">HOME</a>");

	}

}
}
