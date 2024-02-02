package com.uabookshop.catalogservice.demo;

import com.uabookshop.catalogservice.domain.Book;
import com.uabookshop.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();

        var book1 = Book.of("1234567801", "Death and the Penguin", "Andrey Kurkov", 15.90, "The Old Lion");
        var book2 = Book.of("1234567802", "Field Work in Ukrainian Sex", "Oksana Zabuzhko", 13.90, "The Old Lion");
        var book3 = Book.of("1234567803", "The Museum of Abandoned Secrets", "Oksana Zabuzhko", 17.90, "The Old Lion");
        var book4 = Book.of("1234567804", "Sweet Darusya: A Tale of Two Villages", "Maria Matios", 12.90, "The Old Lion");
        var book5 = Book.of("1234567805", "Zhadan Diaries: The Ukrainian Night", "Serhiy Zhadan", 14.90, "The Old Lion");
        var book6 = Book.of("1234567806", "The Lost Button", "Irene Rozdobudko", 10.90, "The Old Lion");
        var book7 = Book.of("1234567807", "Mesopotamia", "Serhiy Zhadan", 16.90, "The Old Lion");
        var book8 = Book.of("1234567808", "The Orphanage", "Serhiy Zhadan", 15.90, "The Old Lion");
        var book9 = Book.of("1234567809", "The House with the Stained-Glass Window", "Żanna Słoniowska", 11.90, "The Old Lion");
        var book10 = Book.of("1234567810", "Voroshilovgrad", "Serhiy Zhadan", 18.90, "The Old Lion");

        bookRepository.saveAll(List.of(book1, book2, book3, book4, book5,
                book6, book7, book8, book9, book10));

    }
}
