

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
@WebServlet("/Flight")
public class SportyShoe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SportyShoe() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/WEB-INF/prices.txt");
		String size=request.getParameter("size");
		String color=request.getParameter("color");
		String username=request.getParameter("username");
		//String pass=request.getParameter("password");
		String num=request.getParameter("num");
		Integer pass_count=0;
		try
		{
		    if(num != null)
		    	pass_count = Integer.parseInt(num);
		}
		catch (NumberFormatException e)
		{
		    pass_count=0;
		}
		
//		DateTimeFormatter sdf = DateTimeFormatter.ISO_LOCAL_DATE;
//		try {
//            LocalDate.parse(date, sdf);
//        } catch (DateTimeParseException e) {
//            out.write("Please Provide Valid date in format yyyy-mm-dd");
//            return;
//        }
		BufferedReader br = new BufferedReader(new FileReader(fullPath));
		String line = "";  
		String splitBy = ",";  
		boolean bool=false;
		Integer ct=0;
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
			ct+=1;
		String[] flight_data = line.split(splitBy);    // use comma as separator  
		if(size.equals(flight_data[0]) && color.equals(flight_data[1])) {
			out.write("<h3>Shoes exist for color "+color+" size "+size+"</h3>");
			Integer price_per_head=Integer.parseInt(flight_data[3]);
			Integer tot_price=price_per_head*pass_count;
			String url="<a href="+response.encodeURL("/SportyShoe/Reg?ct="+ct+"&pc="+tot_price)+">Login Here"; 
			out.write("<table border=\"1\"><th>Brand</th>"
					+ "<th>Price Per Pair</th>"
					+ "<th>Total Price</th>"
					+"<th>Login to buy"
					+ "<tr><td>"+flight_data[2]+"</td><td>"+flight_data[3]+"</td><td>"+tot_price+"</td><td>"+url+"</td></tr></table>");
		
			bool=true;
			
		}
		  
		}
		if(bool==false) {
			out.write("<h3>No shows of color "+color+" and size "+size);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
	

	}

}
