
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;

@MultipartConfig
public class AddCenterResponse extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            // Extract text1
            if (request.getSession().getAttribute("username") != null) 
            {
                String vcname = request.getParameter("vcname");
                String vcemail = request.getParameter("vcemail");
                String vccity = request.getParameter("vccity");
                String vcaddress = request.getParameter("vcaddress");
                String vcphone = request.getParameter("vcphone");
                String vcpassword = request.getParameter("vcpassword");
                

                // Now Insert in Database
                ResultSet rs = DBLOADER.executeSQl("select * from vaccine_centers where phone_no=\'" + vcphone + "\'");

                if (rs.next()) {
                    out.println("<h3 style=\"color: red\">Vaccine Center is already register with this phone number!!</h3>");
                } else {
                   
                    rs.moveToInsertRow();
                    rs.updateString("name", vcname);
                    rs.updateString("email", vcemail);
                    rs.updateString("city", vccity);
                    rs.updateString("address", vcaddress);
                    rs.updateString("phone_no", vcphone);
                    rs.updateString("password", vcpassword);
                    rs.insertRow();

                    out.println("Success");
                }
            } else {
                out.println("Session Expired");
            }
        } catch (Exception ex) {
            out.println(ex.toString());
        }
    }
}
