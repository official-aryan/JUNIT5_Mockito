package Stub;

import org.example.TestDouble_Stud.Book;
import org.example.TestDouble_Stud.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements BookRepository
//This is how we create a stud Repo so that we don't have to disturb the original repo.

{
    @Override
    public List<Book> findNewBooks(int days) {

        List<Book> newBooks=new ArrayList<>();
        Book book1=(new Book("1234","eat the frog",500, LocalDate.now()));
        Book book2=(new Book("12345","rich ",500, LocalDate.now()));

        newBooks.add(book1);
        newBooks.add(book2);
        return newBooks;
    }
}
