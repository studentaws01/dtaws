package com.aerospike.userdemo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.aerospike.userdemo.objects.User;
public interface AerospikeUserRepository extends CrudRepository<User, Object> {
}