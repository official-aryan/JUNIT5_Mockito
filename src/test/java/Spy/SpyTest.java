package Spy;

import org.example.TestDouble_Spy.Book;
import org.example.TestDouble_Spy.BookRepository;
import org.example.TestDouble_Spy.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class SpyTest {

    @Test
    public void demoSpy()
    {BookRepository bookRepositorySPY=new BookRepositorySpy();

        BookService bookService=new BookService(bookRepositorySPY);

        org.example.TestDouble_Spy.Book book1=(new org.example.TestDouble_Spy.Book("1234","eat the frog",500, LocalDate.now()));
        org.example.TestDouble_Spy.Book book2=(new org.example.TestDouble_Spy.Book("12345","rich ",500, LocalDate.now()));

        bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(2, ((BookRepositorySpy) bookRepositorySPY).timeCalled());
        assertTrue(((BookRepositorySpy) bookRepositorySPY).calledwith(book2));
    }

    @Test
    public void Mockito_Spy()
    {
       BookRepository bookRepositorySpy= Mockito.spy(BookRepository.class);
       BookService bookService=new BookService(bookRepositorySpy);

        Book book1=new Book("123","rich",500,LocalDate.now());
        Book book2=new Book("1232","poor",450,LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        verify(bookRepositorySpy,Mockito.times(1)).save(book1);
        verify(bookRepositorySpy,Mockito.times(1)).save(book2);


    }



}
