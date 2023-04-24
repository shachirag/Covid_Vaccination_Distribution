<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="vmm.DBLOADER"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Members-Details</title>
        <script>

            function checkstatus()
            {
                var xhttp = new XMLHttpRequest();

                xhttp.onreadystatechange = function ()
                {
                    // Browser is ready and server also sends 200 OK
                    if (this.readyState == 4 && this.status == 200)
                    {

                    }


                };

                xhttp.open("GET", "./CheckStatusResponse", false);

                xhttp.send();
            }
            function bookappointmentfunction()
            {
                checkstatus();
                var mid = document.getElementById("mid").value;
                var vcid = document.getElementById("vcid").value;
                var vid = document.getElementById("vid").value;

                var radios = document.getElementById("form1").elements['time'];
                var value = null;
                for (var i = 0; i < radios.length; i++)
                {
                    if (radios[i].type == 'radio' && radios[i].checked)
                    {
                        // get value, set checked flag or do whatever you need to
                        value = radios[i].value;
                    }
                }
                if (value == null)
                {
                    document.getElementById("error").innerHTML = "Select Time slot first !!";
                } else
                {

                    var xhttp = new XMLHttpRequest();

                    xhttp.onreadystatechange = function ()
                    {
                        // Browser is ready and server also sends 200 OK
                        if (this.readyState == 4 && this.status == 200)
                        {
                            var res = this.responseText.toString().trim();
                            // document.getElementById("error").innerHTML =res;
                            alert(res);
                            window.open("ViewAppointment.jsp?mid=" + mid, "_self");


                        }
                    };

                    xhttp.open("POST", "./BookAppointmentResponse", true);

                    // *** Extra code to add form-data to request ***
                    var formdata = new FormData();

                    //console.log(mid+" "+vcid+" "+vid+" "+value+" "+document.getElementById("date").value);

                    formdata.append("avail_id", document.getElementById("avail_id").value);
                    formdata.append("mid", mid);
                    formdata.append("vcid", vcid);
                    formdata.append("vid", vid);
                    formdata.append("time", value);
                    formdata.append("date", document.getElementById("date").value);


                    xhttp.send(formdata);




                }
            }

        </script>
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">

        <style>
            .dropbtn {
                color: #666;
                padding: 16px;
                font-size: 16px;
            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f1f1f1;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            .dropdown-content a:hover {background-color: #ddd;}

            .dropdown:hover .dropdown-content {display: block;}

            .dropdown:hover .dropbtn {background-color: #FF4F5B;}




        </style>


    </head>
    <body>

        <!-- header section starts  -->
        <jsp:include page="header.jsp" />
        <!-- header section ends  -->
        <%
            if (request.getSession().getAttribute("phone") == null) {
                response.sendRedirect("LoginUser.jsp");
            }
        %>


        <div style="height: 128px;"></div>

        <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Booking Appoinments</h1>
        <div class="container">
            <div class="row">

                <%
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


                %>
                <div class="col-4"></div>
                <div class="col-4">
                    <form id="form1">
                        <input type="text" class="form-control" value ="<%= mid%>"   id="mid" style="display: none"/>
                        <input type="text" class="form-control" value ="<%= vcid%>"   id="vcid" style="display: none"/>
                        <input type="text" class="form-control" value ="<%= vid%>"   id="vid" style="display: none"/>
                        <input type="text" class="form-control" value ="<%= avail_id%>"   id="avail_id" style="display: none"/>
                        <label for="fname">Member's Name : </label>
                        <input type="text" class="form-control" value ="<%= name%>"  id="name" disabled="true"/>
                        <br>
                        <label for="fname">Member's Age : </label>
                        <input type="number" class="form-control" value ="<%= age%>"  id="age" disabled="true"/>
                        <br>
                        <label for="fname">Vaccination-Center's Name : </label>
                        <input type="text" class="form-control" value ="<%= center_name%>"  id="center_name" disabled="true"/>
                        <br>
                        <label for="fname">Vaccination-Center's Email : </label>
                        <input type="text" class="form-control" value ="<%= center_email%>"  id="center_email" disabled="true"/>
                        <br>
                        <label for="fname">Vaccine-Name : </label>
                        <input type="text" class="form-control" value ="<%= vaccine_name%>"  id="vaccine_name" disabled="true"/>
                        <br>
                        <label for="fname">Appointment-Date : </label>
                        <input type="text" class="form-control" value ="<%= date%>"  id="date" disabled="true"/>
                        <br>
                        <h3>Choose Time Slot :: </h3><br>
                        <table  class=" table table-borderless"  >


                            <%
                                if ((new SimpleDateFormat("dd-MM-yyyy").format(new Date())).equals(date)) {


                            %>
                            <tr>

                                <%                                        if (Integer.parseInt((new SimpleDateFormat("HH").format(new Date()))) < 9) {

                                %>
                                <td>
                                    <input type="radio" id="slot-9" name="time" value="9:00"/>
                                    <label for="slot-9" >9:00 AM</label> 
                                </td>
                                <%                                } else {
                                %>

                                <td>
                                    <input type="radio" id="slot-9" name="time" value="9:00" disabled="true"/>
                                    <label for="slot-9" >9:00 AM</label> 
                                </td>

                                <%
                                    }
                                %>

                                <%                                        if (Integer.parseInt((new SimpleDateFormat("HH").format(new Date()))) < 10) {

                                %>
                                <td>
                                    <input type="radio" id="slot-10" name="time" value="10:00" />
                                    <label for="slot-10" >10:00 AM</label> 
                                </td>
                                <%                                } else {
                                %>

                                <td>
                                    <input type="radio" id="slot-10" name="time" value="10:00" disabled="true"/>
                                    <label for="slot-10" >10:00 AM</label> 
                                </td>

                                <%
                                    }
                                %>
                            </tr>

                            <tr>

                                <%                                        if (Integer.parseInt((new SimpleDateFormat("HH").format(new Date()))) < 11) {

                                %>
                                <td><input type="radio" id="slot-11" name="time" value="11:00"/>
                                    <label for="slot-11" >11:00 AM</label> </td>
                                    <%                                } else {
                                    %>

                                <td><input type="radio" id="slot-11" name="time" value="11:00" disabled="true"/>
                                    <label for="slot-11" >11:00 AM</label> </td>

                                <%
                                    }
                                %>

                                <%                                        if (Integer.parseInt((new SimpleDateFormat("HH").format(new Date()))) < 12) {

                                %>
                                <td>
                                    <input type="radio" id="slot-12" name="time" value="12:00"/>
                                    <label for="slot-12" >12:00 PM</label></td>
                                    <%                                } else {
                                    %>

                                <td>
                                    <input type="radio" id="slot-12" name="time" value="12:00" disabled="true"/>
                                    <label for="slot-12" >12:00 PM</label></td>

                                <%
                                    }
                                %>
                            </tr>


                            <tr>

                                <%                                        if (Integer.parseInt((new SimpleDateFormat("HH").format(new Date()))) < 13) {

                                %>
                                <td><input type="radio" id="slot-1" name="time" value="13:00"/>
                                    <label for="slot-1" >1:00 PM</label> </td>
                                    <%                                } else {
                                    %>

                                <td><input type="radio" id="slot-1" name="time" value="13:00" disabled="true"/>
                                    <label for="slot-1" >1:00 PM</label> </td>

                                <%
                                    }
                                %>

                                <%                                        if (Integer.parseInt((new SimpleDateFormat("HH").format(new Date()))) < 14) {

                                %>
                                <td>
                                    <input type="radio" id="slot-2" name="time" value="14:00"/>
                                    <label for="slot-2" >2:00 PM</label></td>
                                    <%                                } else {
                                    %>

                                <td>
                                    <input type="radio" id="slot-2" name="time" value="14:00" disabled="true"/>
                                    <label for="slot-2" >2:00 PM</label></td>

                                <%
                                    }
                                %>
                            </tr>



                        </table>
                        <br>  
                        <input type="button" value="BOOK-APPOINTMENT" class="btn btn-block btn-info"  onclick="bookappointmentfunction()" />

                    </form>

                    <h3 id="error">
                    </h3>


                </div>




                <%                                             } else {


                %>
                <tr>
                    <td><input type="radio" id="slot-9" name="time" value="9:00"/>
                        <label for="slot-9" >9:00 AM</label> </td><td>
                        <input type="radio" id="slot-10" name="time" value="10:00"/>
                        <label for="slot-10" >10:00 AM</label></td></tr><tr>
                    <td><input type="radio" id="slot-11" name="time" value="11:00"/>
                        <label for="slot-11" >11:00 AM</label> </td><td>
                        <input type="radio" id="slot-12" name="time" value="12:00"/>
                        <label for="slot-12" >12:00 PM</label></td></tr><tr>
                    <td><input type="radio" id="slot-1" name="time" value="13:00"/>
                        <label for="slot-1" >1:00 PM</label> </td><td>
                        <input type="radio" id="slot-2" name="time" value="14:00"/>
                        <label for="slot-2" >2:00 PM</label></td></tr>
                </table>
                <br>  
                <input type="button" value="BOOK-APPOINTMENT" class="btn btn-block btn-info"  onclick="bookappointmentfunction()" />

                </form>

                <h3 id="error">
                </h3>


            </div>
            <div class="col-4"></div>
            <%                      }
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }

            %>
        </div>


        <br><br>
    </div>





    <!-- footer section starts  -->

    <jsp:include page="footer.jsp" />

    <!-- footer section ends -->

    <!-- scroll top  -->

    <a href="#home" class="scroll-top">
        <img src="images/scroll-img.png" alt="">
    </a>















    <!-- jquery cdn link  -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- custom js file link  -->
    <script src="js/script.js"></script>


</body>
</html>