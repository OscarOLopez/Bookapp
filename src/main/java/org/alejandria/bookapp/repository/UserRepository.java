package org.alejandria.bookapp.repository;

import org.alejandria.bookapp.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {


}
