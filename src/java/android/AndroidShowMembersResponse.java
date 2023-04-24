
package android;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import vmm.RDBMS_TO_JSON;

public class AndroidShowMembersResponse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
            if (request.getParameter("phone") != null) {
                String phone = request.getParameter("phone").toString();

                String ans = new RDBMS_TO_JSON().generateJSON("select * from members where phone_no='" + phone + "'");

                out.println(ans);
            } else {
                out.println("Fail");
            }
       
    }
}
