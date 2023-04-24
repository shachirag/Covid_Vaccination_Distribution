<%@page import="vmm.DBLOADER"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Covid-19 Website Design Tutorial</title>
        <script>
            function generateotp(mid,appoint_id)
            {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function ()
                {
                    // Browser is ready and server also sends 200 OK
                    if (this.readyState == 4 && this.status == 200)
                    {
                        var res = this.responseText.toString().trim();
                        var user_otp = prompt("Please enter OTP:", "####");
                        if (user_otp == null || user_otp == "")
                        {
                            alert("Please Enter OTP");
                        } 
                        else if( user_otp==res) 
                        {
                            vaccinateverifyfunction(mid,appoint_id) ;
                        }
                        else if( user_otp!=res) 
                        {
                            alert("Invalid OTP !! Try Again");
                        }

                    }
                };
                xhttp.open("GET", "./VaccinationOtpResponse?mid=" + mid, true);
                xhttp.send();
               
            }

            function vaccinateverifyfunction(mid, appoint_id)
            {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function ()
                {
                    // Browser is ready and server also sends 200 OK
                    if (this.readyState == 4 && this.status == 200)
                    {
                        var res = this.responseText.toString().trim();
                        if (res == 'Success')
                        {
                            alert("Success");
                            location.reload();
                        }

                    }
                };
                xhttp.open("GET", "./VaccinateVerifyResponse?mid=" + mid + "&appoint_id=" + appoint_id, true);
                xhttp.send();
            }
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
            function showappointmentfunction()
            {
                checkstatus();
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function ()
                {
                    // Browser is ready and server also sends 200 OK
                    if (this.readyState == 4 && this.status == 200)
                    {
                        var res = this.responseText.toString().trim();
                        console.log(res);
                        var mainobj = JSON.parse(res);
                        var arr = mainobj["ans"];
                        console.log(arr);
                        var ans = "";
                        if (arr.length == 0)
                        {
                            ans = ans + "<h1>No Appointments Here !!</h1>";
                        } else
                        {
                            for (var i = 0; i < arr.length; i++)
                            {
                                ans = ans + "<div class='col-md-1'></div>"
                                ans = ans + "<div class='col-md-5 ' style='border: #FF4F5B dashed  thick' ><br><br>";
                                ans = ans + "<h3> Appointment_Id :: " + arr[i]["id"] + "</h3><br>";
                                ans = ans + "<h3> Appointment_Time :: " + arr[i]["time"] + "</h3><br>";
                                ans = ans + "<h3> Vaccine_Name :: " + arr[i]["vaccine_name"] + "</h3><br>";
                                ans = ans + "<h3> Doses :: " + arr[i]["doses"] + "</h3><br>";
                                ans = ans + " <h1 class='text-center'  style='background:#FF4F5B' >Member-Details</h1><br>";
                                ans = ans + "<h3> Member_Name :: " + arr[i]["name"] + "</h3><br>";
                                ans = ans + "<h3> Member_Age :: " + (new Date().getFullYear() - arr[i]["age"]) + "</h3><br>";
                                ans = ans + "<h3> Proof_Type :: " + arr[i]["proof_type"] + "</h3><br>";
                                ans = ans + "<h3> Proof_number :: " + arr[i]["proof_number"] + "</h3><br>";
                                ans = ans + "<h3> status :: " + arr[i]["status"] + "</h3><br>";
                                if (arr[i]["status"] == "missed")
                                {
                                } else if (arr[i]["status"] == "pending")
                                {
                                    ans = ans + "<input type='button' value='VACCINATE' class='btn btn-block btn-info'  onclick='generateotp(" + arr[i]["mid"] + "," + arr[i]["id"] + ")' /><br><br><br>";
                                } else
                                {
                                    ans = ans + "<input type='button' value='VACCINATION DONE' class='btn btn-block btn-info' style='background-color: #e7e7e7; color: black' /><br><br><br>";
                                }
                                ans = ans + "</div>";

                            }
                        }

                        document.getElementById("div1").innerHTML = ans;
                    }
                };

                xhttp.open("GET", "./ViewCenterAppointmentResponse", true);

                xhttp.send();
            }




        </script>
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body onload='showappointmentfunction()'>

        <jsp:include page="StaffHeader.jsp" />
        <%
            if (request.getSession().getAttribute("staff_id") == null) {
                response.sendRedirect("LoginStaff.jsp");
            }
        %>

        <%
            try {
                if (request.getSession().getAttribute("staff_id") != null && request.getSession().getAttribute("vac_id") != null && request.getSession().getAttribute("staff_name") != null) {
                    int vac_id = Integer.parseInt(request.getSession().getAttribute("vac_id").toString());
                    int staff_id = Integer.parseInt(request.getSession().getAttribute("staff_id").toString());
                    String name = request.getSession().getAttribute("staff_name").toString();
                    ResultSet rs = DBLOADER.executeSQl("select * from vaccine_centers where vcid='" + vac_id + "'");
                    if (rs.next()) {

        %>

        <div style="height: 128px;"></div>
        <div >
            <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Center Name :: <%=rs.getString("name")%></h1>
            <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Today's Appointments</h1>

            <div class="container" >
                <div id="div1" class="row ">

                </div>
                <div  class="row " >
                    <br><br><br>
                </div>
            </div>
        </div>

        <%
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        %>

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