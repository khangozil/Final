package controller.User;

import DAO.AccountDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ng Quoc Bao
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8"); //dùng để sử dụng tiếng diệt

        String name = request.getParameter("fullname");
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String mail = request.getParameter("mail");
        String gender = request.getParameter("gender");

        AccountDAO dao = new AccountDAO();
        boolean checkAccount = dao.checkAccountExist(user);
        boolean checkPhone = dao.checkPhoneExist(phone);
        boolean checkMail = dao.checkMailExist(mail);


//      Nếu tài khoản và số điện thoại đều không tồn tại, cho phép đăng ký
        if (!checkAccount && !checkPhone && !checkMail) {
            dao.singup(user, pass, name, phone, address, mail, gender);
            request.setAttribute("messSuccess", "Đăng ký thành công! Mời đăng nhập");
            response.sendRedirect("Login.jsp");
        } else {
            if (checkAccount) {
                request.setAttribute("mess", "Tài khoản đã tồn tại!");
            }
            else if (checkPhone) {
                request.setAttribute("mess", "Số điện thoại đã được sử dụng!");
            }
            else if (checkMail) {
                request.setAttribute("mess", "Mail đã được sử dụng!");
            }

            request.getRequestDispatcher("Register.jsp").forward(request, response);
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
