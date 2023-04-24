<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Change Password</title>
        <script>
            function changepassfunction()
            {
               var oldpass = document.getElementById("oldpass").value;
               var newpass = document.getElementById("newpass").value;
               var confirmpass = document.getElementById("confirmpass").value;
               if( oldpass == ""||newpass == ""|| confirmpass == "")
                {
                    document.getElementById("div1").innerHTML = "All Fields are required";
                } 
                else if(newpass != confirmpass)
                {
                   document.getElementById("div1").innerHTML = "Did not match both password..check again";   
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
                            if(res=="fail")
                            {
                                document.getElementById("div1").innerHTML = "Check Your Old-Password Please";
                            }
                            else if(res=="not-verified"||res=="not-register")
                            {
                              document.getElementById("div1").innerHTML = "You are either not registered or have verification pending..please go to signup page!!";
                            }
                            else if(res=="success")
                            {
                                document.getElementById("myform").style.display="none"
                                document.getElementById("div1").innerHTML = "password changed successfully";
                            }
                            else
                            {
                              document.getElementById("div1").innerHTML = this.responseText;
                            }
                            
                        }
                    };

                    xhttp.open("GET", "./ChangePassResponse?oldpass="+oldpass+"&newpass="+newpass, true);
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

        <jsp:include page="header.jsp" />
         <%
         if (request.getSession().getAttribute("phone") == null) {
             response.sendRedirect("LoginUser.jsp");
         }
        %>

        


        <div style="height: 128px;"></div>
        <div style="height: 500px;">
            <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Change-Password</h1>
            <div >
                <div class="row">
                    <div class="col-4">
                    </div>
                    <div class="col-4">
                        <div id ="myform">
                            <form>
                                <input type="password" class="form-control" placeholder="Enter Old Password" id="oldpass" />
                                <br>
                                <input type="password" class="form-control" placeholder="Enter New Password" id="newpass" />
                                <br>
                                <input type="password" class="form-control" placeholder="Confirm New password" id="confirmpass" />
                                <br>
                                <input type="button" value="CHANGE" class="btn btn-block btn-info"  onclick="changepassfunction()" />
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