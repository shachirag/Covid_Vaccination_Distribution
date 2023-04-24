import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;


public class GenerateOtpResponse extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       response.setContentType("text/html");
        
       PrintWriter out  = response.getWriter();
         
       try
       {
        // Extract text
        String phone = request.getParameter("phone");
        
        // Now Insert in Database
        ResultSet rs = DBLOADER.executeSQl("select * from users where phone_no=\'"+phone+"\'");
        if(rs.next())
        {
           int otp=(int)(1000+(9999-1000)*Math.random());
            request.getSession().setAttribute("otp", otp);
            System.out.println("My OTP is  :: "+otp);
            out.println("Success");
        }
        else
        {
           out.println("User doesnot Exist");
        }
       }
       catch(Exception ex)
       {
           out.println(ex.toString());
       }
    }
}
