package controller.User;

import DAO.FeedbackDAO;
import entity.Account;
import entity.Feedback;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DUY KHANG
 */
@WebServlet(name = "ViewFeedbackController", urlPatterns = {"/viewFeedback"})
public class ViewFeedbackController extends HttpServlet {

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
//        FeedbackDAO dao = new FeedbackDAO();
//
//        List<Feedback> listF = dao.getAllFeedbacks();
//
//        request.setAttribute("listF", listF);
//        request.getRequestDispatcher("User/ViewFeedback.jsp").forward(request, response);


        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        String id = a.getAcc_id();
        FeedbackDAO dao = new FeedbackDAO();
        List<Feedback> listF1 = dao.getFeedbackByAccID(id);
        
        request.setAttribute("listF1", listF1);
        request.getRequestDispatcher("User/ViewFeedback.jsp").forward(request, response);

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
