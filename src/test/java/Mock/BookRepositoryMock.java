package Mock;

import org.example.TestDouble_Mock.Book;
import org.example.TestDouble_Mock.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryMock implements BookRepository {

    int saveCalled=0;
    Book lastAddedBook=null;
    @Override
    public void save(Book book)

    {
        saveCalled++;
        lastAddedBook=book;

    }

    public void verify(Book book,int time)
    {
        assertEquals(time,saveCalled);
        assertEquals(book,lastAddedBook);



    }

}
