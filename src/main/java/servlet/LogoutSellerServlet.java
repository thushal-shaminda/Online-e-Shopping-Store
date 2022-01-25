package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;


@WebServlet("/LogoutSellerServlet")
public class LogoutSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public LogoutSellerServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
            session.removeAttribute("username");
            session.removeAttribute("sellerID");
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("IndexServlet");
            dispatcher.forward(request, response);
        }
	}

}
