package controller.Admin;

import DAO.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CreateProductController", urlPatterns = {"/createProduct"})
public class CreateProductController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String inputDate = request.getParameter("date");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        Double priceValue = Double.parseDouble(price);
        Double quantityValue = Double.parseDouble(quantity);
        Integer categoryValue = Integer.parseInt(category);

        ProductDAO dao = new ProductDAO();
        boolean checkID = dao.checkProductExistByID(id);
        boolean checkName = dao.checkProductExistByName(name);

        if (!checkID && !checkName) {
            dao.createProduct(id, name, image, inputDate, priceValue, quantityValue, description, categoryValue);
            request.setAttribute("messSuccess", "Tạo sản phẩm thành công!");
            request.getRequestDispatcher("manageProduct").forward(request, response);
        } else {
            if (checkID) {
                request.setAttribute("mess", "ID sản phẩm đã tồn tại!");
            } else if (checkName) {
                request.setAttribute("mess", "Tên sản phẩm đã tồn tại!");
            }
            request.getRequestDispatcher("Admin/CreateProduct.jsp").forward(request, response);
        }
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
