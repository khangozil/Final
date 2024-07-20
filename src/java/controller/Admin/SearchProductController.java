package controller.Admin;

import DAO.ProductDAO;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "SearchProductController", urlPatterns = {"/searchProduct"})
public class SearchProductController extends HttpServlet {

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
        ProductDAO dao = new ProductDAO();
        List<Category> listCate = dao.getAllCategory();

        if (listCate == null) {
            listCate = new ArrayList<>();
        }
        // Set listCate as a request attribute
        request.setAttribute("listCate", listCate);  
        request.getRequestDispatcher("Admin/ManageProduct.jsp").forward(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String textSearch = request.getParameter("textSearch");
        String cate_id = request.getParameter("cate_id");

        if (textSearch == null || cate_id == null) {
            textSearch = "";
            cate_id = "0";
        }
        
        ProductDAO dao = new ProductDAO();
        List<Product> list = new ArrayList<Product>();
        List<Category> listCate = dao.getAllCategory();

        if (listCate == null) {
            listCate = new ArrayList<>();
        }

        if (cate_id.equals("0")) {
            list = dao.searchByName(textSearch);
            if (list == null) {
                list = new ArrayList<>();
            }
        } else {
            list = dao.searchByNameHaveCateID(textSearch, cate_id);
            if (list == null) {
                list = new ArrayList<>();
            }
        }
        request.setAttribute("listP", list);
        request.setAttribute("listCate", listCate);
        request.getRequestDispatcher("Admin/ManageProduct.jsp").forward(request, response);
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
