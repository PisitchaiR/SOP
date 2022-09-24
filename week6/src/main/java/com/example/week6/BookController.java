package com.example.week6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<?> getBooks() {
        List<Book> books = bookService.retrieveBooks();
        return ResponseEntity.ok(books);
    }
    @RequestMapping(value = "/book/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getBook(@PathVariable("name") String name) {
        Book book = bookService.retrieveBookByName(name);
        return ResponseEntity.ok(book);
    }
    @RequestMapping(value = "/book2/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> getBook2(@PathVariable("name") String name) {
        Book n = bookService.retrieveBookByName2(name);
        return ResponseEntity.ok(n);
    }

    @RequestMapping(value = "/newBook/{name}/{group}/{price}", method = RequestMethod.GET)
    public ResponseEntity<?> createBook(@PathVariable("name") String name,
                                        @PathVariable("group") String group,
                                        @PathVariable("price") int price) {
        Book n = bookService.createBook(new Book(null,name,group,price));
        return ResponseEntity.ok(n);
    }

    @RequestMapping(value = "/deleteBook/{name}", method = RequestMethod.GET)
    public boolean deleteBook(@PathVariable("name") String name) {
        Book book = bookService.retrieveBookByName(name);
        boolean status = bookService.deleteBook(book);
        return status;
    }

    @RequestMapping(value = "/countBook", method = RequestMethod.GET)
    public int countBook() {
        return bookService.countBook();
    }
    @RequestMapping(value = "/countBook/{x}", method = RequestMethod.GET)
    public int countBookMoreThanX(@PathVariable("x") int x) {
        return bookService.countBookPriceMoreThanX(x);
    }

    @RequestMapping(value = "/updateBook/where/{nameOld}/{nameNew}/{group}/{price}",
            method = RequestMethod.GET)
    public boolean updateBook(@PathVariable("nameOld") String nameOld,
                              @PathVariable("nameNew") String nameNew,
                              @PathVariable("group") String group,
                              @PathVariable("price") int price) {
        Book book = bookService.retrieveBookByName(nameOld);
        if(book != null) {
            bookService.updateBook(new Book(book.get_id(), nameNew, group, price));
            return true;
        }else {
            return false;
        }
    }
}
