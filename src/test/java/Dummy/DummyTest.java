package Dummy;

import Fake.FakeBookRepository;
import org.example.TestDouble_fake.Book;
import org.example.TestDouble_fake.BookRepository;
import org.example.TestDouble_fake.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {

    @Test
    public void DemoDummy()
    {
        BookRepository fakebookRepository=new FakeBookRepository();
        BookService bookService=new BookService(fakebookRepository);
        // (fakebookRepository); it should have give an error, but it didn't so in dummy if we get a error as we have a emailservice we can do that we create a dummy email service classs outside and use it at  BookService bookService=new BookService(fakebookRepository,DummyEmailService); just to make the code run

        bookService.addBook(new Book("1234","eat the frog",999, LocalDate.now()));
        bookService.addBook(new Book("12345","Atomic Habit",699, LocalDate.now()));
        bookService.addBook(new Book("123456","Rich",699, LocalDate.now()));
        assertEquals(3,bookService.findNumberOfBooks());
    }

    // Testing with Mockito
    @Test
    public void DemoDummy_Mockito()
    {
        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        // as we have argument 2 in dummy bookservice class, we should have got an error there as we passed only
        //one argument in bookservice if we get an error we can do that we create a dummy service class and create a mock instance
        //EmailService emailserice=new Mockito.mock(EmailService.class);

        Book book1=new Book("111","rich dad",500,LocalDate.now());
        Book book2=new Book("222","poor dad",600,LocalDate.now());

        Collection<Book> books =new  ArrayList<>();
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
