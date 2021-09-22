package com.crypto.service;

import com.crypto.data.Currency;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@RegisterRestClient(configKey = "crypto-api")
@Path("ticker/")
public interface CurrencyService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Collection<Currency> getCurrency(@QueryParam("id") String id);
}
