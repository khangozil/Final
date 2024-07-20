package controller.User;

import DAO.AccountDAO;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.EmailUtils;

/**
 *
 * @author DUY KHANG
 */
@WebServlet(name = "ForgotPassController", urlPatterns = {"/forgot"})
public class ForgotPassController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null
                ? ""
                : request.getParameter("action");
        switch (action) {
            case "enterEmail":
                sendEmail(request, response);
                break;
            case "enterOtp":
                enterOTP(request, response);
                break;
            case "changePassword":
                enterNewPassword(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    public String generateSixRandomNumber() {
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d", number);
    }

    private void sendEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = null;
        //get email
        String email = request.getParameter("email");
        //check mail exist in DB
        boolean isEmailExist = new AccountDAO().checkMailExist(email);
        if (!isEmailExist) {
            request.setAttribute("mess", "Mail không tồn tại!");
            url = "ForgotPassword.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
        //generate random number
        String random = generateSixRandomNumber();
        //content mail
        String subject = "Reset password";
        String content = "Your reset password code is: " + random;
        //send mail
        boolean result = EmailUtils.sendMail(email, subject, content);
//        boolean result = true;
        //if send mail success => go to enter otp
        if (result) {
            request.setAttribute("action", "enterOtp");
            request.getSession().setAttribute("OTP", random);
            request.getSession().setAttribute("MailReset", email);
            url = "entorOTP.jsp";
        } else {
            request.setAttribute("action", "enterEmail");
            //if send mail failed => back to forgotPassword.jsp attach error message
            request.setAttribute("error", "Thử lại!");
            url = "ForgotPassword.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    private void enterOTP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = null;
        String otp = request.getParameter("otp");
        //get otp on session
        String otpSession = (String) session.getAttribute("OTP");
        //nhap dung OTP
        if (otp.equals(otpSession)) {
            //chuyen toi trang nhap password moi
            request.setAttribute("action", "changePassword");
            url = "UpdatePassword.jsp";
        } else {
            //khong dung OTP => set loi va bao sai
            request.setAttribute("action", "enterOtp");
            request.setAttribute("error", "Sai mã OTP");
            url = "entorOTP.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

    private void enterNewPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = null;

        //get MailReset
        String mailReset = (String) session.getAttribute("MailReset");
        //get password
        String password = request.getParameter("newPassword");
        //get confirm password
        String confirmPassword = request.getParameter("confirmPassword");
        //check password equal confirm password
        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Mật khẩu không trùng khớp !!");
            request.setAttribute("action", "changePassword");
            url = "ChangePassword.jsp?action=changePassword";
            request.getRequestDispatcher(url).forward(request, response);
        }
        //change password in DB
        new AccountDAO().updatePassword(mailReset, password);
        url = "Login.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }

}
