<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Covid-19 Website Design Tutorial</title>
        <script>
            function addvaccinefunction()
            {
                var name = document.getElementById("name").value;
                var price = document.getElementById("price").value;
                var doses = document.getElementById("doses").value;
                var age = document.getElementById("age").value;
                

                if (name == "" || price== "" || doses == "" ||age == "" )
                {
                    document.getElementById("div1").innerHTML = "All Fields are required";
                } else
                {
                    var xhttp = new XMLHttpRequest();

                    xhttp.onreadystatechange = function ()
                    {
                        // Browser is ready and server also sends 200 OK
                        if (this.readyState == 4 && this.status == 200)
                        {
                            var res = this.responseText.toString().trim();
                            if (res == "Success")
                            {
                                alert("Vaccine added Successfully");
                                window.open("ShowVaccine.jsp?city="+vccity, "_self");
                            } else if (res == "Fail")
                            {
                                document.getElementById("div1").innerHTML = "Vaccine is already added";


                            } else if (res == "Session Expired")
                            {
                                document.getElementById("div1").innerHTML = res;

                            } else
                            {
                                document.getElementById("div1").innerHTML = res;
                            }
                        }
                    };

                    xhttp.open("POST", "./AddVaccineResponse", true);

                    // *** Extra code to add form-data to request ***
                    var formdata = new FormData();

                    formdata.append("name", name);
                    formdata.append("price", price);
                    formdata.append("doses", doses);
                    formdata.append("age", age);
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

                <jsp:include page="AdminHeader.jsp" />



        <div style="height: 128px;"></div>

        <div style="height: 500px;">
            <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading"> Add Vaccine Centers </h1>

            <div >

                <div class="row">
                    <div class="col-md-4">

                    </div>
                    <div class="col-md-4">
                        <div id="sec1">



                            <form>


                                <input type="text" autocorrect="off" autocapitalize="none" class="form-control" placeholder="Enter Vacccine  Name" id="name" />
                                <br>
                                <input type="number" class="form-control" placeholder="Enter Price" id="price" />
                                <br>
                                <input type="number"  class="form-control" placeholder="Enter Doses" id="doses" />
                                <br>
                                <input type="number" class="form-control" placeholder="Enter Minium Age" id="age" />
                                <br>

                                <input type="button" value="ADD" class="btn btn-block btn-info"  onclick="addvaccinefunction()" />



                            </form>
                        </div>



                        <h1 id="div1">

                        </h1>

                    </div>
                    <div class="col-md-4">


                    </div>

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