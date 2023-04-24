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
            function showdatesfunction(vcid)
            {
                var mid=document.getElementById("mid").value;
                window.open("ShowDates.jsp?mid="+mid+"&vcid="+vcid,"_self");
            }
            function vaccinecentersfunction()
            {
                var dropdown = document.getElementById("cities");
                var city = dropdown.options[dropdown.selectedIndex].text;
                if (city == "Select City")
                {
                    document.getElementById("div1").innerHTML = "Select Appropiate City Please !!";
                } else
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
                            ans = ans + "<tr><th>Name</th><th>Address</th><th>Email</th><th>Phone</th><th>Book Here</th></tr>";
                            for (var i = 0; i < arr.length; i++)
                            {
                                ans=ans+"<tr>"
                                 ans = ans + "<td>" + arr[i]["name"] + "</td>";
                                 ans = ans + "<td>" + arr[i]["address"] + "</td>";
                                 ans = ans + "<td>" + arr[i]["email"] + "</td>";
                                 ans = ans + "<td>" + arr[i]["phone_no"] + "</td>";
                                 ans = ans + "<td><input type='button' value='Show-Dates' class=' btn-block btn-info'  style='height:40px;width:100px;font-size:12px;  background-color: #FF4F5B;border-radius: 5rem;'  onclick='showdatesfunction(" + arr[i]["vcid"] + ")' /></td>";
                                 ans = ans + "</tr>";
                            }
                            ans = ans + "</table>";
                            document.getElementById("div1").innerHTML = ans;
                        }
                    };

                    xhttp.open("GET", "./VaccineCentersResponse?city=" + city, true);

                    xhttp.send();
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
                    try {
                        ResultSet rs = DBLOADER.executeSQl("select * from members where mid ='" + mid + "'");
                        if (rs.next()) {
                            String name = rs.getString("name");
                            String proof_type = rs.getString("proof_type");
                            int age = 1900+new Date().getYear()-rs.getInt("age");
                            String photo = rs.getString("photo");


                %>
                <div class="col-4"></div>
                <div class="col-4">
                    <form>
                        <input type="text" class="form-control" value ="<%= mid%>"   id="mid" style="display: none"/>
                        <img src = '<%= photo%>' width='100' height='100'/> <br><br>
                        <input type="text" class="form-control" value ="<%= name%>"  placeholder="Enter Name" id="name" disabled="true"/>
                            <br>

                            <input type="number" class="form-control" value ="<%= age%>" placeholder="Enter Age" id="age" disabled="true"/>
                            <br>

                            <select id="cities" class="form-control"  onchange="vaccinecentersfunction()" >
                                <option>Select City</option>

                                <%
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
                                %>

                                <option><%=cities[i]%></option>

                                <%
                                    }
                                %>

                            </select>




                    </form>


                </div>
                <div class="col-4"></div>
                <%
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