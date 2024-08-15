package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class database
 */
@WebServlet("/database")
public class database extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public database() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
   		PrintWriter pw=response.getWriter();
   		
   		
   		String name= request.getParameter("name");
   		String mobileno= request.getParameter("mobileno");
   		String email= request.getParameter("email");
   		String password= request.getParameter("password");
   	try {
   		Class.forName("com.mysql.jdbc.Driver");  
   		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teja","root","root");  
   		PreparedStatement ps=con.prepareStatement("insert into data(name ,mobileno ,emailid ,password) values(?,?,?,?)");
   		ps.setString(1,name);
   		ps.setString(2,mobileno);
   		ps.setString(3,email);
   		ps.setString(4,password);
   		int i=ps.executeUpdate();
   		if(i>0)
   		System.out.println("sucess");
   	}
   	catch(Exception e)
   	{
   		System.out.println("error");
   	}
   	}
	}
