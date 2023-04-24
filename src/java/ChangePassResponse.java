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
public class ChangePassResponse extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out  = response.getWriter();
         
        try
        {
        String phone = request.getSession().getAttribute("phone").toString();
        String oldpass = request.getParameter("oldpass");
        String newpass = request.getParameter("newpass");
        ResultSet rs = DBLOADER.executeSQl("select * from users where phone_no='"+phone+"'");
            if(rs.next())
            {
                
                if(rs.getString("status").equals("verified"))
                {
                    if(rs.getString("password").equals(oldpass))
                    {
                       rs.updateString("password", newpass);
                       rs.updateRow();
                       out.println("success");
                    }
                    else
                    {
                        out.println("fail");
                    }
                }
                else
                {
                    out.println("not-verified");
                }
            }
            else
            {
                    out.println("not-register");
            }
       }
        catch(Exception ex )
        {
            out.println(ex.toString());
        }  
    }

    
}
