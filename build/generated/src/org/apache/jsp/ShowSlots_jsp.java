package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import vmm.DBLOADER;
import java.sql.ResultSet;

public final class ShowSlots_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Members-Details</title>\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            function bookappointmentfunction()\n");
      out.write("            {\n");
      out.write("                var mid = document.getElementById(\"mid\").value;\n");
      out.write("                var vcid = document.getElementById(\"vcid\").value;\n");
      out.write("                var vid = document.getElementById(\"vid\").value;\n");
      out.write("\n");
      out.write("                var radios = document.getElementById(\"form1\").elements['time'];\n");
      out.write("                var value = null;\n");
      out.write("                for (var i = 0; i < radios.length; i++)\n");
      out.write("                {\n");
      out.write("                    if (radios[i].type == 'radio' && radios[i].checked)\n");
      out.write("                    {\n");
      out.write("                        // get value, set checked flag or do whatever you need to\n");
      out.write("                        value = radios[i].value;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                if (value == null)\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"error\").innerHTML = \"Select Time slot first !!\";\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("\n");
      out.write("                    var xhttp = new XMLHttpRequest();\n");
      out.write("\n");
      out.write("                    xhttp.onreadystatechange = function ()\n");
      out.write("                    {\n");
      out.write("                        // Browser is ready and server also sends 200 OK\n");
      out.write("                        if (this.readyState == 4 && this.status == 200)\n");
      out.write("                        {\n");
      out.write("                            var res = this.responseText.toString().trim();\n");
      out.write("                    document.getElementById(\"error\").innerHTML =res;\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("\n");
      out.write("                    xhttp.open(\"POST\", \"./BookAppointmentResponse\", true);\n");
      out.write("\n");
      out.write("                    // *** Extra code to add form-data to request ***\n");
      out.write("                    var formdata = new FormData();\n");
      out.write("\n");
      out.write("                     console.log(mid+\" \"+vcid+\" \"+vid+\" \"value\" \"+document.getElementById(\"date\").value);\n");
      out.write("                    formdata.append(\"mid\", mid);\n");
      out.write("                    formdata.append(\"vcid\", vcid);\n");
      out.write("                    formdata.append(\"vid\", vid);\n");
      out.write("                    formdata.append(\"time\", value);\n");
      out.write("                    formdata.append(\"date\", document.getElementById(\"date\").value);\n");
      out.write("\n");
      out.write("\n");
      out.write("                    xhttp.send(formdata);\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
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
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("        <!-- header section ends  -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div style=\"height: 128px;\"></div>\n");
      out.write("\n");
      out.write("        <h1 class=\"text-center jumbotron  \"  style=\"background:#FF4F5B\" id=\"heading\">Booking Appoinments</h1>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                ");

                    int mid = Integer.parseInt(request.getParameter("mid"));
                    int vcid = Integer.parseInt(request.getParameter("vcid"));
                    int avail_id = Integer.parseInt(request.getParameter("avail_id"));
                    try {
                        ResultSet rs = DBLOADER.executeSQl("select * from members where mid ='" + mid + "'");
                        if (rs.next()) {
                            String name = rs.getString("name");
                            int age = 1900 + new Date().getYear() - rs.getInt("age");
                            ResultSet rs1 = DBLOADER.executeSQl("select * from vaccine_centers where vcid ='" + vcid + "'");
                            if (rs1.next()) {
                                String center_name = rs1.getString("name");
                                String center_email = rs1.getString("email");
                                ResultSet rs2 = DBLOADER.executeSQl("select va.avail_id,v.vid,v.name,v.price,v.minimum_age,v.doses,va.date,va.quantity from vaccine_availability va ,vaccines v where va.vid=v.vid and va.avail_id=" + avail_id + "");
                                if (rs2.next()) {
                                    String date = rs2.getString("date");
                                    String vaccine_name = rs2.getString("name");
                                    int vid = rs2.getInt("vid");


                
      out.write("\n");
      out.write("                <div class=\"col-4\"></div>\n");
      out.write("                <div class=\"col-4\">\n");
      out.write("                    <form id=\"form1\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( mid);
      out.write("\"   id=\"mid\" style=\"display: none\"/>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( vcid);
      out.write("\"   id=\"vcid\" style=\"display: none\"/>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( vid);
      out.write("\"   id=\"vid\" style=\"display: none\"/>\n");
      out.write("                        <label for=\"fname\">Member's Name : </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( name);
      out.write("\"  id=\"name\" disabled=\"true\"/>\n");
      out.write("                        <br>\n");
      out.write("                        <label for=\"fname\">Member's Age : </label>\n");
      out.write("                        <input type=\"number\" class=\"form-control\" value =\"");
      out.print( age);
      out.write("\"  id=\"age\" disabled=\"true\"/>\n");
      out.write("                        <br>\n");
      out.write("                        <label for=\"fname\">Vaccination-Center's Name : </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( center_name);
      out.write("\"  id=\"center_name\" disabled=\"true\"/>\n");
      out.write("                        <br>\n");
      out.write("                        <label for=\"fname\">Vaccination-Center's Email : </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( center_email);
      out.write("\"  id=\"center_email\" disabled=\"true\"/>\n");
      out.write("                        <br>\n");
      out.write("                        <label for=\"fname\">Vaccine-Name : </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( vaccine_name);
      out.write("\"  id=\"vaccine_name\" disabled=\"true\"/>\n");
      out.write("                        <br>\n");
      out.write("                        <label for=\"fname\">Appointment-Date : </label>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( date);
      out.write("\"  id=\"date\" disabled=\"true\"/>\n");
      out.write("                        <br>\n");
      out.write("                        <h3>Choose Time Slot :: </h3><br>\n");
      out.write("                        <table  class=\" table table-borderless\"  >\n");
      out.write("                            <tr>\n");
      out.write("                                <td><input type=\"radio\" id=\"slot-9\" name=\"time\" value=\"9:00\"/>\n");
      out.write("                                    <label for=\"slot-9\" >9:00 AM</label> </td><td>\n");
      out.write("                                    <input type=\"radio\" id=\"slot-10\" name=\"time\" value=\"10:00\"/>\n");
      out.write("                                    <label for=\"slot-10\" >10:00 AM</label></td></tr><tr>\n");
      out.write("                                <td><input type=\"radio\" id=\"slot-11\" name=\"time\" value=\"11:00\"/>\n");
      out.write("                                    <label for=\"slot-11\" >11:00 AM</label> </td><td>\n");
      out.write("                                    <input type=\"radio\" id=\"slot-12\" name=\"time\" value=\"12:00\"/>\n");
      out.write("                                    <label for=\"slot-12\" >12:00 PM</label></td></tr><tr>\n");
      out.write("                                <td><input type=\"radio\" id=\"slot-1\" name=\"time\" value=\"13:00\"/>\n");
      out.write("                                    <label for=\"slot-1\" >1:00 PM</label> </td><td>\n");
      out.write("                                    <input type=\"radio\" id=\"slot-2\" name=\"time\" value=\"14:00\"/>\n");
      out.write("                                    <label for=\"slot-2\" >2:00 PM</label></td></tr>\n");
      out.write("                        </table>\n");
      out.write("                        <br>  \n");
      out.write("                        <input type=\"button\" value=\"BOOK-APPOINTMENT\" class=\"btn btn-block btn-info\"  onclick=\"bookappointmentfunction()\" />\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                    <h3 id=\"error\">\n");
      out.write("                    </h3>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-4\"></div>\n");
      out.write("                ");

                                }
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                    }

                
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <br><br>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div  class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("\n");
      out.write("                <div class=\"col-3\"></div>\n");
      out.write("\n");
      out.write("                <div id=\"div1\" class=\"col-6  \">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"col-3\"></div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
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
