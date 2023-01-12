package tech.ival;

import io.quarkus.panache.common.Sort;
import tech.ival.models.Course;
import tech.ival.models.Student;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {

    @GET
    public List<Course> getCourse(){
        return Course.listAll(Sort.ascending("id"));
    }


    @POST
    @Transactional
    public List<Course> addCourse(Course course){
        course.persist();
        return Course.listAll(Sort.ascending("id"));
    }

    @POST
    @Transactional
    @Path("{idCourse}/students/{idStudent}")
    public List<Course> enrollStudent(@PathParam("idCourse") Long idCourse, @PathParam("idStudent") Long idStudent){
        Course course = Course.findById(idCourse);
        Student student = Student.findById(idStudent);
        course.students.add(student);
        course.persist();

        return Course.listAll(Sort.ascending("id"));
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public List<Course> deleteCourse(@PathParam("id") Long id){
        Course.deleteById(id);
        return Course.listAll(Sort.ascending("id"));
    }

}
