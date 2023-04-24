 <%
         if (request.getSession().getAttribute("phone") == null) {
             response.sendRedirect("LoginUser.jsp");
         }
        %>