package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
 // 继承CrudRepository，获取基本的CRUD操作
}