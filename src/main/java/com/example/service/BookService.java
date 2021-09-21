package com.example.service;

import com.example.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    BookDto add(BookDto bookDto);

    void update(BookDto bookDto, int id);

    void delete(int id);
}
