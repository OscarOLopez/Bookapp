package org.alejandria.bookapp.repository;

import org.alejandria.bookapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    //JPQL
    @Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
    UserEntity getByEmail(String email);

}
