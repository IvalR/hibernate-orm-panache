package tech.ival;

import tech.ival.models.Task;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("task")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @GET
    public List<Task> getTask(){
        return Task.listAll();
    }

    @GET
    @Path("{id}")
    public Task getTask(@PathParam("id") Long id){
        return Task.findById(id);
    }

    @POST
    @Transactional
    public List<Task> addTask(@Valid Task task){
        task.persist();
        return Task.listAll();
    }

    @POST
    @Transactional
    @Path("{id}")
    public List<Task> updateTask(@PathParam("id") Long id,Task task){
        Task oldTask = Task.findById(id);
        oldTask.title = task.title;
        oldTask.subject = task.subject;
        oldTask.description = task.description;
        oldTask.score = task.score;

        return Task.listAll();
    }

    @POST
    @Transactional
    @Path("{id}/title")
    public List<Task> updateTaskById(@PathParam("id") Long id,String title){
        Task oldTask = Task.findById(id);
        oldTask.title = title;

        return Task.listAll();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Boolean deletByID(@PathParam("id") Long id){
        return Task.deleteById(id);
    }



}
