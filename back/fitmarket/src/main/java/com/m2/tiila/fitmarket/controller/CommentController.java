package com.m2.tiila.fitmarket.controller;


import com.m2.tiila.fitmarket.business.CommentBusiness;
import com.m2.tiila.fitmarket.exception.BadRequestException;
import dto.fitmarketapi.Comment;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import static com.m2.tiila.fitmarket.mapper.CommentMapper.toEntity;


@Controller
@Path("/comments")
public class CommentController {

    @Inject
    private CommentBusiness commentBusiness;

    @Path("/{idProduct}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCommentsByProduct(@PathParam("idProduct") Integer idProduct){
        try {
            return Response.ok(this.commentBusiness.getCommentsByProduct(idProduct)).build();
        }catch(Exception e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Aucun commentaires pour le produit avec l'id : "+idProduct);
        }
    }

    @Path("/best")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBestComments(){
        try {
            return Response.ok(this.commentBusiness.getBestComments()).build();
        }catch(Exception e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Aucun meilleurs commentaires");
        }
    }

    @Path("")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createComment(Comment comment){
       try{
            commentBusiness.createComment(toEntity(comment));
            return Response.ok("Commentaire ajouté.").build();
       }catch (Exception e){
           BadRequestException badRequestException =  new BadRequestException();
           return badRequestException.toResponse(Response.Status.BAD_REQUEST, "Création du commentaire impossible.");
        }
    }
}
