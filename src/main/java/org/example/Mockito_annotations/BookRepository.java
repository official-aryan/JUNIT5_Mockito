package org.example.Mockito_annotations;

import java.util.List;

public interface BookRepository  {


    List<Book> findNewBooks(int days);
}
