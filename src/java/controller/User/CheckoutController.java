package controller.User;

import DAO.OrderDAO;
import DAO.OrderItemDAO;
import entity.Account;
import entity.Cart;
import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CheckoutController", urlPatterns = {"/check-out"})
public class CheckoutController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Check if user is logged in     
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");
        // Get the user's cart    
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
            // Cart is empty, redirect to home page    
            request.setAttribute("mess", "Giỏ hàng của bạn đang rỗng. Vui lòng thêm sản phẩm trước khi thanh toán.");
            request.getRequestDispatcher("home").forward(request, response);
            return;
        }
        // Prepare the order and forward to the checkout page
        float amount = calculateAmount(cart);

        Order order = new Order();
        order.setOrder_date(LocalDateTime.now() + "");
        order.setTotal_price(amount);
        order.setAcc_id(account.getAcc_id());
        String voucherId = null;
        if (cart.getAppliedVoucher() == null
                || cart.getAppliedVoucher().getVoucher_id().isEmpty()) {
            voucherId = "vou0";
        } else {
            voucherId = cart.getAppliedVoucher().getVoucher_id();
            order.setVoucher_id(voucherId);
        }

        OrderDAO orderDAO = new OrderDAO();
        int orderId = orderDAO.insertOrder(order);
        new OrderItemDAO().insertOrderItems(cart, orderId);

        //updoate lai so luong product
//        ProductDAO productDAO = new ProductDAO();
//        productDAO.updateQuantity(cart);
        request.setAttribute("order", order);
        request.setAttribute("messSuccess", "Đặt hàng thành công");
        session.removeAttribute("cart");
        request.getRequestDispatcher("home").forward(request, response);
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
            out.println("<title>Servlet CheckoutController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private float calculateAmount(Cart cart) {
        double totalPrice = cart.getTotalPrice();
        double discount = cart.getDiscount();
        return (float) (totalPrice - discount);
    }

}
