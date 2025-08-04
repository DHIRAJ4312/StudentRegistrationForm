package model;

public class Student {
    private String name;
    private String email;
    private int age;
    private String gender;
    private String course;

    public Student(String name, String email, int age, String gender, String course) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.course = course;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getCourse() { return course; }
}
