package controller.Admin;

import DAO.ProductDAO;
import entity.Product;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Quynhh Nhuu
 */
@WebServlet(name = "ManageProductController", urlPatterns = {"/manageProduct"})
public class ManageProductController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ProductDAO dao = new ProductDAO();

        List<Product> listP = dao.getAllProducts();

        //khi mà phân quyền và bắt được là admin thì sẽ lấy list product từ db, sau đó đẩy về trang home của admin
        String messSuccess = (String) request.getAttribute("messSuccess");
        request.setAttribute("messSuccess", messSuccess);
//      Collections.sort(listP, (p1, p2) -> Double.compare( p2.getPro_price(),p1.getPro_price())); //sắp xếp theo giá giảm dần
        Collections.sort(listP, (p1, p2) -> Double.compare(p1.getPro_price(), p2.getPro_price())); // sắp xếp thep giá tăng dần
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("Admin/ManageProduct.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
