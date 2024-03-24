package Dummy;

import org.example.TestDouble_fake.Book;
import org.example.TestDouble_fake.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//as we need a database, so we create a fake repository intead of actual database
public class FakeBookRepository implements BookRepository {

    Map<String,Book> bookstore=new HashMap<>();
    @Override
    public void save(Book book) {
        bookstore.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookstore.values(); // this will retiurn us all the book store in Book class
    }
}
