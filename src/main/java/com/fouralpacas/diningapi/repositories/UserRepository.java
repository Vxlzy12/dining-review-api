package com.fouralpacas.diningapi.repositories;

import com.fouralpacas.diningapi.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByDisplayName(String displayName);


}
