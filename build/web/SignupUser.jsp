<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Covid-19 Website Design Tutorial</title>

        <script>
            function signupfunction()
            {
                var phone = document.getElementById("phone").value;
                var name = document.getElementById("name").value;
                var pass = document.getElementById("pass").value;
                var file = document.getElementById("photo");

                if (name == "" || pass == "" || file.files.length == 0)
                {
                    document.getElementById("div1").innerHTML = "All Fields are required";
                }
                else if(phone.length!=10)
                {
                    document.getElementById("div1").innerHTML = "Mobile must be 10 digit long";
                }
                else
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
                                document.getElementById("sec1").style.display = "none";
                                document.getElementById("sec2").style.display = "block";
                                document.getElementById("heading").innerHTML = "OTP-VERIFICATION";
                            }
                            else
                            {
                                document.getElementById("div1").innerHTML = res;
                            }
                        }
                    };

                    xhttp.open("POST", "./SignupResponse", true);

                    // *** Extra code to add form-data to request ***
                    var formdata = new FormData();


                    formdata.append("phone", document.getElementById("phone").value);
                    formdata.append("name", document.getElementById("name").value);
                    formdata.append("pass", document.getElementById("pass").value);
                    formdata.append("photo", document.getElementById("photo").files[0]);


                    xhttp.send(formdata);
                }
            }

            function checkotp()
            {
                var otp = document.getElementById("otp").value;
                var phone = document.getElementById("phone").value;

                if (otp == "")
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
                            if (res == "OTP-VERIFIED")
                            {
                                document.getElementById("sec2").style.display = "none";
                                document.getElementById("div1").innerHTML = this.responseText;
                                alert("Signup Successfull");
                                window.open("LoginUser.jsp","_self");
                            }
                            else
                            {
                                document.getElementById("div1").innerHTML = this.responseText;

                            }
                        }
                    };

                    xhttp.open("GET", "./CheckOtpResponse?otp=" + otp + "&phone=" + phone, true);



                    xhttp.send();
                }
            }

            function checkphone()
            {
                var phone = document.getElementById("phone").value;
                if (phone.length == 10)
                {
                    var xhttp = new XMLHttpRequest();

                    xhttp.onreadystatechange = function ()
                    {
                        // Browser is ready and server also sends 200 OK
                        if (this.readyState == 4 && this.status == 200)
                        {
                            var res = this.responseText.toString().trim();
                            if (res == "verified")
                            {
                                document.getElementById("sec1").style.display = "none";
                                document.getElementById("div1").innerHTML = "User is Already Register with this number proceed to login";
                            } else if (res == "not-verified")
                            {
                                document.getElementById("r1").style.display = "none";
                                document.getElementById("r2").style.display = "block";
                                document.getElementById("div1").innerHTML = "only verification is pending";
                            } else if (res == "not-register")
                            {

                            }
                        }
                    };

                    xhttp.open("GET", "./CheckPhoneResponse?phone=" + phone, true);



                    xhttp.send();
                }
                else
                {
                    document.getElementById("r1").style.display = "block";
                    document.getElementById("r2").style.display = "none";
                    document.getElementById("div1").innerHTML = "";
                }
            }
            
            function generateotponly()
            {
                var phone = document.getElementById("phone").value;
              

                if (phone == "" )
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
                                document.getElementById("sec1").style.display = "none";
                                document.getElementById("sec2").style.display = "block";
                                document.getElementById("heading").innerHTML = "OTP-VERIFICATION";
                            }
                            else
                            {
                                document.getElementById("div1").innerHTML = res;
                            }
                        }
                    };

                    xhttp.open("GET", "./GenerateOtpResponse?phone="+phone, true);

                
                  

                    xhttp.send();
                }
            }
        </script>

        <!-- font awesome cdn link  -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

        <!-- custom css file link  -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>

        <!-- header section starts  -->

               <jsp:include page="header.jsp" />


        <!-- header section ends -->

        <!-- SignUp section starts  -->

        <div style="height: 100px;"></div>

        <div style="height: 500px;">
            <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">User Sign Up</h1>

            <div >

                <div class="row">
                    <div class="col-4">

                    </div>
                    <div class="col-4">
                        <div id="sec1">
                            
                            

                            <form>


                                <input type="number" class="form-control"  placeholder="Enter Phoneno" id="phone" onkeyup ="checkphone()"/>
                                <br>
                                <div id="r1">
                                <input type="text" class="form-control" placeholder="Enter Name" id="name" />
                                <br>

                                <input type="password" class="form-control" placeholder="Enter password" id="pass" />
                                <br>

                                <input type="file" class="form-control"  id="photo" />
                                <br>  

                                <input type="button" value="SUBMIT" class="btn btn-block btn-info"  onclick="signupfunction()" />
                                </div>
                                
                                <div id="r2" style="display: none">
                                    
                                    <input type="button" value="VERIFY-OTP" class="btn btn-block btn-info"  onclick="generateotponly()" />
                                
                                </div>
                            </form>
                        </div>

                        <div  id="sec2" style="display: none" >

                            <form>
                                <input type="number" class="form-control" placeholder="Enter OTP" id="otp" /> 
                                <br>
                                <input type="button" class="btn btn-block btn-info" value="Submit" onclick="checkotp()" />
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

    <!-- SignUp section ends -->

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