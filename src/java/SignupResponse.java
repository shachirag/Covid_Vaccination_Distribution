import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;

@MultipartConfig
public class SignupResponse extends HttpServlet 
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       response.setContentType("text/html");
        
       PrintWriter out  = response.getWriter();
         
       try
       {
        
        // Extract text
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String phone = request.getParameter("phone");
        
        // Extract file 
        Part photo = request.getPart("photo");
        
        
        // Now Insert in Database
        ResultSet rs = DBLOADER.executeSQl("select * from users where phone_no=\'"+phone+"\'");
        
        if(rs.next())
        {
           out.println("<h3 style=\"color: red\">Username Already Taken</h3>");
        }
        else
        {
            //  Save files on server
            String relpath="myuploads";
            String abspath = getServletContext().getRealPath("/"+relpath);
            //out.println(abspath+"<br>");
        
            String new_file_name = System.currentTimeMillis()+"-"+photo.getSubmittedFileName();
        
            String ans1 = FileUploader.savefileonserver(photo, abspath,new_file_name);
            //out.println("File Saved on Server "+ans1+"<br>");
            
            rs.moveToInsertRow();
        
            rs.updateString("phone_no", phone);
            rs.updateString("password", pass);
            rs.updateString("name", name);
            rs.updateString("photo", relpath+"/"+new_file_name );
            rs.updateString("status", "Not-Verified" );
            rs.insertRow();
        
            int otp=(int)(1000+(9999-1000)*Math.random());
            request.getSession().setAttribute("otp", otp);
            System.out.println("My OTP is  :: "+otp);
            out.println("Success");
        }
       }
       catch(Exception ex)
       {
           out.println(ex.toString());
       }
    }
}
