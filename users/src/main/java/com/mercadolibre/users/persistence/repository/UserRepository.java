package com.mercadolibre.users.persistence.repository;

import com.mercadolibre.users.persistence.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
