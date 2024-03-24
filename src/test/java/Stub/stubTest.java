package Stub;

import org.example.TestDouble_Stud.Book;
import org.example.TestDouble_Stud.BookRepository;
import org.example.TestDouble_Stud.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class stubTest {

    @Test
    public void demoStub()
    {

        BookRepository bookRepository=new BookRepositoryStub();
        BookService bookService=new BookService(bookRepository);
        List<Book> newBookWithAplliedDiscopunt = bookService.getNewBookWithAplliedDiscopunt(10, 7);

        assertEquals(2,newBookWithAplliedDiscopunt.size());
        assertEquals(450,newBookWithAplliedDiscopunt.get(0).getPrice());
        assertEquals(450,newBookWithAplliedDiscopunt.get(1).getPrice());

    }

    //Stud Mockito

    @Test
    public void Mockito_Stub()
    {

        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        BookService bookService=new BookService(bookRepository);


        Book book1=new Book("1112","rich dad",500, LocalDate.now());
        Book book2=new Book("2223","poor dad",400,LocalDate.now());

        List<Book> newBooks =new ArrayList<>();
        newBooks.add(book1);
        newBooks.add(book2);

        when(bookRepository.findNewBooks(7)).thenReturn(newBooks);

        List<Book> newBookWithAplliedDiscopunt = bookService.getNewBookWithAplliedDiscopunt(10, 7);

        assertEquals(2,newBookWithAplliedDiscopunt.size());
        assertEquals(450,newBookWithAplliedDiscopunt.get(0).getPrice());
        assertEquals(360,newBookWithAplliedDiscopunt.get(1).getPrice());


    }
}
