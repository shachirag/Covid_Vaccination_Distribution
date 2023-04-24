
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;

@MultipartConfig
public class AddStaffResponse extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            // Extract text1
            if (request.getSession().getAttribute("vcid") != null) 
            {
                String staffname = request.getParameter("staffname");
                String password = request.getParameter("password");
                int vcid = Integer.parseInt(request.getSession().getAttribute("vcid").toString());
                

                // Now Insert in Database
                ResultSet rs = DBLOADER.executeSQl("select * from staff where name='" + staffname + "'  and  vcid = "+vcid);

                if (rs.next()) {
                    out.println("<h3 style=\"color: red\">Staff with same name and vaccine center is alreday there please add suffix or prefix in name to continue. Example ::"+(staffname+"01")+" , "+("02"+staffname)+"!!</h3>");
                } else {
                   
                    rs.moveToInsertRow();
                    rs.updateString("name", staffname);
                    rs.updateString("password", password);
                    rs.updateInt("vcid", vcid);
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
