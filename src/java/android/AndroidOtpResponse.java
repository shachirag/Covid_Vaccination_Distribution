package android;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;

public class AndroidOtpResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {
            // Extract text
            String phone = request.getParameter("phone");

            ResultSet rs = DBLOADER.executeSQl("select * from users where phone_no=\'" + phone + "\'");
            if (rs.next()) {
                rs.updateString("status", "verified");
                rs.updateRow();

            }
            out.println("OTP-VERIFIED");
        } catch (Exception ex) {
            out.println(ex.toString());
        }

    }
}
