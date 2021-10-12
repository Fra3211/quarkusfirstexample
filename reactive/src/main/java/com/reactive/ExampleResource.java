package com.reactive;

import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class ExampleResource {

    @Route(methods = Route.HttpMethod.GET)
    public void hello(RoutingContext rc) {
        rc.response().end("Hello");
    }
}