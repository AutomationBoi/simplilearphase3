

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Reg() {
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
		Integer cnt=Integer.parseInt(request.getParameter("ct"));
		Integer tot_price=Integer.parseInt(request.getParameter("pc"));
		BufferedReader br = new BufferedReader(new FileReader(fullPath));
		String line = "";  
		String splitBy = ",";  
		boolean bool=false;
		Integer ct=0;
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
			ct+=1;
			String[] flight_data = line.split(splitBy);
			Integer price_per_head=Integer.parseInt(flight_data[3]);
			if(ct==cnt) {
				out.write("Please Enter the Details and proceed with payment");
				out.write("<form method=\"post\" action=\"/SportyShoe/done\">"
						+ "<input type=\"text\" placeholder=\"Name\" name=\"Name\">"
						+ "<input type=\"password\" placeholder=\"Password\" name=\"Password\">"
						+ "<button type=\"submit\">SUBMIT</button>"
						+ "</form>");
				String csv_to_store=flight_data[0]+","+flight_data[1]+","+flight_data[2]+","+flight_data[3]+","+tot_price;
				fullPath = context.getRealPath("/WEB-INF/booking.txt");
				FileWriter fw=new FileWriter(fullPath);
				fw.write(csv_to_store);
				fw.close();
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);


	}

}
