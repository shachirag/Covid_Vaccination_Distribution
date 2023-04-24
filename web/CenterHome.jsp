<%@page import="vmm.DBLOADER"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Covid-19 Website Design Tutorial</title>
        <script>

        </script>
        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/style.css">


    </head>
    <body>

        <jsp:include page="CenterHeader.jsp" />
        <%
            if (request.getSession().getAttribute("vcid") == null) {
                response.sendRedirect("LoginCenter.jsp");
            }
        %>

        <div style="height: 128px;"></div>
        <div >
            <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Center Home</h1>

            <div  class="container">
                <div class="row">

                    <div id="div1" class="col-md-4"></div>


                    <div id="div1" class="col-md-4">


                        <input type="button" value="Add Staff" class="btn btn-block btn-info" onclick="document.location.href = 'AddStaff.jsp'"/>
                        <input type="button" value="Manage Staff" class="btn btn-block btn-info" onclick="document.location.href = 'ShowStaff.jsp'"/>
                        <input type="button" value="Add Vaccine Availability info" class="btn btn-block btn-info" onclick="document.location.href = 'AddVaccineAvailability.jsp'"/>
                        <input type="button" value="Show Vaccine Availability info" class="btn btn-block btn-info" onclick="document.location.href = 'ShowVaccineAvailability.jsp'"/>



                    </div>
                    <div id="div1" class="col-md-4"></div>




                </div>


            </div>
            <br>


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