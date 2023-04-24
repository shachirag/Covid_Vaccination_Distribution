package android;


import java.io.*;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.RDBMS_TO_JSON;

public class AndroidVaccineAvailabilityResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter("vcid") != null && request.getParameter("mid") != null) 
            {
                int vcid = Integer.parseInt(request.getParameter("vcid"));
                int mid = Integer.parseInt(request.getParameter("mid"));
                String status = "", ans ="";
                int vid = 0;

                ResultSet rs = DBLOADER.executeSQl("select * from members where mid =" + mid);
                
                if(rs.next())
                {
                    status = rs.getString("status");
                    System.out.println("current status :: "+status);
                    vid = rs.getInt("vid");
                }

                if (status.equals("shot-one")) 
                {
                    ans = new RDBMS_TO_JSON().generateJSON("select va.avail_id,v.vid,v.name,v.price,v.minimum_age,v.doses,va.date,va.quantity from vaccine_availability va ,vaccines v where va.vid=v.vid and va.vcid=" + vcid + " and v.vid=" + vid + " and str_to_date(va.date,'%d-%m-%Y')>=curdate() ");

                } else if (status.equals("Not-Vacinated")) {
                    ans = new RDBMS_TO_JSON().generateJSON("select va.avail_id,v.vid,v.name,v.price,v.minimum_age,v.doses,va.date,va.quantity from vaccine_availability va ,vaccines v where va.vid=v.vid and va.vcid=" + vcid + " and str_to_date(va.date,'%d-%m-%Y')>=curdate() ");
                }
                out.println(ans);
            } 
            else 
            {
                out.println("Fail");
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
