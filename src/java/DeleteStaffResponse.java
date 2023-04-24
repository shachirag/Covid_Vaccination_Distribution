
import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.RDBMS_TO_JSON;

public class DeleteStaffResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/html");

        PrintWriter out = response.getWriter();
        try
        {
             
         if (request.getSession().getAttribute("vcid") == null) 
         {
             response.sendRedirect("LoginCenter.jsp");
         }
         else
         {
        
            if (request.getParameter("staff_id") != null) 
            {
                int staff_id = Integer.parseInt(request.getParameter("staff_id"));

                ResultSet rs =DBLOADER.executeSQl("select * from staff where staff_id ='" + staff_id + "'");
                if(rs.next())
                {
                    rs.deleteRow();
                    out.println("Staff Deleted");

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
