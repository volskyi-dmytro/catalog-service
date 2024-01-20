package com.uabookshop.catalogservice.demo;

import com.uabookshop.catalogservice.domain.Book;
import com.uabookshop.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {

        var book1 = new Book("1234567801", "Death and the Penguin", "Andrey Kurkov", 15.90);
        var book2 = new Book("1234567802", "Field Work in Ukrainian Sex", "Oksana Zabuzhko", 13.90);
        var book3 = new Book("1234567803", "The Museum of Abandoned Secrets", "Oksana Zabuzhko", 17.90);
        var book4 = new Book("1234567804", "Sweet Darusya: A Tale of Two Villages", "Maria Matios", 12.90);
        var book5 = new Book("1234567805", "Zhadan Diaries: The Ukrainian Night", "Serhiy Zhadan", 14.90);
        var book6 = new Book("1234567806", "The Lost Button", "Irene Rozdobudko", 10.90);
        var book7 = new Book("1234567807", "Mesopotamia", "Serhiy Zhadan", 16.90);
        var book8 = new Book("1234567808", "The Orphanage", "Serhiy Zhadan", 15.90);
        var book9 = new Book("1234567809", "The House with the Stained-Glass Window", "Żanna Słoniowska", 11.90);
        var book10 = new Book("1234567810", "Voroshilovgrad", "Serhiy Zhadan", 18.90);

        Arrays.asList(book1, book2, book3, book4, book5,
                book6, book7, book8, book9, book10).forEach(bookRepository::save);

    }
}
