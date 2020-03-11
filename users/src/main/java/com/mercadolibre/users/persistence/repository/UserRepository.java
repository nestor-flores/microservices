package com.mercadolibre.users.persistence.repository;

import com.mercadolibre.users.persistence.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByName(String name);
}
