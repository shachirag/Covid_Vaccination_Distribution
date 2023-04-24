<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Covid-19 Website Design Tutorial</title>
        <script>
            function addmemberfunction()
            {
                var name = document.getElementById("name").value;
                var e = document.getElementById("prooftype");
                var prooftype = e.options[e.selectedIndex].text;
                var proofnumber = document.getElementById("proofnumber").value;
                var age = document.getElementById("age").value;
                var file = document.getElementById("photo");

                if (name == "" || prooftype == "Choose proof" || proofnumber == "" || age == "" || file.files.length == 0)
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
                              alert("Member added Successfully");
                                window.open("index.jsp", "_self");
                            } else if (res == "Fail")
                            {
                                alert("Member is already added");


                            } else if (res == "Session Expired")
                            {
                                document.getElementById("div1").innerHTML = res;

                            } else
                            {
                                document.getElementById("div1").innerHTML = res;
                            }
                        }
                    };

                    xhttp.open("POST", "./AddMemberResponse", true);

                    // *** Extra code to add form-data to request ***
                    var formdata = new FormData();

                    formdata.append("name", document.getElementById("name").value);
                    formdata.append("proofnumber", document.getElementById("proofnumber").value);
                    formdata.append("prooftype", prooftype);
                    formdata.append("age", document.getElementById("age").value);
                    formdata.append("photo", document.getElementById("photo").files[0]);


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



        <div style="height: 128px;"></div>

        <div style="height: 500px;">
            <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading"> Add Member</h1>

            <div >

                <div class="row">
                    <div class="col-4">

                    </div>
                    <div class="col-4">
                        <div id="sec1">



                            <form>


                                <input type="text" class="form-control" placeholder="Enter Name" id="name" />
                                <br>

                                <select class="form-control" id="prooftype" >
                                    <option value="">Choose proof</option>

                                    <!-- Available Options -->
                                    <option value="1">Adhaar Card</option>
                                    <option value="2">PAN Card</option>
                                    <option value="3"> Driving License</option>
                                    <option value="4">Voter Card</option>
                                    <option value="5">Passport</option>
                                </select>
                                <br>
                                <input type="number" class="form-control" placeholder="Enter Proofnumber" id="proofnumber" />
                                <br>
                                <input type="number" class="form-control" placeholder="Enter Birth Year" id="age" />
                                <br>

                                <input type="file" class="form-control"  id="photo" />
                                <br>  

                                <input type="button" value="ADD" class="btn btn-block btn-info"  onclick="addmemberfunction()" />



                            </form>
                        </div>



                        <h1 id="div1">

                        </h1>

                    </div>
                    <div class="col-4">


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