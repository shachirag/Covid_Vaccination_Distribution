package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vmm.DBLOADER;
import java.sql.ResultSet;

public final class StaffHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Responsive Covid-19 Website Design Tutorial</title>\n");
      out.write("        <script>\n");
      out.write("            function checkstatus()\n");
      out.write("            {\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    // Browser is ready and server also sends 200 OK\n");
      out.write("                    if (this.readyState == 4 && this.status == 200)\n");
      out.write("                    {\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("\n");
      out.write("                };\n");
      out.write("                xhttp.open(\"GET\", \"./CheckStatusResponse\", false);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("            function showappointmentfunction()\n");
      out.write("            {\n");
      out.write("                checkstatus();\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    // Browser is ready and server also sends 200 OK\n");
      out.write("                    if (this.readyState == 4 && this.status == 200)\n");
      out.write("                    {\n");
      out.write("                        var res = this.responseText.toString().trim();\n");
      out.write("                        console.log(res);\n");
      out.write("                        var mainobj = JSON.parse(res);\n");
      out.write("                        var arr = mainobj[\"ans\"];\n");
      out.write("                        console.log(arr);\n");
      out.write("                        var ans = \"\";\n");
      out.write("                        if (arr.length == 0)\n");
      out.write("                        {\n");
      out.write("                            ans = ans + \"<h1>No Appointments Here !!</h1>\";\n");
      out.write("                        } else\n");
      out.write("                        {\n");
      out.write("                            for (var i = 0; i < arr.length; i++)\n");
      out.write("                            {\n");
      out.write("                                ans = ans + \"<div class='col-1'></div>\"\n");
      out.write("                                ans = ans + \"<div class='col-5' style='border: #FF4F5B dashed  thick' ><br><br>\";\n");
      out.write("                                ans = ans + \"<h3> Appointment_Id :: \" + arr[i][\"id\"] + \"</h3><br>\";\n");
      out.write("                                ans = ans + \"<h3> Appointment_Time :: \" + arr[i][\"time\"] + \"</h3><br>\";\n");
      out.write("                                ans = ans + \"<h3> Vaccine_Name :: \" + arr[i][\"vaccine_name\"] + \"</h3><br>\";\n");
      out.write("                                ans = ans + \"<h3> Doses :: \" + arr[i][\"doses\"] + \"</h3><br>\";\n");
      out.write("                                ans = ans + \" <h1 class='text-center'  style='background:#FF4F5B' >Member-Details</h1><br>\";\n");
      out.write("                                ans = ans + \"<h3> Member_Name :: \" + arr[i][\"name\"] + \"</h3><br>\";\n");
      out.write("                                ans = ans + \"<h3> Member_Age :: \" + (new Date().getFullYear() - arr[i][\"age\"]) + \"</h3><br>\";\n");
      out.write("                                ans = ans + \"<h3> Proof_Type :: \" + arr[i][\"proof_type\"] + \"</h3><br>\";\n");
      out.write("                                ans = ans + \"<h3> Proof_number :: \" + arr[i][\"proof_number\"] + \"</h3><br>\";\n");
      out.write("                                ans = ans + \"<h3> status :: \" + arr[i][\"status\"] + \"</h3><br>\";\n");
      out.write("                                if (arr[i][\"status\"] == \"missed\")\n");
      out.write("                                {\n");
      out.write("                                } else\n");
      out.write("                                {\n");
      out.write("                                    ans = ans + \"<input type='button' value='VACCINATE' class='btn btn-block btn-info'  onclick='' /><br><br><br>\";\n");
      out.write("                                }\n");
      out.write("                                ans = ans + \"</div>\";\n");
      out.write("\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                        document.getElementById(\"div1\").innerHTML = ans;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                xhttp.open(\"GET\", \"./ViewCenterAppointmentResponse\", true);\n");
      out.write("\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <!-- font awesome cdn link  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <!-- custom css file link  -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body onload='showappointmentfunction()'>\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "StaffHeader.jsp", out, false);
      out.write("\n");
      out.write("        ");

            if (request.getSession().getAttribute("staff_id") == null) {
                response.sendRedirect("LoginStaff.jsp");
            }
        
      out.write("\n");
      out.write("\n");
      out.write("        ");

            try {
                if (request.getSession().getAttribute("staff_id") != null && request.getSession().getAttribute("vcid") != null && request.getSession().getAttribute("name") != null) {
                    int vcid = Integer.parseInt(request.getSession().getAttribute("vcid").toString());
                    int staff_id = Integer.parseInt(request.getSession().getAttribute("staff_id").toString());
                    String name = request.getSession().getAttribute("name").toString();
                    ResultSet rs = DBLOADER.executeSQl("select * from vaccine_centers where vcid='" + vcid + "'");
                    if (rs.next()) {

        
      out.write("\n");
      out.write("\n");
      out.write("        <div style=\"height: 128px;\"></div>\n");
      out.write("        <div >\n");
      out.write("            <h1 class=\"text-center jumbotron  \"  style=\"background:#FF4F5B\" id=\"heading\">Center Name :: ");
      out.print(rs.getString("name"));
      out.write("</h1>\n");
      out.write("            <h1 class=\"text-center jumbotron  \"  style=\"background:#FF4F5B\" id=\"heading\">Today's Appointments</h1>\n");
      out.write("\n");
      out.write("            <div class=\"container\" >\n");
      out.write("                <div id=\"div1\" class=\"row \">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div  class=\"row \" >\n");
      out.write("                    <br><br><br>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        
      out.write("\n");
      out.write("\n");
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
      out.write("<!-- Button trigger modal -->\n");
      out.write("<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModal\">\n");
      out.write("  Launch demo modal\n");
      out.write("</button>\n");
      out.write("\n");
      out.write("<!-- Modal -->\n");
      out.write("<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Modal title</h5>\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("        ...\n");
      out.write("      </div>\n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n");
      out.write("        <button type=\"button\" class=\"btn btn-primary\">Save changes</button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
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
