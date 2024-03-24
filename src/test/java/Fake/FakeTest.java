package Fake;

import org.example.TestDouble_fake.Book;
import org.example.TestDouble_fake.BookRepository;
import org.example.TestDouble_fake.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeTest {

    @Test
    public void testFake()
    {
        BookRepository fakebookRepository=new FakeBookRepository();
        BookService bookService=new BookService(fakebookRepository);

        bookService.addBook(new Book("1234","eat the frog",999, LocalDate.now()));
        bookService.addBook(new Book("12345","Atomic Habit",699, LocalDate.now()));
        bookService.addBook(new Book("123456","Rich",699, LocalDate.now()));
        assertEquals(3,bookService.findNumberOfBooks());
    }

    // Testing with Mockito in the same Fake TEST
    @Test
    public void testFake_Mockito()
    {
        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1=new Book("111","rich dad",500,LocalDate.now());
        Book book2=new Book("222","poor dad",600,LocalDate.now());

        Collection<Book> books =new ArrayList<>();
        books.add(book1);
        books.add(book2);

        Mockito.when(bookRepository.findAll()).thenReturn(books);

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
