package tech.ival;

import io.quarkus.panache.common.Sort;
import tech.ival.models.Address;
import tech.ival.models.User;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("address")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressResource {

    @GET
    public List<Address> getAddress(){
        return Address.listAll(Sort.ascending("id"));
    }

    @POST
    @Path("{id}")
    @Transactional
    public List<Address> addAddress(@PathParam("id") Long id, Address address){
        User user = User.findById(id);
        address.user = user;
        address.persist();
        return Address.listAll(Sort.ascending("id"));
    }


}
