package com.crypto;

import com.crypto.data.Currency;
import com.crypto.service.CurrencyService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/crypto")
public class CryptoCurrencyResources {

    @Inject
    @RestClient
    CurrencyService currencyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Currency> getCrypto(@QueryParam("id") String id){
        return currencyService.getCurrency(id);
    }
}