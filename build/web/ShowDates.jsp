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
              function showslotsfunction(avail_id)
            {
                var mid=document.getElementById("mid").value;
                var vcid=document.getElementById("vcid").value;
                window.open("ShowSlots.jsp?mid="+mid+"&vcid="+vcid+"&avail_id="+avail_id,"_self");
            }
            function bookdatesfunction()
            {
                var mid = document.getElementById("mid").value;
                var vcid = document.getElementById("vcid").value;
                var age = document.getElementById("age").value;
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
                        ans = ans + "<tr><th>Date</th><th>Vaccine_Name</th><th>Price</th></th><th>Doses</th><th>Minimum Age</th><th>Quantity</th><th>Bookings</th></tr>";
                        for (var i = 0; i < arr.length; i++)
                        {                            
                            ans = ans + "<tr>";
                            ans = ans + "<td>" + arr[i]["date"] + "</td>";
                            ans = ans + "<td>" + arr[i]["name"] + "</td>";
                            ans = ans + "<td>" + arr[i]["price"] + "</td>";
                            ans = ans + "<td>" + arr[i]["doses"] + "</td>";
                            ans = ans + "<td>" + arr[i]["minimum_age"] + "</td>";
                            ans = ans + "<td>" + arr[i]["quantity"] + "</td>";
                            if(age >= arr[i]["minimum_age"])
                            {
                            ans = ans + "<td><input type='button' value='Book-Slots' class=' btn-block btn-info'  style='height:40px;width:120px;font-size:12px;  background-color: #FF4F5B;border-radius: 5rem;'  onclick='showslotsfunction(" + arr[i]["avail_id"] + ")' /></td>";
                            }
                            else
                            {
                            ans = ans +"<td><input type='button' value='Not-Eligible' class='btn-block btn-info'  style=' height:40px;width:120px;font-size:12px;background-color: #e7e7e7;border-radius: 5rem; color: black' /></td>";
                            }
                            ans = ans + "</tr>";
                            
                        }
                        ans = ans + "</table>";
                        document.getElementById("div1").innerHTML = ans;
                    }
                };

                xhttp.open("GET", "./BookDatesResponse?vcid=" + vcid+"&mid="+mid, true);
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
    <body onload="bookdatesfunction()">

        <!-- header section starts  -->
        <jsp:include page="header.jsp" />
        <!-- header section ends  -->


        <div style="height: 128px;"></div>

        <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Booking Appoinments</h1>
        <div class="container">
            <div class="row">

                <%
                    int mid = Integer.parseInt(request.getParameter("mid"));
                    int vcid = Integer.parseInt(request.getParameter("vcid"));
                    try {
                        ResultSet rs = DBLOADER.executeSQl("select * from members where mid ='" + mid + "'");
                        if (rs.next()) {
                            String name = rs.getString("name");
                            int age = 1900+new Date().getYear()-rs.getInt("age");
                            ResultSet rs1 = DBLOADER.executeSQl("select * from vaccine_centers where vcid ='" + vcid + "'");
                            if (rs1.next()) {
                                String center_name = rs1.getString("name");
                                String center_email = rs1.getString("email");


                %>
                <div class="col-4"></div>
                <div class="col-4">
                    <form>
                        <input type="text" class="form-control" value ="<%= mid%>"   id="mid" style="display: none"/>
                        <input type="text" class="form-control" value ="<%= vcid%>"   id="vcid" style="display: none"/>
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


                    </form>


                </div>
                <div class="col-4"></div>
                <%
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                    }

                %>
            </div>


            <br><br>
        </div>

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