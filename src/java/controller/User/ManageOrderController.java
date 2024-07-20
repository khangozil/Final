package controller.User;

import DAO.OrderDAO;
import entity.Account;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ManageOrderController", urlPatterns = {"/manageOrderUser"})
public class ManageOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the current user from the session      
        HttpSession session = request.getSession();
        Account currentUser = (Account) session.getAttribute("acc");
        // Get all orders for the current user     
        OrderDAO orderDAO = new OrderDAO();
        List<Order> orders = orderDAO.getOrdersByAccountId(currentUser.getAcc_id());

        // Pass the orders to the view   
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("User/ManageOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManageOrder</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageOrder at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
