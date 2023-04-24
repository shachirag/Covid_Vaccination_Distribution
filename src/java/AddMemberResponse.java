
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import vmm.DBLOADER;
import vmm.FileUploader;
import java.sql.*;

@MultipartConfig
public class AddMemberResponse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        try {

            // Extract text1
            if (request.getSession().getAttribute("phone") != null) {
                String phone_no = request.getSession().getAttribute("phone").toString();
                String name = request.getParameter("name");
                String prooftype = request.getParameter("prooftype");
                String proofnumber = request.getParameter("proofnumber");
                int age = Integer.parseInt(request.getParameter("age"));

                // Extract file 
                Part photo = request.getPart("photo");

                // Now Insert in Database
                ResultSet rs = DBLOADER.executeSQl("select * from members where proof_number=\'" + proofnumber + "\'");

                if (rs.next()) {
                    out.println("<h3 style=\"color: red\">Proof Number already register with someone else !!</h3>");
                } else {
                    //  Save files on server
                    String relpath = "myuploads";
                    String abspath = getServletContext().getRealPath("/" + relpath);
                    //out.println(abspath+"<br>");

                    String new_file_name = System.currentTimeMillis() + "-" + photo.getSubmittedFileName();

                    String ans1 = FileUploader.savefileonserver(photo, abspath, new_file_name);
                    //out.println("File Saved on Server "+ans1+"<br>");

                    rs.moveToInsertRow();
                    rs.updateString("name", name);
                    rs.updateString("proof_type", prooftype);
                    rs.updateString("proof_number", proofnumber);
                    rs.updateString("phone_no", phone_no);
                    rs.updateInt("age", age);
                    rs.updateString("photo", relpath + "/" + new_file_name);
                    rs.updateString("status", "Not-Vacinated");
                    rs.insertRow();

                    out.println("Success");
                }
            } else {
                out.println("Session Expired");
            }
        } catch (Exception ex) {
            out.println(ex.toString());
        }
    }
}
