package com.example.week6;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;
    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> retrieveBooks() {
        return repository.findAll();
    }

    public Book retrieveBookByName (String name) {
        return repository.findByName(name);
    }

    public Book retrieveBookByName2(String name){
        return repository.findByName2(name);
    }

    public Book createBook(Book book){
        return repository.save(book);
    }

    public boolean deleteBook(Book book){
        try {repository.delete(book); return true;}
        catch (Exception e) {return false;}
    }

    public int countBook() {
        return (int)repository.count();
    }

    public int countBookPriceMoreThanX(int x) {
        return repository.countMoreThanX(x);
    }

    public Book updateBook(Book book){
        return repository.save(book);
    }
}
