package com.m2.tiila.fitmarket.controller;


import com.m2.tiila.fitmarket.business.ClasseBusiness;
import com.m2.tiila.fitmarket.business.UserBusiness;
import com.m2.tiila.fitmarket.exception.BadRequestException;
import dto.fitmarketapi.Member;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import static com.m2.tiila.fitmarket.mapper.UserMapper.toEntity;


@Controller
@Path("/sign")
public class UserController {

    @Inject
    private UserBusiness userBusiness;

    @Path("/in")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signIn(Member member){
        try{
            Member m = userBusiness.signIn(member.getEmail(), member.getPassword());
            return Response.ok(m).build();
        }catch (Exception e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Identifiants incorrect");
        }
    }

    @Path("/up")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response signUp(Member member){
        try{
            userBusiness.signUp(toEntity(member));
            return Response.ok("Utilisateur créé.").build();
        }catch (Exception e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Création de l'utilisateur impossible.");
        }
    }

    @Path("/update/{id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMember(@PathParam("id") Integer id, Member member){
        try{
            userBusiness.updateMember(id,toEntity(member));
            return Response.ok("Utilisateur modifier.").build();
        }catch (Exception e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Modification de l'utilisateur impossible.");
        }
    }
}
