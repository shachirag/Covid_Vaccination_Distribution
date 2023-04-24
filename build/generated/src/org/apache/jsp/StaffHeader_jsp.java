package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class StaffHeader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("        <header>\n");
      out.write("\n");
      out.write("            <a href=\"#\" class=\"logo\">C<span class=\"fas fa-virus\"></span>VID-G<span class=\"fas fa-virus\"></span></a>\n");
      out.write("\n");
      out.write("            <div id=\"menu\" class=\"fas fa-bars\"></div>\n");
      out.write("\n");
      out.write("            <nav class=\"navbar\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a  href=\"StaffHome.jsp\">Staff Home</a></li>\n");
      out.write("                        ");

                            if (request.getSession().getAttribute("staff_id") != null && request.getSession().getAttribute("vcid") != null && request.getSession().getAttribute("name") != null )
                            {
                                int vcid = Integer.parseInt(request.getSession().getAttribute("vcid").toString());
                                int staff_id = Integer.parseInt(request.getSession().getAttribute("staff_id").toString());
                                String name = request.getSession().getAttribute("name").toString();
                            

                        
      out.write("\n");
      out.write("                     \n");
      out.write("                    <li>\n");
      out.write("                        <div class=\"dropdown\">\n");
      out.write("                            <button class=\"dropbtn\">HII ");
      out.print(name);
      out.write("</button>\n");
      out.write("                            <div class=\"dropdown-content\">\n");
      out.write("                               <a href=\"StaffChangePassword.jsp\">Change_Password</a>\n");
      out.write("                                <a href=\"./StaffLogoutResponse\">Logout</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
                    } else {
                    
      out.write("\n");
      out.write("                    <li> <a href = \"LoginStaff.jsp\" > Login </a> </li>\n");
      out.write("                   \n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("        </header>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
