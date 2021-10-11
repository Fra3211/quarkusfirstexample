package com.example;

import com.example.data.Book;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Random;

@Path("/hello")
@Slf4j
public class ExampleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Timeout
    //@CircuitBreaker
    public List<Book> getBooks(){
        return getFailingBooks();
    }

    //@Retry(maxRetries = 4, delay = 1000L) //WORKS ALSO LIKE THIS
    public List<Book> getFailingBooks(){
        final boolean fail = new Random().nextBoolean();
        if(fail){ //Emulate failure behaviour
            log.info("Couldn't connect to database");
            throw new RuntimeException("Couldn't connect to database");
        }
        return List.of(Book.builder()
                        .id("1")
                        .author("Fra")
                        .name("Book1")
                        .build(),
                Book.builder()
                        .id("2")
                        .author("Ta")
                        .name("Book2")
                        .build(),
                Book.builder()
                        .id("3")
                        .author("Ra")
                        .name("Book3")
                        .build());
    }
}