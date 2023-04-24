<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Covid-19 Website Design Tutorial</title>
        <script>
            function loginfunction()
            {
               var username= document.getElementById("username").value;
               var password = document.getElementById("password").value;
               if( password == "" || username== "" )
                {
                    document.getElementById("div1").innerHTML = "All Fields are required";
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
                            if(res=="Fail")
                            {
                                 document.getElementById("div1").innerHTML = "Check Your Password Please";
                            }
  
                            else if(res=="Success")
                            {
                               window.open("AdminHome.jsp","_self");
                             
                            }
                            else
                            {
                              document.getElementById("div1").innerHTML = this.responseText;
                            }
                            
                        }
                    };

                    xhttp.open("GET", "./AdminLoginResponse?username="+username+"&password="+password, true);
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

        <jsp:include page="AdminHeader.jsp" />

        
        
        <div style="height: 100px;"></div>
        <div style="height: 500px;">
            <h1 class="text-center jumbotron  "  style="background:#FF4F5B" id="heading">Admin Login</h1>
            <div >
                <div class="row">
                    <div class="col-4">
                    </div>
                    <div class="col-4">
                        <div>
                            <form>
                                <input type="text" class="form-control" placeholder="Enter UserName" id="username" />
                                <br>
                                <input type="password" class="form-control" placeholder="Enter password" id="password" />
                                <br>
                                <input type="button" value="LOGIN" class="btn btn-block btn-info"  onclick="loginfunction()" />
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