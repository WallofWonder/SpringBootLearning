package com.example.demo.redis;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Address;
import com.example.demo.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void test(){

        Person rand = new Person("kobe", "ddd");
        rand.setAddress(new Address("losa", "usa"));
        personRepository.save(rand);
        Optional<Person> op = personRepository.findById(rand.getId());
        Person p2 = op.get();
        personRepository.count();
        //personRepository.delete(rand);

    }

    @Test
    public void testDelete(){

        personRepository.deleteById("f81027c7-6a00-452a-a6f5-43d819dba964");

    }

}