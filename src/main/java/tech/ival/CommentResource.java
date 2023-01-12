package tech.ival;

import io.quarkus.panache.common.Sort;
import tech.ival.models.Article;
import tech.ival.models.Comment;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@Path("articles/{idArticle}/comment")
public class CommentResource {

    @GET
    public List<Comment> getCommnentByArticleId(@PathParam("idArticle") Long id){
        return Comment.find("article_id = ?1", id).list();
    }

    @POST
    @Transactional
    public List<Comment> addComment(@PathParam("idArticle") Long id,Comment comment ){

        Article article = Article.findById(id);
        article.comments.add(comment);
        comment.persist();
        return Comment.find("article_id = ?1", id).list();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public List<Comment> deleteComment(@PathParam("id")Long id){
        Comment.deleteById(id);
        return Article.listAll(Sort.ascending("id"));
    }

}
