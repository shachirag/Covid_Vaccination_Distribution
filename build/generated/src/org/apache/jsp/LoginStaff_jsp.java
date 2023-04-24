package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LoginStaff_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Responsive Covid-19 Website Design Tutorial</title>\n");
      out.write("        <script>\n");
      out.write("            function loginfunction()\n");
      out.write("            {\n");
      out.write("               var staff_id= document.getElementById(\"staff_id\").value;\n");
      out.write("               var password = document.getElementById(\"password\").value;\n");
      out.write("               if( password == \"\" || staff_id== \"\" )\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"div1\").innerHTML = \"All Fields are required\";\n");
      out.write("                } \n");
      out.write("                \n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    var xhttp = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("                    xhttp.onreadystatechange = function ()\n");
      out.write("                    {\n");
      out.write("                        // Browser is ready and server also sends 200 OK\n");
      out.write("                        if (this.readyState == 4 && this.status == 200)\n");
      out.write("                        {\n");
      out.write("                            var res = this.responseText.toString().trim();\n");
      out.write("                            if(res==\"fail\")\n");
      out.write("                            {\n");
      out.write("                    document.getElementById(\"div1\").innerHTML = \"Check Your Password Please\";\n");
      out.write("                            }\n");
      out.write("  \n");
      out.write("                            else if(res==\"Success\")\n");
      out.write("                            {\n");
      out.write("                               window.open(\"StaffHome.jsp\",\"_self\");\n");
      out.write("                             \n");
      out.write("                            }\n");
      out.write("                            else\n");
      out.write("                            {\n");
      out.write("                              document.getElementById(\"div1\").innerHTML = this.responseText;\n");
      out.write("                            }\n");
      out.write("                            \n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("\n");
      out.write("                    xhttp.open(\"GET\", \"./StaffLoginResponse?staff_id=\"+staff_id+\"&password=\"+password, true);\n");
      out.write("                    xhttp.send();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("           \n");
      out.write("         </script>\n");
      out.write("        <!-- font awesome cdn link  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("\n");
      out.write("        <!-- custom css file link  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "StaffHeader.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <div style=\"height: 100px;\"></div>\n");
      out.write("        <div style=\"height: 500px;\">\n");
      out.write("            <h1 class=\"text-center jumbotron  \"  style=\"background:#FF4F5B\" id=\"heading\">Staff Login</h1>\n");
      out.write("            <div >\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-4\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-4\">\n");
      out.write("                        <div>\n");
      out.write("                            <form>\n");
      out.write("                                <input type=\"number\" class=\"form-control\" placeholder=\"Enter Staff Id\" id=\"staff_id\" />\n");
      out.write("                                <br>\n");
      out.write("                                <input type=\"password\" class=\"form-control\" placeholder=\"Enter password\" id=\"password\" />\n");
      out.write("                                <br>\n");
      out.write("                                <input type=\"button\" value=\"LOGIN\" class=\"btn btn-block btn-info\"  onclick=\"loginfunction()\" />\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <h1 id=\"div1\">\n");
      out.write("                            \n");
      out.write("                        </h1>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-4\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <!-- footer section starts  -->\n");
      out.write("\n");
      out.write("           ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    <!-- footer section ends -->\n");
      out.write("\n");
      out.write("    <!-- scroll top  -->\n");
      out.write("\n");
      out.write("    <a href=\"#home\" class=\"scroll-top\">\n");
      out.write("        <img src=\"images/scroll-img.png\" alt=\"\">\n");
      out.write("    </a>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- jquery cdn link  -->\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- custom js file link  -->\n");
      out.write("    <script src=\"js/script.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
