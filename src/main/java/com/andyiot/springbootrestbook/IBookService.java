package com.andyiot.springbootrestbook;

import java.util.List;  
public interface IBookService   
{  
/* To add a book */
public void add(Book abook);

/* To find a book by book Id */
public Book find(int bookId);

/* To find a book by book Id */  
public List<Book> findAll();  

/* To remove a book by book Id */
public void remove(int bookId);

/* To edit a book by book Id with modified Book info */
public void modifyBook(int bookId, Book newBookInfo);


} 
