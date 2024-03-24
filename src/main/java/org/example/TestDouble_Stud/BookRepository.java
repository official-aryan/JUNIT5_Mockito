package org.example.TestDouble_Stud;

import java.util.Collection;
import java.util.List;

public interface BookRepository  {


    List<Book> findNewBooks(int days);
}
