package org.example.Exceptionhandling;

import java.sql.SQLException;
import java.util.List;

public class BookService {


    public BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



   public int getTodatlpriceofBook()
   {
       List<Book> books= null;
       try {
           books = bookRepository.findAllBooks();
       } catch (SQLException e) {
          //log exception
           throw new DatabaseReadException("Unable to Read the database due to "+e.getMessage());
       }
       int totalprice = 0;
       for(Book bookx :books)
       {
           totalprice =totalprice +bookx.getPrice();


       }
       return totalprice;


   }
    public void addBook(Book book)
    {
        try {
            bookRepository.save(book);
        } catch (SQLException e) {
            //log the exceptio
            throw new DatabaseWriteException("unable to write"+e.getMessage());
        }
    }


    }

