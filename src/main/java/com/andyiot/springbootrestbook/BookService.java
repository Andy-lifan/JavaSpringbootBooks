package com.andyiot.springbootrestbook;

import java.util.ArrayList;  
import java.util.List;  
import java.util.HashMap;
import org.springframework.stereotype.Service;  

/* concrete class that implements the IBookServer interface to handle
*  all required RESTful APIs
*/
@Service  
public class BookService implements IBookService {  
	
	public BookService() {}

    /* local map cache to store books*/
    private HashMap<Integer, Book> mBookStore = new HashMap<>();

    @Override  
    public void add(Book aBook) {
        // assume that book id is unique.
        if (mBookStore.containsKey(aBook.getBookId())) {
            return;
        }
        mBookStore.put(aBook.getBookId(), aBook);
    }

    @Override  
    public Book find(int bookId) {
        return mBookStore.get(bookId);
    }

    @Override    
    public List<Book> findAll() {
        List<Book> allBooks = new ArrayList<>(mBookStore.values());
        return allBooks;
    }

    @Override  
    public void remove(int bookId) {
        if ( mBookStore.containsKey(bookId)) {
            mBookStore.remove(bookId);
        }        
    }

    @Override  
    public void modifyBook(int bookId, Book newBookInfo) {
        // TODO: need to confirm only partially modified or the whole book, here just use the modified new 
        // book to replace the existing one.
        if ( mBookStore.containsKey(bookId)) {
            mBookStore.replace(bookId, newBookInfo);
        }
    }  
 
} 
