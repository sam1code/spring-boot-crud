package com.samread.samread.controller.services;
import com.samread.samread.enitites.Course;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceimpl implements CourseService {

    List<Course> list;
    public CourseServiceimpl(){
        list = new ArrayList<>();
        list.add(new Course(133,"node course","this course  contains everything of node js."));
        list.add(new Course(1835,"Springboot course","this course  contains everything of springboot."));
    }
    Course crs = new Course(0,"not found","there is no course like this.");
    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        for (Course crs:list) {
            if(crs.getId()==courseId){
                return crs;
            }
        }

        return this.crs;
    }

    @Override
    public Course addCourse(Course data) {
        list.add(data);
        return data;
    }

    @Override
    public Course modifyCourse(long Id, Course data) {
        for (Course crs:list) {
            if(crs.getId()==Id){
                crs.setId(data.getId());
                crs.setTitle(data.getTitle());
                crs.setDescription(data.getDescription());
                return crs;
            }
        }
        return this.crs;
    }

    @Override
    public boolean deleteCorse(long courseId) {
        for (Course crs:list) {
            if(crs.getId() == courseId){
                list.remove(crs);
                return true;
            }
        }
        return false;
    }
}
