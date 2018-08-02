package hello.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import hello.model.Course;
import hello.model.Greeting;
import hello.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    StudentService studentService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @GetMapping("students/{studentId}/course")
    public List<Course> getCourseForStudent(@PathVariable String studentId) {
        return studentService.getCourses(studentId);
    }
}