package org.jboss.aesh.nanook;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Yoshimasa Tanabe
 */
@Path("/")
public class NanookRest {

    @Path("/history")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response history() {
        String mockEntity = "[{\"1\":\"ls\"},{\"2\":\"cat foo.txt\"}]";
        return Response.ok(mockEntity).build();
    }

    @Path("/log")
    @GET
    public String log() {
        return "NOT_IMPLEMENTED";
    }

}
