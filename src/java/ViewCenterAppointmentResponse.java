
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class ViewCenterAppointmentResponse extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
            if (request.getSession().getAttribute("vac_id") != null) {
                int vcid = Integer.parseInt(request.getSession().getAttribute("vac_id").toString());

                String ans = new RDBMS_TO_JSON().generateJSON("SELECT aa.appoint_id as id,mm.mid,mm.name,mm.age,mm.proof_type,mm.proof_number,vv.name vaccine_name ,vv.doses as doses, vc.name as vaccine_center_name,aa.date,aa.time as time, aa.status as status FROM members mm,appointments aa,vaccines vv,vaccine_centers vc where aa.vid=vv.vid and aa.vcid=vc.vcid and aa.mid=mm.mid and vc.vcid='"+vcid+"' and str_to_date(aa.date,'%d-%m-%Y')=curdate()");

                out.println(ans);
            } else {
                out.println("Fail");
            }
       
    }
}
