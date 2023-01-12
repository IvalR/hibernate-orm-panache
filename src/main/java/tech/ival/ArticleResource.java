package tech.ival;

import io.quarkus.panache.common.Sort;
import tech.ival.models.Article;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("articles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource {

    @GET
    public List<Article> getArticles(){
        return Article.listAll(Sort.ascending("id"));
    }

    @GET
    @Path("{id}")
    public Article getArticleById(@PathParam("id") Long id){
        return Article.findById(id);
    }

    @POST
    @Transactional
    public List<Article> addArticle(Article article){
        article.persist();
        return Article.listAll(Sort.ascending("id"));

    }

    @PUT
    @Transactional
    @Path("{id}")
    public List<Article> updateArticle(@PathParam("id") Long id, Article article){
        Article oldArticle = Article.findById(id);
        oldArticle.title = article.title;
        oldArticle.body = article.body;
        return Article.listAll(Sort.ascending("id"));
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public List<Article> deleteArticle(@PathParam("id") Long id){
        Article.deleteById(id);
        return Article.listAll(Sort.ascending("id"));
    }
}
