<%@page import="vmm.DBLOADER"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Covid-19 Website Design Tutorial</title>
        <script>
            function  showlivedetails()
            {
                var xhttp = new XMLHttpRequest();

                xhttp.onreadystatechange = function ()
                {
                    // Browser is ready and server also sends 200 OK
                    if (this.readyState == 4 && this.status == 200)
                    {
                        var res = this.responseText.toString().trim();
                        ///console.log(res);

                        var mainobj = JSON.parse(res);

                        var arr = mainobj["statewise"];

                        //var statecount=arr[][]

                        console.log(arr);

                        var ans = "";
                        ans = ans + " <h1 class='text-center jumbotron' style='background-color:#eee'> LIVE INDEX OF COVID CASES </h1>";
                        ans = ans + "<table id='t01' class='table table-hover' >";
                        ans = ans + "<tr><th>Last Updated Time</th><th>State</th><th>Confirmed Cases</th><th>Active Cases</th><th>Recovered Cases</th><th>Total Casualities</th></tr>";
                        for (var i = 0; i < arr.length; i++)
                        {
                            if (i == 31)
                            {
                                continue;
                            }
                            ans = ans + "<tr>"
                            ans = ans + "<td>" + arr[i]["lastupdatedtime"] + "</td>";
                            ans = ans + "<td>" + arr[i]["state"] + "</td>";
                            ans = ans + "<td>" + arr[i]["confirmed"] + "</td>";
                            ans = ans + "<td>" + arr[i]["active"] + "</td>";
                            ans = ans + "<td>" + arr[i]["recovered"] + "</td>";
                            ans = ans + "<td>" + arr[i]["deaths"] + "</td>";

                            ans = ans + "</tr>";
                        }
                        ans = ans + "</table>";
                        document.getElementById("div1").innerHTML = ans;
                    }
                };

                xhttp.open("GET", "https://api.covid19india.org/data.json", true);

                xhttp.send();

            }
        </script>
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">
        <style>
            table {
                width:100%;
            }
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 15px;
                text-align: left;
            }
            #t01 tr:nth-child(even) {
                background-color: #eee;
            }
           
            #t01 tr:nth-child(odd) {
                background-color: #fff;
            }
            #t01 th {
                background-color: black;
                color: white;
            }
        </style>

    </head>
    <body onload="showlivedetails()">

        <jsp:include page="AdminHeader.jsp" />
        <%
            if (request.getSession().getAttribute("username") == null) {
                response.sendRedirect("LoginAdmin.jsp");
            }
        %>

        <div style="height: 128px;"></div>
        <div >
            <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Admin Home</h1>

            <div  class="container">
                <div class="row">


                    <div id="div1" class="col-md-12  ">





                    </div>



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