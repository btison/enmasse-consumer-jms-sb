package com.redhat.btison.enmasse.jms.consumer.sb.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redhat.btison.enmasse.jms.consumer.sb.service.MessageCounterService;

@Component
@Path("/")
public class MessageLoggingResource {

    @Autowired
    MessageCounterService messageCounterService;

    @POST
    @Path("/logging/reset")
    public Response reset() {
        messageCounterService.resetCounter();
        return Response.ok().build();
    }

}
