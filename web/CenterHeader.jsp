
        <header>

            <a href="index.jsp" class="logo">C<span class="fas fa-virus"></span>VID-G<span class="fas fa-virus"></span></a>

            <div id="menu" class="fas fa-bars"></div>

            <nav class="navbar">
                <ul>
                    <li><a  href= "CenterHome.jsp">Center_Home</a></li>
                        <%
                            if (request.getSession().getAttribute("vcid") != null && request.getSession().getAttribute("vcname") != null  )
                            {
                                String vcid = request.getSession().getAttribute("vcid").toString();
                                String vcname = request.getSession().getAttribute("vcname").toString();
                            

                        %>
                     <li>
                        <div class="dropdown">
                            <button class="dropbtn">Manage Availability</button>
                            <div class="dropdown-content">
                                <a href="AddVaccineAvailability.jsp">Add Dates</a>
                                <a href="ShowVaccineAvailability.jsp">Show Dates</a>
                            </div>
                        </div>
                    </li>
                     <li>
                        <div class="dropdown">
                            <button class="dropbtn">Manage Staff</button>
                            <div class="dropdown-content">
                               <a href="AddStaff.jsp">Add Staff</a>
                                <a href="ShowStaff.jsp">Show Staff</a>
                            </div>
                        </div>
                    </li>
                     <li>
                        <div class="dropdown">
                            <button class="dropbtn">HII <%=vcname%></button>
                            <div class="dropdown-content">
                               <a href="#">Change_Password</a>
                                <a href="./CenterLogoutResponse">Logout</a>
                            </div>
                        </div>
                    </li>
                    


                    <%                    } else {
                    %>
                    <li> <a href = "LoginCenter.jsp" > Login </a> </li>
                   
                        <%
                            }
                        %>
                </ul>
            </nav>

        </header>