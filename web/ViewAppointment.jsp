<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Members-Details</title>
        <script>
            function cancelappointmentfunction(id)
            {
                if (confirm("Are you sure to delete !"))
                {
                    var xhttp = new XMLHttpRequest();

                    xhttp.onreadystatechange = function ()
                    {
                        // Browser is ready and server also sends 200 OK
                        if (this.readyState == 4 && this.status == 200)
                        {
                            var res = this.responseText.toString().trim();
                            if (res == "Appointment Cancelled")
                            {
                                location.reload();
                            }

                        }


                    };

                    xhttp.open("GET", "./CancelAppointmentResponse?appoint_id=" + id, false);

                    xhttp.send();
                } else 
                {
                }
               
            }
            function bookappointmentfunction(mid)
            {
                
                window.open("ShowVaccineCenters.jsp?mid=" + mid, "_self");
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
                var mid = document.getElementById("mid").value;
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
                                ans = ans + "<div class='col-md-5' style='border: #FF4F5B dashed  thick' ><br><br>";
                                ans = ans + "<h1 class='text-center jumbotron'>Shot Number :: "+(i+1)+"</h1><br>";
                                ans = ans + "<h3> Member_Name :: " + arr[i]["name"] + "</h3><br>";
                                ans = ans + "<h3> Vaccine_Name :: " + arr[i]["vaccine_name"] + "</h3><br>";
                                ans = ans + "<h3> Vaccine_Center_Name :: " + arr[i]["vaccine_center_name"] + "</h3><br>";
                                ans = ans + "<h3> Date :: " + arr[i]["date"] + "</h3><br>";
                                ans = ans + "<h3> Time :: " + arr[i]["time"] + "</h3><br>";
                                ans = ans + "<h3> status :: " + arr[i]["status"] + "</h3><br>";
                                if (arr[i]["status"] == "missed")
                                {
                                    ans = ans + "<input type='button' value='Reschedule-Appointment' class='btn btn-block btn-info'  onclick='bookappointmentfunction(" + arr[i]["mid"] + ")' /><br><br><br>";
                                } else if (arr[i]["status"] == "pending")
                                {
                                    ans = ans + "<input type='button' value='Cancel-Appointment' class='btn btn-block btn-info'  onclick='cancelappointmentfunction(" + arr[i]["id"] + ")' /><br><br><br>";
                                }
                                ans = ans + "</div>";

                            }
                        }

                        document.getElementById("div1").innerHTML = ans;
                    }
                };

                xhttp.open("GET", "./ViewAppointmentResponse?mid=" + mid, true);

                xhttp.send();
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
    <body onload="showappointmentfunction()">

        <!-- header section starts  -->
        <jsp:include page="header.jsp" />
        <!-- header section ends  -->
        <%
            if (request.getSession().getAttribute("phone") == null) {
                response.sendRedirect("LoginUser.jsp");
            }
        %>


        <div style="height: 128px;"></div>

        <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Appointment Details</h1>
        <%
            int mid = Integer.parseInt(request.getParameter("mid"));
        %>
        <input type="text" value = "<%=mid%>" id="mid" style="display: none">
        <div class="container" >
            <div id="div1" class="row ">

            </div>
            <div  class="row  " >
                <br><br><br>
            </div>
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