package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Student student1 = new Student("John Doe", dateFormat.parse("01/01/2000"));
        Student student2 = new Student("Jane Doe", dateFormat.parse("15/01/2000"));

        Course course1 = new Course("Mathematics", "MATH101");
        Course course2 = new Course("Physics", "PHYS101");

        student1.registerCourse(course1);
        student1.registerCourse(course2);
        student2.registerCourse(course1);
        student2.registerCourse(course2);

        student1.setGrade(course1, "A");
        student1.setGrade(course2, "B");
        student2.setGrade(course1, "B");
        student2.setGrade(course2, "A");

        School school = new School();
        school.addStudent(student1);
        school.addStudent(student2);
        school.addCourse(course1);
        school.addCourse(course2);

        school.generateTranscript(student1);
        school.generateTranscript(student2);
    }
}

class Student {
    private String name;
    private Date dateOfBirth;
    private Map<Course, String> grades;

    public Student(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.grades = new HashMap<>();
    }

    public void registerCourse(Course course) {
        // course registration logic here
    }

    public void setGrade(Course course, String grade) {
        this.grades.put(course, grade);
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Map<Course, String> getGrades() {
        return grades;
    }
}

class Course {
    private String name;
    private String code;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}

class School {
    private Map<String, Student> students;
    private Map<String, Course> courses;

    public School() {
        this.students = new HashMap<>();
        this.courses = new HashMap<>();
    }

    public void addStudent(Student student) {
        this.students.put(student.getName(), student);
    }

    public void addCourse(Course course) {
        this.courses.put(course.getCode(), course);
    }

    public void generateTranscript(Student student) {
        System.out.println("Transcript for " + student.getName());
        System.out.println("Date of Birth: " + student.getDateOfBirth());

        for (Map.Entry<Course, String> entry : student.getGrades().entrySet()) {
            System.out.println(entry.getKey().getName() + " (" + entry.getKey().getCode() + "): " + entry.getValue());
        }
    }
}