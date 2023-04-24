
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;

@MultipartConfig
public class AddVaccineResponse extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            // Extract text1
            if (request.getSession().getAttribute("username") != null) 
            {
                String name = request.getParameter("name");
                String price = request.getParameter("price");
                String doses = request.getParameter("doses");
                String age = request.getParameter("age");
                
                // Now Insert in Database
                ResultSet rs = DBLOADER.executeSQl("select * from vaccines where name=\'" + name + "\'");

                if (rs.next()) {
                    out.println("<h3 style=\"color: red\">Vaccine  is already present!!</h3>");
                }
                else 
                {                   
                    rs.moveToInsertRow();
                    rs.updateString("name", name);
                    rs.updateString("price", price);
                    rs.updateString("doses", doses);
                    rs.updateString("minimum_age", age);
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
