package hello.service;

import hello.model.Course;
import hello.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentService {

    private static List<Student> students = new ArrayList<Student>();

    static {

        // Define courses
        Course course1 = new Course("Course1", "Spring", "10 Steps", Arrays
                .asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course3 = new Course("Course3", "Spring Boot", "6K Students",
                Arrays.asList("Learn Maven", "Learn Spring",
                        "Learn Spring MVC", "First Example", "Second Example"));
        Course course4 = new Course("Course4", "Maven",
                "Most popular maven course on internet!", Arrays.asList(
                "Pom.xml", "Build Life Cycle", "Parent POM",
                "Importing into Eclipse"));

        Student ranga = new Student("Student1", "Ranga Karanam",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));

        Student satish = new Student("Student2", "Satish T",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));


        students.add(ranga);
        students.add(satish);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudent(String studentId) {
        for(Student student : students) {
            if(student.getId().equals(studentId)) {
                return student;
            }
        }
    return null;
    }

    public List<Course> getCourses(String studentId) {
        Student student = getStudent(studentId);

        if(studentId.equalsIgnoreCase("Student1")) {
            throw new RuntimeException("Something went wrong. Exception check");
        }

        if(student == null) {
            return null;
        }
        return student.getCourses();
    }

    public Course getCourse(String studentId, String courseId) {

        Student student = getStudent(studentId);
        if(student == null) {
            return null;
        }

        for (Course course : student.getCourses()) {
            if(course.getId().equalsIgnoreCase(courseId)) {
                return course;
            }
        }
        return null;
    }

}
