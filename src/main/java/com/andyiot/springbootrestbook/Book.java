package com.andyiot.springbootrestbook;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/* data class to define the book data structure */
public class Book {	
	private int mBookId;  
	private String mTitle;  
	private String mAuthorName;  
	private int mPages;  
	private LocalDateTime mPublishedDate; 
	private LocalDateTime mAddedDate;

	// datetime format: "yyyy-MM-dd HH:mm"
	private static final DateTimeFormatter sDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	//default constructor  
	public Book() {  	      
	} 
	
	public Book(int id, String title, String authorname, int pageno, String datepublised, String dateadded) {
		mBookId = id;
		mTitle = title;
		mAuthorName = authorname;
		mPages = pageno;
		setDatePublished(datepublised);
		setDateAdded(dateadded);
	}

	public int getBookId() {
		return mBookId;
	}

	public void setBookId(int id) {
		mBookId = id;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public String getAuthorName() {
		return mAuthorName;
	}

	public void setAuthorName(String authorname) {
		mAuthorName = authorname;
	}

	public int getBookPages() {
		return mPages;
	}

	public void setBookPages(int pages) {
		mPages = pages;
	}

	public String getDatePublished() {
		return mPublishedDate.format(sDateFormatter);
	}

	public void setDatePublished(String datePublished) {
		mPublishedDate = LocalDateTime.parse(datePublished, sDateFormatter);
	}

	public String getDateAdded() {
		return mAddedDate.format(sDateFormatter);		
	}

	public void setDateAdded(String dateAdded) {
		mAddedDate = LocalDateTime.parse(dateAdded, sDateFormatter);;
	}
	
}
