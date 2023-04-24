package android;
import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.RDBMS_TO_JSON;

public class AndroidCancelAppointmentResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/html");

        PrintWriter out = response.getWriter();
        try
        {
             
        
         
        
            if (request.getParameter("appoint_id") != null) 
            {
                int appoint_id = Integer.parseInt(request.getParameter("appoint_id"));

                ResultSet rs =DBLOADER.executeSQl("select * from appointments where appoint_id ='" + appoint_id + "'");
                if(rs.next())
                {
                    rs.deleteRow();
                    out.println("Appointment Cancelled");

                }
            }
            else 
            {
                out.println("Fail");
            }
         
        }
        catch(Exception ex )
        {
            System.out.println(ex.toString());
        }
       
    }
}
