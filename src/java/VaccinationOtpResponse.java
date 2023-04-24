import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;


public class VaccinationOtpResponse extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       response.setContentType("text/html");
        
       PrintWriter out  = response.getWriter();
         
       try
       {
        // Extract text
        int mid = Integer.parseInt(request.getParameter("mid"));
        
        // Now Insert in Database
        ResultSet rs = DBLOADER.executeSQl("select * from members where mid=\'"+mid+"\'");
        if(rs.next())
        {
           int otp=(int)(1000+(9999-1000)*Math.random());
            System.out.println("My OTP is  :: "+otp);
            out.println(otp+"");
        }
        else
        {
           out.println("Member doesnot Exist");
        }
       }
       catch(Exception ex)
       {
           out.println(ex.toString());
       }
    }
}
