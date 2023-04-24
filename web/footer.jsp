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



                    <div class="box ">
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
