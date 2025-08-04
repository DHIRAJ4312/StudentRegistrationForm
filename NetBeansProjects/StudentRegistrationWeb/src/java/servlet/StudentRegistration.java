package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StudentRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String course = req.getParameter("course");

        try {
            // Load the JDBC driver (optional for newer versions of JDBC)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studentdb", "root", "");

            // Prepare SQL statement
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO student(name, email, age, course) VALUES (?, ?, ?, ?)");

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, age);
            ps.setString(4, course);

            int i = ps.executeUpdate();

            if (i > 0) {
                out.print("<h2>Registration successful!</h2>");
            } else {
                out.print("<h2>Registration failed.</h2>");
            }

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.print("<h2>Error: " + e.getMessage() + "</h2>");
        }
    }
}