
import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.RDBMS_TO_JSON;

public class DeleteVaccineResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/html");

        PrintWriter out = response.getWriter();
        try
        {
             
         if (request.getSession().getAttribute("username") == null) 
         {
             response.sendRedirect("LoginAdmin.jsp");
         }
         else
         {
        
            if (request.getParameter("vid") != null) 
            {
                int vid = Integer.parseInt(request.getParameter("vid"));

                ResultSet rs =DBLOADER.executeSQl("select * from vaccines where vid ='" + vid + "'");
                if(rs.next())
                {
                    rs.deleteRow();
                    out.println("Vaccine Deleted");

                }
            }
            else 
            {
                out.println("no argument passed");
            }
         }
        }
        catch(Exception ex )
        {
            System.out.println(ex.toString());
        }
       
    }
}
