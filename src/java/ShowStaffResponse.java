
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class ShowStaffResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        if(request.getSession().getAttribute("vcid")!=null)
        {
                   int vcid =Integer.parseInt(request.getSession().getAttribute("vcid").toString());
                  
                String ans = new RDBMS_TO_JSON().generateJSON("select * from staff where vcid = "+vcid);

                out.println(ans);
        }
          
       
    }
}
