package com.aerospike.userdemo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.aerospike.userdemo.objects.User;
import com.aerospike.userdemo.repositories.AerospikeUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	AerospikeUserRepository aerospikeUserRepository;

	public Optional<User> readUserById(int id) {
		return aerospikeUserRepository.findById(id);
	}

	public void addUser(User user) {
		aerospikeUserRepository.save(user);
	}

	public void removeUserById(int id) {
		aerospikeUserRepository.deleteById(id);
	}

	public List<User> findAll() {
		List<User> result = 
				  StreamSupport.stream(aerospikeUserRepository.findAll().spliterator(), false)
				    .collect(Collectors.toList());
		
		return result;
	}
}