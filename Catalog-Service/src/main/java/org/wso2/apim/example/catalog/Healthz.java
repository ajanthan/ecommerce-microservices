package org.wso2.apim.example.catalog;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/healthz")
public class Healthz {
    @GET
    public Response ping(){
        return Response.ok().build();
    }
}
