package org.example.Stubbing;

import java.util.List;

public class BookService {


    public BookRepository bookRepository;

    public BookService(org.example.Stubbing.BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    public int calculateTotalCost(List<String> bookIds)
    {
        int total=0;
        for (String bookId :bookIds)
        {
            Book book=bookRepository.findBookByBookId(bookId);
            total=total+ book.getPrice();
        }
        return total;
    }



    }

