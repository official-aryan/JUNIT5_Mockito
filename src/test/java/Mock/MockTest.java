package Mock;

import org.example.TestDouble_Mock.Book;
import org.example.TestDouble_Mock.BookRepository;
import org.example.TestDouble_Mock.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockTest {

    @Test
    public void demoMock()
    {
        BookRepositoryMock bookRepositoryMock=new BookRepositoryMock();

        BookService bookService=new BookService((BookRepository) bookRepositoryMock);

        Book book1=new Book("1234","Mock" ,500,LocalDate.now());
        Book book2=new Book("12345","Spy" ,400,LocalDate.now());

         bookService.addBook(book1);// return
         bookService.addBook(book2);//save will be called

         bookRepositoryMock.verify(book2,1);

        // we are checking that as we can see book1 is greater than 400 so it return and no book is added
        // so we passed argument book2 and 1 as only one book is added whick is book2

    }

    @Test
    public void Mockito_Mock()
    {
        BookRepository bookRepositoryMock= Mockito.mock(BookRepository.class);

        BookService bookService=new BookService((BookRepository) bookRepositoryMock);

        Book book1=new Book("1234","Mock" ,500,LocalDate.now());
        Book book2=new Book("12345","Spy" ,400,LocalDate.now());

        bookService.addBook(book1);// return
        bookService.addBook(book2);//save will be called

        Mockito.verify(bookRepositoryMock,Mockito.times(1)).save(book2);
        Mockito.verify(bookRepositoryMock,Mockito.times(0)).save(book1);
        //we are verifing weather save is called or not with book2 as book1 give return.



    }
}
