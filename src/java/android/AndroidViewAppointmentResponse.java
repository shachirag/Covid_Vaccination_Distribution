
package android;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class AndroidViewAppointmentResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
            if (request.getParameter("mid") != null) {
                int mid = Integer.parseInt(request.getParameter("mid"));

                String ans = new RDBMS_TO_JSON().generateJSON("SELECT aa.appoint_id as id,mm.mid,mm.name,vv.name vaccine_name , vc.name as vaccine_center_name,aa.date,aa.time as time, aa.status as status FROM members mm,appointments aa,vaccines vv,vaccine_centers vc where aa.vid=vv.vid and aa.vcid=vc.vcid and aa.mid=mm.mid and aa.mid='" + mid + "'");

                out.println(ans);
            } else {
                out.println("Fail");
            }
       
    }
}
