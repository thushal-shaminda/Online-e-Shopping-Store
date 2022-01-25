package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Item;
import model.ItemUtil;

/**
 * Servlet implementation class UpdateItemServlet
 */
@WebServlet("/UpdateItemServlet")
public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItemServlet() {
        super();
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
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		String name = request.getParameter("itemName");
		String category = request.getParameter("itemCategory");
		int qty = Integer.parseInt(request.getParameter("qty"));
		float price = Float.parseFloat(request.getParameter("itemPrice"));
		String desc = request.getParameter("itemDesc");
		int sellerID = (int) session.getAttribute("sellerID");
		
		boolean isTrue = ItemUtil.updateItem(itemID, name, category, qty, price, desc);
		
		if(isTrue==true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Item successfully deleted!');");
			out.println("location='myItems.jsp'");
			out.println("</script>");
		}
		
		else {
			out.println("<script type='text/javascript'>");
			out.println("warning('Item delete unsuccessful!');");
			out.println("</script>");
		}
		
		
		ArrayList<Item> items = ItemUtil.getMyItems(sellerID);
		request.setAttribute("items", items);
		
		RequestDispatcher dis = request.getRequestDispatcher("myItems.jsp");
		dis.forward(request, response);	
	}

}
