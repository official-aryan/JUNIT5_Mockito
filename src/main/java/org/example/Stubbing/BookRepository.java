package org.example.Stubbing;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);

    Book findBookByBookId(String bookId);
}
