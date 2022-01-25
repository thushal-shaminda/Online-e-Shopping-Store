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
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession mySession = request.getSession();
		int sid = (int) mySession.getAttribute("sellerID");
		request.setAttribute("sellerID", sid);
		RequestDispatcher dis = request.getRequestDispatcher("addItem.jsp");
		dis.forward(request, response);
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
		
		String name = request.getParameter("itemName");
		String category = request.getParameter("itemCategory");
		int qty = Integer.parseInt(request.getParameter("qty"));
		float price = Float.parseFloat(request.getParameter("itemPrice"));
		String desc = request.getParameter("itemDesc");
		String pic = request.getParameter("photo");
		int sid = (int) session.getAttribute("sellerID");
		
		boolean isTrue = ItemUtil.addItem(name, category, qty, price, desc, sid, pic);
		
		if(isTrue == true) {
			int sellerID = (int) session.getAttribute("sellerID");
			
			ArrayList<Item> items = ItemUtil.getMyItems(sellerID);
			request.setAttribute("items", items);
			RequestDispatcher dis = request.getRequestDispatcher("myItems.jsp");
			dis.forward(request, response);
			
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Item not added');");
			out.println("location='addItem.jsp'");
			out.println("</script>");
		}
		
	}

}
