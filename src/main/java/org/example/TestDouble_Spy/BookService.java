package org.example.TestDouble_Spy;

public class BookService {


    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book)
        {
            bookRepository.save(book);
        }


    public void addBook(org.example.TestDouble_Mock.Book book1) {
    }
}

