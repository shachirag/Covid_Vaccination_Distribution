<%@page import="java.util.Date"%>
<%@page import="vmm.DBLOADER"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Center-Details</title>
        <script>
           
           function deleterowfunction(avail_id)
           {
               if(confirm("Are Sure You Want to Delete !!"))
               {
                    var xhttp = new XMLHttpRequest();

                    xhttp.onreadystatechange = function ()
                    {
                        // Browser is ready and server also sends 200 OK
                        if (this.readyState == 4 && this.status == 200)
                        {
                            var res = this.responseText.toString().trim();
                            if (res == "Row Deleted")
                            {
                                location.reload();
                            }

                        }


                    };

                    xhttp.open("GET", "./DeleteRowResponse?avail_id=" + avail_id, false);

                    xhttp.send();
               }
               else
               {
                   
               }
               
           }
           
           
            function showavailabilityfunction()
            {
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
                            ans = ans + "<table class='table table-hover'>";
                            ans = ans + "<tr><th>Vaccine Name</th><th>Date</th><th>Quantity</th><th>Delete</th></tr>";
                            for (var i = 0; i < arr.length; i++)
                            {
                                ans=ans+"<tr>"
                                 ans = ans + "<td>" + arr[i]["name"] + "</td>";
                                 ans = ans + "<td>" + arr[i]["date"] + "</td>";
                                 ans = ans + "<td>" + arr[i]["quantity"] + "</td>";
                                 ans = ans + "<td><input type='button' value='Delete' class=' btn-block btn-info'  style='height:40px;width:100px;font-size:12px;  background-color: #FF4F5B;border-radius: 5rem;'  onclick='deleterowfunction("+ arr[i]["avail_id"]+ " )' /></td>";
                                 ans = ans + "</tr>";
                            }
                            ans = ans + "</table>";
                            document.getElementById("div1").innerHTML = ans;
                        }
                    };

                    xhttp.open("GET", "./ShowVaccineAvailabilityResponse", true);

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
    <body onload="showavailabilityfunction()">

        <!-- header section starts  -->
        <jsp:include page="CenterHeader.jsp" />
        <!-- header section ends  -->
         <%
         if (request.getSession().getAttribute("vcid") == null) {
             response.sendRedirect("LoginCenter.jsp");
         }
        %>


        <div style="height: 128px;"></div>

        <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Manage Vaccine Availability INFO.</h1>
     

        <div  class="container">
            <div class="row">

                <div class="col-3"></div>
                
                <div id="div1" class="col-6  ">
                    
                    
                    
                    
                    
                </div>



                <div class="col-3"></div>
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