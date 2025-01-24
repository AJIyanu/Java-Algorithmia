package ceagms;

import java.util.HashMap;
import java.util.UUID;

public class Student {
    private String id;
    private String name;
    private HashMap<Course, Integer> courses = new HashMap<>(); 

    public Student(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean enrollCourse(Course newCourse) {
        for (Course course : courses.keySet()) {
            if (course.getCode().equals(newCourse.getCode())) {
                return false;
            }
        }
        courses.put(newCourse, 0);
        Course.newEnrolledStudent();
        return true;
    }

    public boolean assignGrade(Course course, int grade) {
        if (courses.containsKey(course)) {
            courses.put(course, grade);
            return true;
        }
        return false;
    }

    /**
     * Calculate the overall grade for the student.
     * The overall grade is the average of all the grades for the courses the student is enrolled in.
     * 
     * @return the overall grade for the student
     */
    public int overallGrade() {
        int totalGrade = 0;
        for (int grade : courses.values()) {
            totalGrade += grade;
        }
        return totalGrade / courses.size();
    }

    public void studentGradeInfo() {
        int totalGrade = 0;
        int totalCourses = courses.size();
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("**********************************************");
        for (Course course : courses.keySet()) {
            System.out.println("Course: " + course.getName() + " --> Grade: " + courses.get(course));
            totalGrade += courses.get(course);
        }
        System.out.println("**********************************************");
        System.out.println("Total Grade: " + totalGrade );
        System.out.println("Total Enrolled Courses: " + totalCourses);
        System.out.println("Overall Grade: " + totalGrade / totalCourses);
    }
    
}