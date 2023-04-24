
        <header>

            <a href="index.jsp" class="logo">C<span class="fas fa-virus"></span>VID-G<span class="fas fa-virus"></span></a>

            <div id="menu" class="fas fa-bars"></div>

            <nav class="navbar">
                <ul>
                    <li><a  href="StaffHome.jsp">Staff Home</a></li>
                        <%
                            if (request.getSession().getAttribute("staff_id") != null && request.getSession().getAttribute("vac_id") != null && request.getSession().getAttribute("staff_name") != null )
                            {
                                int vcid = Integer.parseInt(request.getSession().getAttribute("vac_id").toString());
                                int staff_id = Integer.parseInt(request.getSession().getAttribute("staff_id").toString());
                                String name = request.getSession().getAttribute("staff_name").toString();
                            

                        %>
                     
                    <li>
                        <div class="dropdown">
                            <button class="dropbtn">HII <%=name%></button>
                            <div class="dropdown-content">
                               <a href="StaffChangePassword.jsp">Change_Password</a>
                                <a href="./StaffLogoutResponse">Logout</a>
                            </div>
                        </div>
                    </li>


                    <%                    } else {
                    %>
                    <li> <a href = "LoginStaff.jsp" > Login </a> </li>
                   
                        <%
                            }
                        %>
                </ul>
            </nav>

        </header>