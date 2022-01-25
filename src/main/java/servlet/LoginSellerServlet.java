package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Seller;

import model.SellerDBUtil;


@WebServlet("/LoginSellerServlet")
public class LoginSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean isTrue;
		
		isTrue = SellerDBUtil.validate(username, password);
		
		if (isTrue == true) {
			List<Seller> selDetails = SellerDBUtil.getSeller(username);
			request.setAttribute("selDetails", selDetails);
			
			int sellerID = SellerDBUtil.getSellerID(username);
			session.setAttribute("sellerID",sellerID);
			session.setAttribute("username", username);
			
			RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Incorrect Username or Password');");
			out.println("location='sellerlogin.jsp'");
			out.println("</script>");
			
		}
		
	}			

}
