package com.example.service;

import com.example.dto.BookDto;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Slf4j
public class BookServiceImpl implements BookService {

    private final Map<Integer,BookDto> books = new HashMap<>();

    @Override
    public List<BookDto> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public BookDto add(BookDto bookDto) {
        log.info("Book added");
        if(books.containsKey(bookDto.getId())) {
            return books.get(bookDto.getId());
        }
        books.put(bookDto.getId(), bookDto);
        return bookDto;
    }

    @Override
    public void update(BookDto bookDto, int id) {
        if(books.containsKey(id)){
            books.put(id, bookDto);
        }else {
            throw new RuntimeException("Cannot find book with id " + id);
        }

    }

    @Override
    public void delete(int id) {
        if(books.containsKey(id)){
            books.remove(id);
        } else {
            throw new RuntimeException("Cannot find book with id " + id);
        }
    }


}
