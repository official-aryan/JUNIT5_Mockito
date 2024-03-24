package Stubbing;

import org.example.Stubbing.Book;
import org.example.Stubbing.BookRepository;
import org.example.Stubbing.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Stubbing {

    @InjectMocks
    private BookService bookService;

    @Mock
    public BookRepository bookRepository;


    @Test
    public void Stubbing()
    {
        List<String> bookIds=new ArrayList<>();
        bookIds.add("1234");
        bookIds.add("1235");

        Book book1=new Book("1234","rich",500,LocalDate.now());
        Book book2=new Book("1235","poor",400,LocalDate.now());

        when(bookRepository.findBookByBookId("1234")).thenReturn(book1);
        when(bookRepository.findBookByBookId("1235")).thenReturn(book2);

        doReturn(book1).when(bookRepository.findBookByBookId("1234"));


       int actualcost= bookService.calculateTotalCost(bookIds);

        assertEquals(900,actualcost);

    }
}
