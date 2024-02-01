package com.uabookshop.catalogservice;

import com.uabookshop.catalogservice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@AutoConfigureJsonTesters
public class BookJsonTests {

    @Autowired
    private JacksonTester<Book> json;

    void testSerialize() throws Exception {
        var book = Book.of(
                "1234567890", "Title", "Author", 3.20);

        var jsonContent = json.write(book);

        assertThat(jsonContent).extractingJsonPathArrayValue("@.isbn")
                .isEqualTo(book.isbn());
        assertThat(jsonContent).extractingJsonPathArrayValue("@.title")
                .isEqualTo(book.title());
        assertThat(jsonContent).extractingJsonPathArrayValue("@.author")
                .isEqualTo(book.author());
        assertThat(jsonContent).extractingJsonPathArrayValue("@.price")
                .isEqualTo(book.price());

    }

    @Test
    void testDeserialize() throws Exception {
        var content = """
                {
                "isbn" : "1234567890",
                "title" : "Title",
                "author" : "Author",
                "price" : 1.20
                }
                """;

        assertThat(json.parse(content))
                .usingRecursiveComparison()
                .isEqualTo(
                        Book.of(
                                "1234567890"
                                , "Title"
                                , "Author"
                                , 1.20));
    }
}
