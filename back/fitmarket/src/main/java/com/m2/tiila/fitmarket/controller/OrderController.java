package com.m2.tiila.fitmarket.controller;

import com.m2.tiila.fitmarket.business.OrderBusiness;
import com.m2.tiila.fitmarket.exception.BadRequestException;
import dto.fitmarketapi.Order;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import static com.m2.tiila.fitmarket.mapper.OrderMapper.toEntity;


@Controller
@Path("/orders")
public class OrderController {

    @Inject
    private OrderBusiness orderBusiness;

    @Path("/{idUser}/inprogress")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getOrderInProgressByUserId(@PathParam("idUser") Integer idUser){
       try {
            return Response.ok(this.orderBusiness.getOrderInProgressByUserId(idUser)).build();
        }catch(Exception e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Aucune commande en cours pour le user avec l'id : "+idUser);
        }
    }

    @Path("/{idUser}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getOrdersByUserId(@PathParam("idUser") Integer idUser){
        try {
            return Response.ok(this.orderBusiness.getOrdersByUserId(idUser)).build();
        }catch(Exception e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Aucunes commandes pour le user avec l'id : "+idUser);
        }
    }

    @Path("/{idUser}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createComment(@PathParam("idUser") Integer idUser,Order order){
       //try{
        this.orderBusiness.updateOrder(idUser, toEntity(order));
        return Response.ok("Commentaire ajouté.").build();
      /* }catch (Exception e){
        BadRequestException badRequestException =  new BadRequestException();
        return badRequestException.toResponse(Response.Status.BAD_REQUEST, "Modification du panier impossible.");
       }*/
    }
}
