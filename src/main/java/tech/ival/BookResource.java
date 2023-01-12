package tech.ival;

import io.quarkus.panache.common.Sort;
import tech.ival.models.Book;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> getBook(){
        return Book.listAll(Sort.ascending("id"));
    }

    @POST
    @Transactional
    public List<Book> addBook(Book book){
        book.persist();
        return Book.listAll(Sort.ascending("id"));
    }

    @GET
    public Response list(){

    }

}
