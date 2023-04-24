
import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.RDBMS_TO_JSON;

public class CheckStatusResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/html");

        PrintWriter out = response.getWriter();
            try
            {
                ResultSet rs1 = DBLOADER.executeSQl("SELECT *   FROM appointments where  status='pending' and concat(str_to_date(date,'%d-%m-%Y'),' ',time)<=current_timestamp();");
                while(rs1.next())
                {
                    rs1.updateString("status", "missed");
                    rs1.updateRow();
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex.toString());
            }
       
    }
}
