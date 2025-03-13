package com.testapi.testapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.sax.SAXResult;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public ResponseEntity<List<String>> getAllBooks() {
        // Fetches all books from the service layer and returns them
        return ResponseEntity.status(HttpStatus.OK)
                .body( new ArrayList<>(List.of("book1", "book2")));
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getAllBooksByName(@PathVariable String name) {
        // Fetches all books from the service layer and returns them
        return ResponseEntity.status(HttpStatus.OK)
                .body(name);
    }

}