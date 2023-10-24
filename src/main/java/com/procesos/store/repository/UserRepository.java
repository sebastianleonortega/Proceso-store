package com.procesos.store.repository;


import com.procesos.store.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u INNER JOIN FETCH u.addressList a WHERE u.id = :id")
    User findUserWithAddress(@Param("id") Long id);
}
