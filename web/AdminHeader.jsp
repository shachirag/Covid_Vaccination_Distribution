
        <header>

            <a href="index.jsp" class="logo">C<span class="fas fa-virus"></span>VID-G<span class="fas fa-virus"></span></a>

            <div id="menu" class="fas fa-bars"></div>

            <nav class="navbar">
                <ul>
                    <li><a  href= "AdminHome.jsp">Admin Home</a></li>
                        <%
                            if (request.getSession().getAttribute("username") != null )
                            {
                                String username = request.getSession().getAttribute("username").toString();
                            

                        %>
                     
                     <li>
                        <div class="dropdown">
                            <button class="dropbtn">Manage Centers</button>
                            <div class="dropdown-content">
                               <a href="AddCenter.jsp">Add Centers</a>
                                <a href="ShowCenter.jsp">Show Centers</a>
                            </div>
                        </div>
                    </li>

                     <li>
                        <div class="dropdown">
                            <button class="dropbtn">Manage Vaccines</button>
                            <div class="dropdown-content">
                               <a href="AddVaccine.jsp">Add Vaccines</a>
                                <a href="ShowVaccine.jsp">Show Vaccine</a>
                            </div>
                        </div>
                    </li>

                    
                    <li>
                        <div class="dropdown">
                            <button class="dropbtn">HII <%=username%></button>
                            <div class="dropdown-content">
                               <a href="#">Change_Password</a>
                                <a href="./AdminLogoutResponse">Logout</a>
                            </div>
                        </div>
                    </li>
                    


                    <%                    } else {
                    %>
                    <li> <a href = "LoginAdmin.jsp" > Login </a> </li>
                   
                        <%
                            }
                        %>
                </ul>
            </nav>

        </header>