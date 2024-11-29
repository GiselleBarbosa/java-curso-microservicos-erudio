package br.com.barbosa.controller;

import br.com.barbosa.model.Book;
import br.com.barbosa.proxy.CambioProxy;
import br.com.barbosa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @GetMapping(value = "/{id}/{currency}")
    public Book getBook(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ) {

        var book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment("Book port: " + port +
                " Cambio port: " + cambio.getEnvironment());
        book.setPrice(cambio.getConvertedValue());

        return book;
    }
}
