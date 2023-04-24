<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Responsive Covid-19 Website Design Tutorial</title>

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

        <header>

            <a href="#" class="logo">C<span class="fas fa-virus"></span>VID-G<span class="fas fa-virus"></span></a>

            <div id="menu" class="fas fa-bars"></div>

            <nav class="navbar">
                <ul>
                    <li><a class="active" href="#home">home</a></li>
                    <li><a href="#protect">protect</a></li>
                    <li><a href="#symtoms">symtoms</a></li>
                    <li><a href="#prevent">prevent</a></li>
                    <li><a href="#handwash">handwash</a></li>
                    <li><a href="#spread">spread</a></li>
                        <%
                            if (request.getSession().getAttribute("phone") != null) {
                                String phone = request.getSession().getAttribute("phone").toString();
                                String name = request.getSession().getAttribute("name").toString();
                                //System.out.println(name + "  " + phone);

                        %>
                    <li>
                        <div class="dropdown">
                            <button class="dropbtn">Manage Members</button>
                            <div class="dropdown-content">
                                <a href="AddMembers.jsp">Add_Members</a>
                                <a href="ShowMembers.jsp">Show_Members</a>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="dropdown">
                            <button class="dropbtn">HII <%=name%></button>
                            <div class="dropdown-content">
                                <a href="ChangePassword.jsp">Change_Password</a>
                                <a href="./UserLogoutResponse">Logout</a>
                            </div>
                        </div>
                    </li>


                    <%                    } else {
                    %>
                    <li> <a href = "LoginUser.jsp" > Login </a> </li>
                    <li> <a href = "SignupUser.jsp" > Signup </a> </li>
                        <%
                            }
                        %>
                </ul>
            </nav>

        </header>



        <section class="home" id="home">

            <div class="content">

                <h3 style="color: #FF4F5B">Stay Safe, Stay Home</h3>
                <p style="text-align: justify">Stay-at-home directives are issued to protect you, your family, and the public at large. Do your part by staying home. Now is not the time for a play date for kids, not the time for a dinner for adults, and not the time for a personal visit to the elderly. Spring break plans should be cancelled, birthday parties should be postponed, extended family dinners should be suspended. If the NBA can cancel their basketball games, you can cancel your in-person social calendar. Please, stay home.</p>

            </div>

            <div class="image">
                <img src="images/home-img.png" alt="">
            </div>

        </section>

        <!-- home section ends -->

        <section class="protect" id="protect">

            <h1 class="heading">Take steps to <span>protect</span> yourself</h1>

            <div class="box-container">

                <div class="box">
                    <img src="images/protect-1.png" alt="">
                    <h3>Wear A Face Mask</h3>
                    <p style="text-align: center">Masks, or facial coverings, are mainly to prevent the person wearing the mask from generating droplets from breathing, coughing, sneezing, etc.  It is these droplets that can carry a virus from one person to another.</p>
                </div>

                <div class="box">
                    <img src="images/protect-2.png" alt="">
                    <h3>Wash Your Hands</h3>
                    <p style="text-align: center">You can help yourself and your loved ones stay healthy by washing your hands often, especially during these key times when you are likely to get and spread germ. Example - After blowing your nose or coughing !!</p>
                </div>

                <div class="box">
                    <img src="images/protect-3.png" alt="">
                    <h3>Avoid Close Contact</h3>
                    <p style="text-align: "> Social distancing aims to decrease transmission of COVID-19 in a folks by minimizing contact between infected and healthy individuals . Strictly avoid contact with someone who has symptoms of the infection.!</p>
                </div>

            </div>

        </section>

        <!-- symtoms section starts  -->

        <section class="symtoms" id="symtoms">

            <div class="content">
                <h1 class="heading">What Are The Main <span>Symptoms?</span></h1><br><br>
                <ul>
                    <div class="one">
                        <li>fever</li>
                        <li>Tiredness</li>
                        <li>Dry Cough</li>
                    </div>
                    <div class="two">
                        <li>Sore Throat</li>            
                        <li>Aches and Pains</li>
                        <li>Shortness of Breath</li>
                    </div>
                </ul>
                <a href="https://www.who.int/emergencies/diseases/novel-coronavirus-2019/question-and-answers-hub/q-a-detail/coronavirus-disease-covid-19" class="btn">know more</a>
            </div>

            <div class="image">
                <img src="images/symptoms-img.png" alt="">
            </div>

        </section>

        <!-- symtoms section ends -->

        <!-- prevent section starts  -->

        <section class="prevent" id="prevent">

            <div class="row">

                <div class="image">
                    <img src="images/dont-img.png" alt="">
                </div>

                <div class="content">
                    <h1 class="heading">Things <span>not to do</span> during covid</h1><br>
                    <ul>
                        <li>Do Not Share Eating</li>
                        <li>Do Not Touch Your Face or Nose</li>
                        <li>Do Not Contact Sick People</li>
                    </ul>
                </div>

            </div>

            <div class="row">

                <div class="content">
                    <h1 class="heading">Things <span>to do</span> during covid</h1><br>
                    <ul>
                        <li>Wash Your Hands For 20 sec</li>
                        <li>Wear a Mask if Available</li>
                        <li>Seek Medical Care Regularly</li>
                    </ul>
                </div>

                <div class="image">
                    <img src="images/do-img.png" alt="">
                </div>

            </div>

        </section>

        <!-- prevent section ends -->

        <!-- handwash section starts  -->

        <section class="handwash" id="handwash">

            <h1 class="heading">how to <span>wash you hand</span> properly</h1>

            <div class="box-container">

                <div class="box">
                    <span>1</span>
                    <img src="images/hadnwash-1.png" alt="">
                    <h3>Apply Soap on Hand</h3>
                </div>

                <div class="box">
                    <span>2</span>
                    <img src="images/hadnwash-2.png" alt="">
                    <h3>Palm to Palm</h3>
                </div>

                <div class="box">
                    <span>3</span>
                    <img src="images/hadnwash-3.png" alt="">
                    <h3>Between Fingers</h3>
                </div>

                <div class="box">
                    <span>4</span>
                    <img src="images/hadnwash-4.png" alt="">
                    <h3>Back of The Hands</h3>
                </div>

                <div class="box">
                    <span>5</span>
                    <img src="images/hadnwash-5.png" alt="">
                    <h3>clean with water</h3>
                </div>

                <div class="box">
                    <span>6</span>
                    <img src="images/hadnwash-6.png" alt="">
                    <h3>Use Towel to Dry</h3>
                </div>

            </div>

        </section>

        <!-- handwash section ends -->

        <!-- spread section starts  -->

        <section class="spread" id="spread">

            <h1 class="heading">how Covid-19 <span>spreads</span> over the world</h1>

            <div class="image"></div>

        </section>

        <!-- spread section ends -->

        <!-- footer section starts  -->

        <section class="footer">

            <div class="box-container">


              

                    <div class="box ">
                        <h3>about us</h3>
                        <p> An Initiative to make India Corona free .</p>
                          <div class="share">
                            <a href="#" class="fab fa-youtube"></a>
                            <a href="#" class="fab fa-facebook-f"></a>
                            <a href="#" class="fab fa-twitter"></a>
                            <a href="#" class="fab fa-instagram"></a>
                        </div>
                    </div>





                    <%
                        if (request.getSession().getAttribute("phone") == null) {
                    %>
                    <div class="box  ">
                        <h3>quick links</h3>
                        <a href="LoginStaff.jsp">Staff Login</a>
                        <a href="LoginAdmin.jsp">Admin Login</a>
                        <a href="LoginCenter.jsp">Vaccine Center Login</a>
                    </div>
                    <%
                    } else {
                    %>

                    <%
                        }
                    %>



                    <div class="box " style="ma">
                        <h3>contact info</h3>
                         <p> <i class="fas fa-phone"></i> +91-8196923102,+91-7814007727 </p>
                        <p> <i class="fas fa-envelope"></i> jashanpreetkaur379@gmail.com , mr.vasu.madaan@gmail.com </p>
                        <p> <i class="fas fa-map-marker-alt"></i> Amritsar, India - 143001. </p>
                      
                    </div>

                </div>
                    </div>
                <br>

                <h1 class="credit"> created by <a href="#">Ms. Jashanpreet Kaur And Mr. Vasu Madaan</a> all rights reserved! </h1>

        </section>

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