package com.andyiot.springbootrestbook;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
public class BookController   
{
    private final IBookService bookService = new BookService();      

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        // TODO should return a new book generated from underlying service.
        bookService.add(book);
        return book;
    }
    
    @GetMapping("{id}")
    public Book findOneBook(@PathVariable int id) {
        //finds a single book
        return bookService.find(id);
    }
    
    @GetMapping
    public List<Book> findAllBook() {
        //finds all the books  
        return bookService.findAll();
    }
    
    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable int id) {
    	//remove a book by id
    	bookService.remove(id);    	
    }
    
    @PutMapping("{id}")   
    public Book editBook(@RequestBody Book book) {
        // TODO should update a book in library
        bookService.modifyBook(book.getBookId(), book);
        return book;
    }
    
}
