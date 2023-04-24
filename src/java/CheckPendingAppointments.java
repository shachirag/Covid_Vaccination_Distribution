
import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.RDBMS_TO_JSON;

public class CheckPendingAppointments extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/html");

        PrintWriter out = response.getWriter();
        try
        {
            
        
            if (request.getParameter("mid") != null)
            {
                int mid= Integer.parseInt(request.getParameter("mid"));
                ResultSet rs=DBLOADER.executeSQl("select * from appointments where  mid='" + mid + "'");
                while(rs.next())
                {
                    if(rs.getString("status").equals("pending"))
                    {
                        out.println("pending");
                        break;
                    }
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
}
