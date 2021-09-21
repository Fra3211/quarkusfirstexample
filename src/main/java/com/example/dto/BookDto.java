package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    @Min(message = "Id is mandatory field and not less then 1", value = 1)
    private int id;

    @NotEmpty(message = "Name must be filled")
    private String name;

    @NotEmpty(message = "Author must be specified")
    private String author;

    @Min(message = "Price can't be less than 0", value = 0)
    private int price;
}
