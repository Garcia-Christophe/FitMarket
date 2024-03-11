package com.m2.tiila.fitmarket.controller;


import com.m2.tiila.fitmarket.business.ClasseBusiness;
import com.m2.tiila.fitmarket.exception.BadRequestException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;


@Controller
@Path("/classes")
public class ClasseController {

    @Inject
    private ClasseBusiness classeBusiness;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getClasse(@PathParam("id") Integer id) {
        try {
            return Response.ok(this.classeBusiness.getClasse(id)).build();
        }catch(Exception e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Aucun cours trouvé avec l'id : "+id);
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/{id}")
    public Response getClassesByUserId(@PathParam("id") Integer id) {
        try {
            return Response.ok(this.classeBusiness.getClassesByUserId(id)).build();
        }catch(Exception e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Aucun cours trouvé pour l'utilisateur : "+id);
        }
    }
}
