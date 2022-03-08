package com.samread.samread.controller.services;

import com.samread.samread.enitites.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses();
    public Course getCourse(long courseId);
    public Course addCourse(Course data);
    public Course modifyCourse(long courseId,Course data);
    public boolean deleteCorse(long courseId);
}
