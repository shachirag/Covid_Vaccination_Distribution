
import com.mysql.cj.xdevapi.Result;
import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.RDBMS_TO_JSON;

public class VaccinateVerifyResponse extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        try
        {
        if(request.getParameter("mid")!=null && request.getParameter("appoint_id")!=null && request.getSession().getAttribute("staff_id")!=null)
        {
            int staff_id= Integer.parseInt(request.getSession().getAttribute("staff_id").toString());//in case if we need it in future
            int appoint_id=Integer.parseInt(request.getParameter("appoint_id"));
            int mid=Integer.parseInt(request.getParameter("mid"));
            int vid=0;
           ResultSet rs = DBLOADER.executeSQl("Select * from appointments where appoint_id="+appoint_id);
            if(rs.next())
            {
                vid=rs.getInt("vid");
                if(rs.getString("status").equals("pending"))
                {
                    rs.updateString("status", "completed");
                }
                rs.updateRow();
            }
            rs = DBLOADER.executeSQl("Select * from members where mid="+mid);
            if(rs.next())
            {
                if(rs.getString("status").equals("Not-Vacinated"))
                {
                    rs.updateString("status", "shot-one");
                    rs.updateInt("vid",vid);
                }
                if(rs.getString("status").equals("shot-one"))
                {
                    rs.updateString("status", "Vaccinated");
                }
                rs.updateRow();
            }
            out.println("Success");

            
        }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        
       
    }
}
