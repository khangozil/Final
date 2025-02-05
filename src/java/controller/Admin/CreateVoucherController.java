package controller.Admin;

import DAO.VoucherDAO;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CreateVoucherController", urlPatterns = {"/createVoucher"})
public class CreateVoucherController extends HttpServlet {

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

        String code = request.getParameter("code");
        String discount_percentage = request.getParameter("discount_percentage");
        Double discountValue = Double.parseDouble(discount_percentage);

        //dùng UUID để lấy chuỗi random làm vou_id
        UUID uuid = UUID.randomUUID();
        String vou_id = uuid.toString();

        VoucherDAO dao = new VoucherDAO();
        boolean check = dao.checkVoucherExist(code);

        if (!check) {
            dao.createVoucher(vou_id, code, discountValue);
            request.setAttribute("messSuccess", "Bạn vừa tạo một Code mới thành công!");
            request.getRequestDispatcher("manageVoucher").forward(request, response);
        } else {
            request.setAttribute("mess", "Code đã tồn tại!");
            request.getRequestDispatcher("Admin/CreateVoucher.jsp").forward(request, response);
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
