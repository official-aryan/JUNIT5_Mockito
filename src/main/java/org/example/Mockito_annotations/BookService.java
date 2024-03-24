package org.example.Mockito_annotations;

import java.util.List;

public class BookService {


    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBookWithAplliedDiscopunt(int discount_rate, int days )
    {
        List<Book> newBooks=bookRepository.findNewBooks(days);
        // 10% discount on 500 bo prices of book -> 50 -500 ->450/-

        for(Book book:newBooks)
        {
            int price =book.getPrice();
            int newPrice=price -(discount_rate * price/100);
            book.setPrice(newPrice);

        }
        return newBooks;
    }



    }

