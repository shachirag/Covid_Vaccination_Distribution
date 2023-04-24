
import java.io.*;
import java.sql.ResultSet;
import java.sql.Time;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.RDBMS_TO_JSON;

@MultipartConfig
public class BookAppointmentResponse extends HttpServlet {
//and status='pending' and str_to_date(date,'%d-%m-%Y')<=curdate() and time<current_time()

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        try {

            if (request.getParameter("vcid") != null && request.getParameter("mid") != null && request.getParameter("vid") != null && request.getParameter("time") != null && request.getParameter("date") != null) {
                //System.out.println(" PAI SAAB M CHLDA PYA ");
                int vcid = Integer.parseInt(request.getParameter("vcid"));
                int vid = Integer.parseInt(request.getParameter("vid"));
                int avail_id = Integer.parseInt(request.getParameter("avail_id"));
                int mid = Integer.parseInt(request.getParameter("mid"));
                String time = request.getParameter("time");
                String date = request.getParameter("date");
                ResultSet rs = DBLOADER.executeSQl("select * from appointments where mid = " + mid);

                while (rs.next()) {

                }
                if (rs.previous()) {

                    if (rs.getString("status").equals("pending")) {
                        out.println("Already-Booked on :: " + rs.getString("date") + " Time :: " + rs.getString(5));
                    } else if (rs.getString("status").equals("missed")) {
                        rs.updateInt(3, vid);
                        rs.updateInt(4, vcid);
                        rs.updateString(5, time);
                        rs.updateString("date", date);
                        rs.updateString("status", "pending");
                        rs.updateRow();
                        decrementavail(avail_id);
                        out.println("Reschduled");
                    } else if (rs.getString("status").equals("completed")) {
                        rs.moveToInsertRow();
                        rs.updateInt(2, mid);
                        rs.updateInt(3, vid);
                        rs.updateInt(4, vcid);
                        rs.updateString(5, time);
                        rs.updateString(6, date);
                        rs.updateString(7, "pending");
                        rs.insertRow();
                        decrementavail(avail_id);
                        out.println("success");
                    }
                } else {
                    rs.moveToInsertRow();
                    rs.updateInt(2, mid);
                    rs.updateInt(3, vid);
                    rs.updateInt(4, vcid);
                    rs.updateString(5, time);
                    rs.updateString(6, date);
                    rs.updateString(7, "pending");
                    rs.insertRow();
                    decrementavail(avail_id);
                    out.println("success");
                }

            } else {

                out.println("Fail");
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    protected void decrementavail(int avail_id) 
    {
        try 
        {
            ResultSet rs = DBLOADER.executeSQl("select * from vaccine_availability where avail_id = " + avail_id);
            if (rs.next()) 
            {
                rs.updateInt("quantity", (rs.getInt("quantity")-1));
                rs.updateRow();
                
            }
        }
        catch(Exception ex )
        {
            System.out.println(ex.toString());
        }
    }

}
