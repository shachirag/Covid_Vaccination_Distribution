<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Members-Details</title>
        <script>
            function viewappointmentfunction(mid)
            {
                window.open("ViewAppointment.jsp?mid=" + mid, "_self");
            }
            function bookappointmentfunction(mid)
            {
                var xhttp = new XMLHttpRequest();

                xhttp.onreadystatechange = function ()
                {
                    // Browser is ready and server also sends 200 OK
                    if (this.readyState == 4 && this.status == 200)
                    {
                        var res = this.responseText.toString().trim();
                        if (res == "pending")
                        {
                            alert("You have Pending Appointments Complete them First !!!")
                        } else
                        {
                            window.open("ShowVaccineCenters.jsp?mid=" + mid, "_self");

                        }

                    }
                };

                xhttp.open("GET", "./CheckPendingAppointments?mid=" + mid, true);

                xhttp.send();

            }

            function showmemberfunction()
            {
                var xhttp = new XMLHttpRequest();

                xhttp.onreadystatechange = function ()
                {
                    // Browser is ready and server also sends 200 OK
                    if (this.readyState == 4 && this.status == 200)
                    {
                        var res = this.responseText.toString().trim();
                        console.log(res);
                        if (res != 'Fail')
                        {

                            var mainobj = JSON.parse(res);

                            var arr = mainobj["ans"];
                            console.log(arr);

                            var ans = "";
                            for (var i = 0; i < arr.length; i++)
                            {
                                ans = ans + "<div class='col-md-1'></div>"
                                ans = ans + "<div class='col-md-3'  >";
                                ans = ans + "<img src = '" + arr[i]["photo"] + "' width='100' height='100'      />";
                                ans = ans + "<h3> Name :: " + arr[i]["name"] + "</h3><br>";
                                ans = ans + "<h3> AGE :: " + (new Date().getFullYear() - arr[i]["age"]) + "</h3><br>";
                                ans = ans + "<h3> Proof_Type :: " + arr[i]["proof_type"] + "</h3><br>";
                                ans = ans + "<h3> Status :: " + arr[i]["status"] + "</h3><br>";
                                ans = ans + "<input type='button' value='View-Appointments' class='btn btn-block btn-info'  onclick='viewappointmentfunction(" + arr[i]["mid"] + ")' /><br>";
                                if (arr[i]["status"] == 'Vaccinated')
                                {
                                    ans = ans + "<input type='button' value='Fully-Vaccinated' class='btn btn-block btn-info'  style='background-color: #e7e7e7; color: black' /><br><br><br>";
                                } else
                                {
                                    ans = ans + "<input type='button' value='Book-Appointment' class='btn btn-block btn-info'  onclick='bookappointmentfunction(" + arr[i]["mid"] + ")' /><br><br><br>";
                                }
                                ans = ans + "</div>";

                            }

                            document.getElementById("div1").innerHTML = ans;
                        }
                    }
                };

                xhttp.open("GET", "./ShowMemberResponse", true);

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
    <body onload="showmemberfunction()">

        <!-- header section starts  -->
        <jsp:include page="header.jsp" />
        <!-- header section ends  -->
        <%
            if (request.getSession().getAttribute("phone") == null) {
                response.sendRedirect("LoginUser.jsp");
            }
        %>
        }


        <div style="height: 128px;"></div>

        <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Members Detail</h1>
        <div class="container" >
            <div id="div1" class="row ">

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