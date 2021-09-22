package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    @Schema(example = "1")
    @Min(message = "Id is mandatory field and not less then 1", value = 1)
    private int id;

    @Schema(example = "Book Name")
    @NotEmpty(message = "Name must be filled")
    private String name;

    @Schema(example = "Author Name")
    @NotEmpty(message = "Author must be specified")
    private String author;

    @Schema(example = "1000")
    @Min(message = "Price can't be less than 0", value = 0)
    private int price;
}
