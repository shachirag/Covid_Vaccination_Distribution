package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vmm.DBLOADER;
import java.sql.ResultSet;

public final class AddVaccineAvailability_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Responsive Covid-19 Website Design Tutorial</title>\n");
      out.write("        <script>\n");
      out.write("            function addcenterfunction()\n");
      out.write("            {\n");
      out.write("                var vcname = document.getElementById(\"vcname\").value;\n");
      out.write("                var e = document.getElementById(\"vccity\");\n");
      out.write("                var vccity = e.options[e.selectedIndex].text;\n");
      out.write("                var vcemail = document.getElementById(\"vcemail\").value;\n");
      out.write("                var vcaddress = document.getElementById(\"vcaddress\").value;\n");
      out.write("                var vcphone = document.getElementById(\"vcphone\").value;\n");
      out.write("                var vcpassword = document.getElementById(\"vcpassword\").value;\n");
      out.write("\n");
      out.write("                if (vcname == \"\" || vccity == \"Select City\" || vcemail == \"\" || vcaddress == \"\" || vcpassword == \"\" || vcphone == \"\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"div1\").innerHTML = \"All Fields are required\";\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    var xhttp = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("                    xhttp.onreadystatechange = function ()\n");
      out.write("                    {\n");
      out.write("                        // Browser is ready and server also sends 200 OK\n");
      out.write("                        if (this.readyState == 4 && this.status == 200)\n");
      out.write("                        {\n");
      out.write("                            var res = this.responseText.toString().trim();\n");
      out.write("                            if (res == \"Success\")\n");
      out.write("                            {\n");
      out.write("                                alert(\"Center added Successfully\");\n");
      out.write("                                window.open(\"ShowCenter.jsp?city=\" + vccity, \"_self\");\n");
      out.write("                            } else if (res == \"Fail\")\n");
      out.write("                            {\n");
      out.write("                                document.getElementById(\"div1\").innerHTML = \"Center is already added\";\n");
      out.write("\n");
      out.write("\n");
      out.write("                            } else if (res == \"Session Expired\")\n");
      out.write("                            {\n");
      out.write("                                document.getElementById(\"div1\").innerHTML = res;\n");
      out.write("\n");
      out.write("                            } else\n");
      out.write("                            {\n");
      out.write("                                document.getElementById(\"div1\").innerHTML = res;\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("\n");
      out.write("                    xhttp.open(\"POST\", \"./AddCenterResponse\", true);\n");
      out.write("\n");
      out.write("                    // *** Extra code to add form-data to request ***\n");
      out.write("                    var formdata = new FormData();\n");
      out.write("\n");
      out.write("                    formdata.append(\"vcname\", vcname);\n");
      out.write("                    formdata.append(\"vccity\", vccity);\n");
      out.write("                    formdata.append(\"vcemail\", vcemail);\n");
      out.write("                    formdata.append(\"vcphone\", vcphone);\n");
      out.write("                    formdata.append(\"vcaddress\", vcaddress);\n");
      out.write("                    formdata.append(\"vcpassword\", vcpassword);\n");
      out.write("\n");
      out.write("\n");
      out.write("                    xhttp.send(formdata);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <!-- font awesome cdn link  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <!-- custom css file link  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .dropbtn {\n");
      out.write("                color: #666;\n");
      out.write("                padding: 16px;\n");
      out.write("                font-size: 16px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown {\n");
      out.write("                position: relative;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content {\n");
      out.write("                display: none;\n");
      out.write("                position: absolute;\n");
      out.write("                background-color: #f1f1f1;\n");
      out.write("                min-width: 160px;\n");
      out.write("                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a {\n");
      out.write("                color: black;\n");
      out.write("                padding: 12px 16px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                display: block;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .dropdown-content a:hover {background-color: #ddd;}\n");
      out.write("\n");
      out.write("            .dropdown:hover .dropdown-content {display: block;}\n");
      out.write("\n");
      out.write("            .dropdown:hover .dropbtn {background-color: #FF4F5B;}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- header section starts  -->\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "CenterHeader.jsp", out, false);
      out.write("\n");
      out.write("      \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div style=\"height: 128px;\"></div>\n");
      out.write("\n");
      out.write("        <div style=\"height: 500px;\">\n");
      out.write("            <h1 class=\"text-center jumbotron  \"  style=\"background:#FF4F5B\" id=\"heading\"> Add Vaccine Availability INFO. </h1>\n");
      out.write("\n");
      out.write("            <div >\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("                        <div id=\"sec1\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <form>                             \n");
      out.write("                                <select id=\"vaccinelist\" class=\"form-control\" >\n");
      out.write("                                    <option>Select City</option>\n");
      out.write("\n");
      out.write("                                    ");
                          
                                        try {
                                            ResultSet rs = DBLOADER.executeSQl("select * from vaccines");
                                            while (rs.next()) {
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                    <option>");
      out.print( rs.getString("name")  );
      out.write("</option>\n");
      out.write("\n");
      out.write("                                    ");

                                            }
                                        } catch (Exception ex) {
                                            System.out.println(ex.toString());
                                        }
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <br>\n");
      out.write("\n");
      out.write("                                <input type=\"date\" class=\"form-control\" placeholder=\"Enter Date\" id=\"date\" />\n");
      out.write("                                <br>\n");
      out.write("                                 <input type=\"number\" class=\"form-control\" placeholder=\"Enter Quantity\" id=\"quantity\" />\n");
      out.write("                                <br>\n");
      out.write("\n");
      out.write("                                <input type=\"button\" value=\"ADD\" class=\"btn btn-block btn-info\"  onclick=\"addcenterfunction()\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <h1 id=\"div1\">\n");
      out.write("\n");
      out.write("                        </h1>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-4\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
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
      out.write("        \n");
      out.write("        <!-- footer section starts  -->\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <!-- footer section ends -->\n");
      out.write("\n");
      out.write("        <!-- scroll top  -->\n");
      out.write("\n");
      out.write("        <a href=\"#home\" class=\"scroll-top\">\n");
      out.write("            <img src=\"images/scroll-img.png\" alt=\"\">\n");
      out.write("        </a>\n");
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
      out.write("        <!-- jquery cdn link  -->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- custom js file link  -->\n");
      out.write("        <script src=\"js/script.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
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
