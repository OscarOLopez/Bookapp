package org.alejandria.bookapp.repository;

import org.alejandria.bookapp.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long>{

    //JPQL
    // Por ISBN
    @Query("SELECT b FROM BookEntity b WHERE b.isbn = ?1")
    BookEntity getByIsbn(String isbn);

    // Por TITULO
    @Query("SELECT b FROM BookEntity b WHERE b.title = ?1")
    BookEntity getByTitle(String title);

    // Por autor
    @Query("SELECT b FROM BookEntity b WHERE b.author = ?1")
    List<BookEntity> getByAuthor(String author);

    // Filtro por precio
    @Query("SELECT b FROM BookEntity b WHERE b.price BETWEEN ?1 AND ?2")
    List<BookEntity> findByPriceBetween(Double minPrice, Double maxPrice);

    //filtro categoria
    @Query("SELECT b FROM BookEntity b WHERE b.category = ?1")
    List<BookEntity> getByCategory(String category);

    //filtro por editorial
    @Query("SELECT b FROM BookEntity b WHERE b.publisher = ?1 ORDER BY b.publisher ASC ")
    List<BookEntity> getByPublisher(String publisher);


}
