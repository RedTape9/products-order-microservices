package io.github.redtape9.productservice.repo;

import io.github.redtape9.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{
}
