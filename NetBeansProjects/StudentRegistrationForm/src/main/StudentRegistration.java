  package main;

import model.Student;
import service.RegistrationService;

import java.util.Scanner;

public class StudentRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("---- Student Registration ----");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Gender (Male/Female): ");
        String gender = sc.nextLine();

        System.out.print("Course: ");
        String course = sc.nextLine();

        // Input validation
        if (name.isEmpty() || email.isEmpty() || course.isEmpty()) {
            System.out.println("Error: Name, Email, and Course cannot be empty.");
            return;
        }

        Student student = new Student(name, email, age, gender, course);
        RegistrationService service = new RegistrationService();

        boolean success = service.registerStudent(student);
        if (success) {
            System.out.println("✅ Registration successful!");
        } else {
            System.out.println("❌ Registration failed.");
        }
    }
}