package tech.ival.models;

import io.quarkus.panache.common.Sort;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @GET
    public List<Student> getStudent(){
        return Student.listAll(Sort.ascending("id"));
    }

    @POST
    @Transactional
    public List<Student> addStudent(Student student){
        student.persist();
        return Student.listAll(Sort.ascending("id"));
    }
}
