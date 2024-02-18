package com.m2.tiila.fitmarket.exception;

import dto.fitmarketapi.Error;
import jakarta.ws.rs.core.Response;

public class BadRequestException {

    public Response toResponse(Response.Status status,String message) {
        var error = new Error();
        error.setCode(String.valueOf(status.getStatusCode()));
        error.setDescription(message);
        return Response.status(status).entity(error).build();
    }

}
