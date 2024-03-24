package Annotations;

import org.example.Mockito_annotations.Book;
import org.example.Mockito_annotations.BookRepository;
import org.example.Mockito_annotations.BookService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Annotations_Test {

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    public BookRepository bookRepository;

    @Test
    public void Mock_annotations()
    {



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
