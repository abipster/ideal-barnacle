package com.mkyong.rest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

//http://localhost:8080/RESTfulExample/rest/message/hello%20world
@Path("/message")
public class MessageRestService {

	@GET
	@Path("/test/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}
        
        @GET
    @Path("/fload")
    public void fload() throws InterruptedException {

        System.out.println("Killing the cat!!");
        Thread.sleep(10000);
        int i =0;
        while(true){
            String name = "Stupid thread - " + i;
            Thread t = new Thread(new Runnable() {
                
                public void run() {
                    try {
                        System.out.println("" + Thread.currentThread().getName());
                        Thread.sleep(100000000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MessageRestService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            t.setName( name );
            t.start();
            i++;
            Thread.sleep(10);
        }
    }

}