package com.thoughtworks.capability.infrastructure;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    List findAll();
}
