package com.crypto;

import com.crypto.data.Currency;
import com.crypto.data.MultiPartBody;
import com.crypto.service.CurrencyService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.inject.Inject;
import javax.ws.rs.*;
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

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String echoFile(@MultipartForm MultiPartBody multiPartBody){
        //Do something with file
        return "uploaded";
    }
}