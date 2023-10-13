package com.fouralpacas.diningapi.repositories;

import com.fouralpacas.diningapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByDisplayName(String displayName);
    Boolean existsByDisplayName(String displayName);
}
