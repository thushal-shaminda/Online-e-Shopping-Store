package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemUtil;




@WebServlet("/addtocartservlet")
public class addtocartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("cartid");
		
		try {
			System.out.println("done");
			ItemUtil.addtocart(name);
			HashSet<Item> items = ItemUtil.getItemList();
			request.setAttribute("items", items);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//redirected to the view
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request,response);
	}

}
