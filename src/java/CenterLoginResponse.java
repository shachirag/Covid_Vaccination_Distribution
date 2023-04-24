/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vmm.DBLOADER;

/**
 *
 * @author Vasu
 */
public class CenterLoginResponse extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out  = response.getWriter();
         
        try
        {
        int vcid = Integer.parseInt(request.getParameter("vcid"));
        String password= request.getParameter("password");
        ResultSet rs = DBLOADER.executeSQl("select * from vaccine_centers where vcid='"+vcid+"'");
            if(rs.next())
            {
                    if(rs.getString("password").equals(password))
                    {
                        request.getSession().setAttribute("vcid", vcid);
                        request.getSession().setAttribute("vcname",rs.getString("name"));
                        out.println("Success");
                    }
                    else
                    {
                        out.println("Fail");
                    }
            }  
                
       }
        catch(Exception ex )
        {
            out.println(ex.toString());
        }  
    }

    
}
