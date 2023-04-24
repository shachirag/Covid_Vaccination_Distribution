
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@MultipartConfig
public class AddVaccineAvailabilityResponse extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        int vid=0;

        try {

            // Extract text1
            if (request.getSession().getAttribute("vcid") != null) 
            {
                Date date_temp = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
                
                SimpleDateFormat form= new SimpleDateFormat("dd-MM-yyyy");
                String date = form.format(date_temp);
                
                String quantity = request.getParameter("quantity");
                
                String vaccine_name =request.getParameter("vaccine").trim();
                
                ResultSet rs1=DBLOADER.executeSQl("select * from vaccines where name ='"+vaccine_name+"'");
               
                if(rs1.next())
                {
                    
                vid=rs1.getInt("vid");
                
                }
                
                
                int vcid = Integer.parseInt(request.getSession().getAttribute("vcid").toString());
                
               // System.out.println(vid +"   "+date+"   "+quantity);
                

                // Now Insert in Database
                ResultSet rs = DBLOADER.executeSQl("select * from vaccine_availability where date='" + date + "'  and  vid = '"+vid+ "'  and  vcid = "+vcid);

                if (rs.next()) {
                    out.println("<h3 style=\"color: red\">Dates exist with same vaccine and center!!</h3>");
                } else {
                   
                    rs.moveToInsertRow();
                    rs.updateInt("vid", vid);
                    rs.updateInt("vcid", vcid);
                    rs.updateString("date", date);
                    rs.updateString("quantity",quantity);
                    rs.insertRow();

                    out.println("Success");
                }
            } else {
                out.println("Session Expired");
            }
        } catch (Exception ex) {
            out.println(ex.toString());
        }
    }
}
