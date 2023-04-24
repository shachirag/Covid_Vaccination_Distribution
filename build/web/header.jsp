
<header>

    <a href="index.jsp" class="logo">C<span class="fas fa-virus"></span>VID-G<span class="fas fa-virus"></span></a>

    <div id="menu" class="fas fa-bars"></div>

    <nav class="navbar">
        <ul>
            <li><a  href="index.jsp">home</a></li>
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