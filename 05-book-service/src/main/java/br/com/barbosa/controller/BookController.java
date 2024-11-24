package br.com.barbosa.controller;

import br.com.barbosa.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @GetMapping(value = "/{id}/{currency}")
    public Book getBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {
        var port = environment.getProperty("local.server.port");

        return new Book(
                1L,
                "Robert Cecil Martin",
                "Clean Code",
                new Date(),
                Double.valueOf(89.9),
                currency,
                port
        );
    }
}
