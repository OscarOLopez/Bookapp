package org.alejandria.bookapp.repository;

import org.alejandria.bookapp.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoookRespository extends JpaRepository<BookEntity, Long>{

    //JPQL
    // Por ISBN
    @Query("SELECT b FROM BookEntity b WHERE b.isbn = ?1")
    BookEntity getByIsbn(String isbn);

    // Por TITULO
    @Query("SELECT b FROM BookEntity b WHERE b.title = ?1")
    BookEntity getByTitle(String title);

    // Por autor
    @Query("SELECT b FROM BookEntity b WHERE b.author = ?1")
    BookEntity getByAuthor(String author);

    // Filtro por precio
    @Query("SELECT b FROM BookEntity b WHERE b.price BETWEEN ?1 AND ?2")
    BookEntity findByPriceBetween(Double minPrice, Double maxPrice);

    //filtro categoria
    @Query("SELECT b FROM BookEntity b WHERE b.category = ?1")
    BookEntity getByCategory(String category);

    //filtro por editorial
    @Query("SELECT b FROM BookEntity b WHERE b.publisher ORDER BY publisher ASC ")
    BookEntity getByPublisher(String publisher);


}
