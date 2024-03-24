package Spy;

import org.example.TestDouble_Spy.Book;
import org.example.TestDouble_Spy.BookRepository;

public class BookRepositorySpy implements BookRepository {

    int saveCalled=0;
    Book lastAddedBook=null;
    @Override
    public void save(Book book)

    {
        saveCalled++;
        lastAddedBook=book;

    }

    public int timeCalled()
    {
        return saveCalled;
    }
    public boolean calledwith(Book book)
    {
        return lastAddedBook.equals(book);
    }

}
