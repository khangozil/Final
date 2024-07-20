package controller.User;

import DAO.AccountDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ng Quoc Bao when user forgot password
 */
@WebServlet(name = "UpdatePasswordController", urlPatterns = {"/updatePassword"})
public class UpdatePasswordController extends HttpServlet {

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

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("user");
        AccountDAO dao = new AccountDAO();

        String pass = request.getParameter("password");
        String repass = request.getParameter("repassword");

//        if (!pass.equals(repass)) {
//            request.setAttribute("mess", "Mật khẩu không giống nhau");
//            request.getRequestDispatcher("UpdatePassword.jsp").forward(request, response);
//        } else {
        //cập nhật mật khẩu
        dao.updatePassword(username, pass);
        request.setAttribute("messSuccess", "Cập nhật thành công. Xin mời đăng nhập!");
        //cập nhật thành công thì xóa session user
        session.removeAttribute("user");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
//            request.getRequestDispatcher("home").forward(request, response);

//        }
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
