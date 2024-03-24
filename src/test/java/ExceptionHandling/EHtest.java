package ExceptionHandling;

import org.example.Exceptionhandling.*;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EHtest {

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();
    @InjectMocks
    private BookService bookService;
    @Mock
    public BookRepository bookRepository;

    @Test
    public void testAddbook() throws SQLException {
       Book book=new Book(null,"mockito",500, LocalDate.now());
        doThrow(SQLDataException.class).when(bookRepository).save(book);
        assertThrows(DatabaseWriteException.class,()->bookService.addBook(book));

    }
}
