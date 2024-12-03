package org.alejandria.bookapp.repository;

import org.alejandria.bookapp.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
