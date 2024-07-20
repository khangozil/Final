package controller;

import DAO.AccountDAO;
import entity.Account;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ng Quoc Bao
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
        AccountDAO dao = new AccountDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hashing = dao.hashPasswordMD5(password);

        //kiểm tra xem tài khoản có tồn tại hay không
        boolean existed = dao.checkAccountExist(username);
        boolean isAdmin = dao.isAdminExist(username);

        //nếu tồn tại thì bắt đầu kiểm tra đăng nhập
        if (existed == true) {
            Account a = dao.login(username, hashing);
            if (a == null) {
                //nếu trả về null thì đăng nhập thất bại
                request.setAttribute("mess", "Tài khoản hoặc mật khẩu không đúng!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                //ngược lại thì đăng nhập thành công

                //nếu là admin thì sẽ đẩy về servlet của admin, ở đây là manegeProduct
                if (isAdmin) {
                    HttpSession session = request.getSession();
                    session.setAttribute("acc", a);
                    session.setMaxInactiveInterval(10000);//>2h

                    Cookie cookieUser = new Cookie("username", username);
                    cookieUser.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookieUser);

                    Cookie cookiePass = new Cookie("password", password);
                    cookiePass.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookiePass);

                    request.setAttribute("messSuccess", "Đăng nhập thành công! Xin chào ADMIN!");
                    request.getRequestDispatcher("manageProduct").forward(request, response);
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("acc", a);

                    Cookie cookieUser = new Cookie("username", username);
                    cookieUser.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookieUser);

                    Cookie cookiePass = new Cookie("password", password);
                    cookiePass.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookiePass);

                    request.setAttribute("messSuccess", "Đăng nhập thành công! Xin chào bạn đến với shop của chúng tôi!");
                    request.getRequestDispatcher("home").forward(request, response);
                }
            }
        } else {
            request.setAttribute("mess", "Tài khoản không tồn tại");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
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
