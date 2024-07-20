package controller.User;

import DAO.OrderItemDAO;
import entity.OrderItem;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DUY KHANG
 */
@WebServlet(name = "ViewOrderDetailsController", urlPatterns = {"/viewOrderDetails"})
public class ViewOrderDetailsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // Get the order ID from the request parameter    
        int orderId = Integer.parseInt(request.getParameter("order_id"));
        // Retrieve the order items for the given order ID     
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        List<OrderItem> orderItems = orderItemDAO.getOrderItemsByOrderId(orderId);
        // Set the order items as a request attribute      
        request.setAttribute("orderItems", orderItems);
        // Forward the request to the ViewOrderDetailsController.jsp page      
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewOrderDetails.jsp");
        dispatcher.forward(request, response);
    }

}
