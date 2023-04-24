package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import vmm.DBLOADER;
import java.sql.ResultSet;

public final class ShowVaccineCenters_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("            function showdatesfunction(vcid)\n");
      out.write("            {\n");
      out.write("                var mid=document.getElementById(\"mid\").value;\n");
      out.write("                window.open(\"ShowDates.jsp?mid=\"+mid+\"&vcid=\"+vcid,\"_self\");\n");
      out.write("            }\n");
      out.write("            function vaccinecentersfunction()\n");
      out.write("            {\n");
      out.write("                var dropdown = document.getElementById(\"cities\");\n");
      out.write("                var city = dropdown.options[dropdown.selectedIndex].text;\n");
      out.write("                if (city == \"Select City\")\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"div1\").innerHTML = \"Select Appropiate City Please !!\";\n");
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
      out.write("                            console.log(res);\n");
      out.write("\n");
      out.write("                            var mainobj = JSON.parse(res);\n");
      out.write("\n");
      out.write("                            var arr = mainobj[\"ans\"];\n");
      out.write("                            console.log(arr);\n");
      out.write("\n");
      out.write("                            var ans = \"\";\n");
      out.write("                            ans = ans + \"<table class='table table-hover'>\";\n");
      out.write("                            ans = ans + \"<tr><th>Name</th><th>Address</th><th>Email</th><th>Phone</th><th>Book Here</th></tr>\";\n");
      out.write("                            for (var i = 0; i < arr.length; i++)\n");
      out.write("                            {\n");
      out.write("                                ans=ans+\"<tr>\"\n");
      out.write("                                 ans = ans + \"<td>\" + arr[i][\"name\"] + \"</td>\";\n");
      out.write("                                 ans = ans + \"<td>\" + arr[i][\"address\"] + \"</td>\";\n");
      out.write("                                 ans = ans + \"<td>\" + arr[i][\"email\"] + \"</td>\";\n");
      out.write("                                 ans = ans + \"<td>\" + arr[i][\"phone_no\"] + \"</td>\";\n");
      out.write("                                 ans = ans + \"<td><input type='button' value='Show-Dates' class=' btn-block btn-info'  style='height:40px;width:100px;font-size:12px;  background-color: #FF4F5B;border-radius: 5rem;'  onclick='showdatesfunction(\" + arr[i][\"vcid\"] + \")' /></td>\";\n");
      out.write("                                 ans = ans + \"</tr>\";\n");
      out.write("                            }\n");
      out.write("                            ans = ans + \"</table>\";\n");
      out.write("                            document.getElementById(\"div1\").innerHTML = ans;\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("\n");
      out.write("                    xhttp.open(\"GET\", \"./VaccineCentersResponse?city=\" + city, true);\n");
      out.write("\n");
      out.write("                    xhttp.send();\n");
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
      out.write("         ");

         if (request.getSession().getAttribute("phone") == null) {
             response.sendRedirect("LoginUser.jsp");
         }
        
      out.write("\n");
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
                    try {
                        ResultSet rs = DBLOADER.executeSQl("select * from members where mid ='" + mid + "'");
                        if (rs.next()) {
                            String name = rs.getString("name");
                            String proof_type = rs.getString("proof_type");
                            int age = 1900+new Date().getYear()-rs.getInt("age");
                            String photo = rs.getString("photo");


                
      out.write("\n");
      out.write("                <div class=\"col-4\"></div>\n");
      out.write("                <div class=\"col-4\">\n");
      out.write("                    <form>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( mid);
      out.write("\"   id=\"mid\" style=\"display: none\"/>\n");
      out.write("                        <img src = '");
      out.print( photo);
      out.write("' width='100' height='100'/> <br><br>\n");
      out.write("                        <input type=\"text\" class=\"form-control\" value =\"");
      out.print( name);
      out.write("\"  placeholder=\"Enter Name\" id=\"name\" disabled=\"true\"/>\n");
      out.write("                            <br>\n");
      out.write("\n");
      out.write("                            <input type=\"number\" class=\"form-control\" value =\"");
      out.print( age);
      out.write("\" placeholder=\"Enter Age\" id=\"age\" disabled=\"true\"/>\n");
      out.write("                            <br>\n");
      out.write("\n");
      out.write("                            <select id=\"cities\" class=\"form-control\"  onchange=\"vaccinecentersfunction()\" >\n");
      out.write("                                <option>Select City</option>\n");
      out.write("\n");
      out.write("                                ");

                                    String cities[] = {
                                        "Amritsar",
                                        "Barnala",
                                        "Bathinda",
                                        "Firozpur",
                                        "Faridkot",
                                        "Fatehgarh Sahib",
                                        "Fazilka",
                                        "Gurdaspur",
                                        "Hoshiarpur",
                                        "Jalandhar",
                                        "Kapurthala",
                                        "Ludhiana",
                                        "Mansa",
                                        "Moga",
                                        "Sri Muktsar Sahib",
                                        "Pathankot",
                                        "Patiala",
                                        "Rupnagar",
                                        "Ajitgarh (Mohali)",
                                        "Sangrur",
                                        "Nawanshahr",
                                        "Tarn Taran",};
                                    for (int i = 0; i < cities.length; i++) {
                                
      out.write("\n");
      out.write("\n");
      out.write("                                <option>");
      out.print(cities[i]);
      out.write("</option>\n");
      out.write("\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-4\"></div>\n");
      out.write("                ");

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
      out.write("                \n");
      out.write("                <div id=\"div1\" class=\"col-6  \">\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                    \n");
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
