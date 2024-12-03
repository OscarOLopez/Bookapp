package org.alejandria.bookapp.controller;

import org.alejandria.bookapp.exceptions.BookNotFoundException;
import org.alejandria.bookapp.model.BookEntity;
import org.alejandria.bookapp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //Metodo para mapear getAll() que viene de BookService
    @GetMapping("/all")
    public List<BookEntity> getBooks(){
        return this.bookService.getAll();
    }

    //Metodo para mapear getById() usando PathVariable() en el endpoint
    @GetMapping("/{id}")
    public BookEntity findBookById(@PathVariable(name = "id")Long id){
        return this.bookService.getById(id);
    }

    //Metodo para crear un libro
    @PostMapping
    public ResponseEntity<BookEntity> newBook(@RequestBody BookEntity book){
        if (this.bookService.getByTitle(book.getTitle()) != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(this.bookService.createBook(book));
    }

    //Metodo para eliminar un user mediante Id
    @DeleteMapping("/delete-book/{id}")
    public void deleteBook(@PathVariable(name = "id")Long id){
        this.bookService.deleteBook(id);
    }

    //Metodo para Actualizar toda la entidad usando mapeo en PUT
    @PutMapping("/update-book/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable(name = "id")Long id, @RequestBody BookEntity book){
        try{
            return ResponseEntity.ok(this.bookService.updateBook(book, id));
        } catch (BookNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
