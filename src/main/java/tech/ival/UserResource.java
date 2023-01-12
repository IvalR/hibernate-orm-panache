package tech.ival;

import io.quarkus.panache.common.Sort;
import tech.ival.models.Address;
import tech.ival.models.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public List<User> getUser(){
        return User.listAll(Sort.ascending("id"));
    }

    @GET
    @Path("{id}")
    public List<User> getUserByID(@PathParam("id") Long id){
        return User.findById(id);
    }

    @POST
    @Transactional
    public List<User> addUser(User user){
        user.persist();
        return User.listAll(Sort.ascending("id"));
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public List<User> deleteUser(@PathParam("id") Long id){
        User.deleteById(id);
        return User.listAll(Sort.ascending("id"));
    }
}
