
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class ShowVaccineAvailabilityResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        if(request.getSession().getAttribute("vcid")!=null)
        {
                   int vcid =Integer.parseInt(request.getSession().getAttribute("vcid").toString());
                  
                String ans = new RDBMS_TO_JSON().generateJSON("select va.avail_id,vv.name,va.date,va.quantity from vaccine_availability as va,vaccines vv where va.vid=vv.vid and vcid = "+vcid);

                out.println(ans);
        }
          
       
    }
}
