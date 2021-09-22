package com.example;

import com.example.dto.BookDto;
import com.example.service.BookService;
import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

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

    @Operation(summary = "Get all books", description = "Get all information regarding books")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "200",
                    description = "Ok",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = BookDto.class))}
            ),
            @APIResponse(
                    responseCode = "500",
                    description = "Server error",
                    content = @Content(examples = @ExampleObject())
            )
    })
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }


    @Operation(summary = "Post book", description = "Insert a book with all information")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "201",
                    description = "Created",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = BookDto.class))}
            ),
            @APIResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            examples = @ExampleObject(value = "{\n" +
                                    "    \"date\":\"2021-09-22\",\n" +
                                    "    \"code\":400,\n" +
                                    "    \"message\":\"Bad Request\"\n" +
                                    "}"))
            )
    })
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
