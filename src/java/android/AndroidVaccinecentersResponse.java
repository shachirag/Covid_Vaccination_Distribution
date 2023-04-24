package android;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class AndroidVaccinecentersResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
            if (request.getParameter("city") != null) 
            {
                String city = request.getParameter("city").toString();

                String ans = new RDBMS_TO_JSON().generateJSON("select * from vaccine_centers where city='" + city + "'");

                out.println(ans);
            } 
            else 
            {
                out.println("Fail");
            }
       
    }
}
