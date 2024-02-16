package com.m2.tiila.fitmarket.controller;


import com.m2.tiila.fitmarket.business.ProductBusiness;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;
import  com.m2.tiila.fitmarket.exception.BadRequestException;


@Controller
@Path("/products")
public class ProductController {

    @Inject
    private ProductBusiness productBusiness;


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        return Response.ok(this.productBusiness.getProducts()).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Integer id) {
        try {
            return Response.ok(this.productBusiness.getProduct(id)).build();
        }catch(ArrayIndexOutOfBoundsException e){
            BadRequestException badRequestException =  new BadRequestException();
            return badRequestException.toResponse(Response.Status.NOT_FOUND, "Aucun produit avec l'id : "+id);
        }
    }
}
