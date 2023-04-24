
import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.RDBMS_TO_JSON;

public class DeleteCenterResponse extends HttpServlet {

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
        
            if (request.getParameter("vcid") != null) 
            {
                int vcid = Integer.parseInt(request.getParameter("vcid"));

                ResultSet rs =DBLOADER.executeSQl("select * from vaccine_centers where vcid ='" + vcid + "'");
                if(rs.next())
                {
                    rs.deleteRow();
                    out.println("Center Deleted");

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
