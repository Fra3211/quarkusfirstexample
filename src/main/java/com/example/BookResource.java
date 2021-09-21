package com.example;

import com.example.dto.BookDto;
import com.example.service.BookService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

@Path("/book")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(@Valid BookDto bookDto) {
        BookDto book = bookService.add(bookDto);
        URI myDto = UriBuilder.fromUri("{id}").build(book.getId());
        return Response.status(Response.Status.CREATED).entity(book).location(myDto).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateBook(BookDto bookDto, @PathParam("id") int id) {
        bookService.update(bookDto, id);
        return Response.noContent().build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id) {
        bookService.delete(id);
        return Response.noContent().build();
    }
}
