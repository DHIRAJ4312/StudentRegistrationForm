package service;

import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationService {
    public boolean registerStudent(Student student) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO students(name, email, age, gender, course) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setInt(3, student.getAge());
            stmt.setString(4, student.getGender());
            stmt.setString(5, student.getCourse());

            int rowsInserted = stmt.executeUpdate();
            
            // Write to text file for auto-create file marks
            FileWriter fw = new FileWriter("data.txt", true);
            fw.write(student.getName() + "," + student.getEmail() + "," + student.getCourse() + "\n");
            fw.close();

            return rowsInserted > 0;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }
}   


