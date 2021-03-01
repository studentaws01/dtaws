package com.aerospike.userdemo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aerospike.userdemo.objects.User;
import com.aerospike.userdemo.repositories.AerospikeUserRepository;


public class UserRepositoryTests extends UserdemoApplicationTests {

    String id;

    User user;

    @Autowired
    AerospikeUserRepository repository;

    @BeforeEach
    void setUp() {
        user = User.builder()
        		.id(0)
                .age(10)
                .name("Inception")
                .email("test@test.org")
                .build();
    }

    @Test
    public void save_savesUser() {
        repository.save(user);

    }

   
}