package controller.User;

import DAO.AccountDAO;
import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ng Quoc Bao for user want to change password
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/changePassword"})
public class ChangePasswordController extends HttpServlet {

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

        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");

        AccountDAO dao = new AccountDAO();
        String username = acc.getAcc_id();

//        String currentPass = acc.getPassword();//mật khẩu của người dùng, tài khoản đang đăng nhập
        String currentPass = (String) acc.getPassword();

        String oldPass = request.getParameter("oldpassword");//mật khẩu người dùng nhập vào
        String pass = request.getParameter("password");//mật khẩu mới

        //hash mật khẩu hiện tại mà người dùng nhập vào, để kiểm tra xem giống với mật khẩu của người dùng hay không?
        String checkPass = (String) dao.hashPasswordMD5(oldPass);

        //mật khẩu cũ mà người dùng nhập vào phải trùng với mật khẩu của tk đang đăng nhập
        if (currentPass.equals(checkPass)) {
            dao.updatePasswordForUser(username, pass);
            //cập nhật lại session (cập nhật lại mk mới đổi thành công)
            Account accUp = dao.getAccount(username);
            session.setAttribute("acc", accUp);
            request.setAttribute("messSuccess", "Cập nhật mật khẩu thành công");
            request.getRequestDispatcher("User/Profile.jsp").forward(request, response);

        } else {
            request.setAttribute("mess", "Mật khẩu hiện tại không đúng");
            request.getRequestDispatcher("User/ChangePassword.jsp").forward(request, response);
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
