
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;

public class CheckOtpResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {
            HttpSession session = request.getSession();
            // Extract text
            String otp = request.getParameter("otp");
            if (session.getAttribute("otp") != null) 
            {
                String otp1 = session.getAttribute("otp").toString();
                String phone = request.getParameter("phone");
                if (otp.equals(otp1)) 
                {
                    ResultSet rs = DBLOADER.executeSQl("select * from users where phone_no=\'" + phone + "\'");
                    if (rs.next())
                    {
                        rs.updateString("status", "verified");
                        rs.updateRow();

                    }
                    out.println("OTP-VERIFIED");
                } 
                else 
                {
                    out.println("OTP NOT VERIFIED TRY AGAIN");
                }
            } 
            else 
            {
                out.println("Session Timeout");
            }

        } 
        catch (Exception ex) {
            out.println(ex.toString());
        }

    }
}
