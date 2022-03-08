package com.samread.samread.controller;
import com.samread.samread.enitites.Course;
import com.samread.samread.enitites.CourseDel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MyController {

    @GetMapping("/")
    public String home(){
        return "this is working";
    }

//    get all courses
    @Autowired
    private com.samread.samread.controller.services.CourseService CourseService;
    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.OK)
    protected List<Course> courses(){
        return this.CourseService.getCourses();
    }

//    get a single course by id
    @GetMapping("/course/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.CourseService.getCourse(Long.parseLong(courseId));
    }

//    add a course
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/course/add",consumes = "application/json")
    public Course addCourse(@RequestBody Course course) {
        return this.CourseService.addCourse(course);
    }

//    edit a course
    @PutMapping("/course/{courseId}")
    public Course modifyCourse(@PathVariable String courseId,@RequestBody Course course){
        return this.CourseService.modifyCourse(Long.parseLong(courseId),course);
    }

//    delete a course
    @DeleteMapping("/course/{courseId}")
    public CourseDel deleteCourse(@PathVariable String courseId){
        boolean confirmation =  this.CourseService.deleteCorse(Long.parseLong(courseId));

        if(confirmation){
            return new CourseDel("Deleted Successfully",new ResponseEntity<>(HttpStatus.OK));
        }
        return new CourseDel("Product not deleted",new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
