package org.alejandria.bookapp.services;

import org.alejandria.bookapp.exceptions.BookNotFoundException;
import org.alejandria.bookapp.model.BookEntity;
import org.alejandria.bookapp.repository.BoookRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {

    // Instanciar BoookRespository
    private final BoookRespository bookRepository;

    // Inyectar en el constructor
    @Autowired
    public BookService(BoookRespository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Metodo para obtener todos los libros
    public List<BookEntity> getAll() {
        return this.bookRepository.findAll();
    }

    // Metodo para obtener un libro mediante su ID
    public BookEntity getById(Long id) {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    // Metodo para crear un nuevo libro
    public BookEntity createBook(BookEntity newBook) {
        return this.bookRepository.save(newBook);
    }

    //Metodo para eliminar un libro mediante ID
    public void deleteBook(Long id) {
        if (this.bookRepository.existsById(id)) {
            this.bookRepository.deleteById(id);
        } else {
            throw new BookNotFoundException(id);
        }
    }

    // getByTitle() (JPQL y ResponseEntity<>)
    public BookEntity getByTitle(String title) {
        return this.bookRepository.getByTitle(title);
    }

    //PUT -> Actualizando toda la entidad (BookEntity)
    public BookEntity updateBook(BookEntity book, Long id) {
        return bookRepository.findById(id).map(bookMap ->{
            bookMap.setPrice(book.getPrice());
            bookMap.setCost(book.getCost());
            bookMap.setAuthor(book.getAuthor());
            bookMap.setIsbn(book.getIsbn());
            bookMap.setTitle(book.getTitle());
            bookMap.setPublisher(book.getPublisher());
            bookMap.setDatePublished(book.getDatePublished());
            bookMap.setPageCount(book.getPageCount());
            bookMap.setStock(book.getStock());
            bookMap.setLanguage(book.getLanguage());
            bookMap.setFormat(book.getFormat());
            bookMap.setDescription(book.getDescription());
            bookMap.setCoverImg(book.getCoverImg());
            return this.bookRepository.save(bookMap);
        })
                .orElseThrow(() -> new BookNotFoundException(id));
    }

}