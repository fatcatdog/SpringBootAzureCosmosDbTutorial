package com.example.demo;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.Optional;

@SpringBootApplication
public class OurcosmosdbExampleApplication implements CommandLineRunner {

private final UserRepository repository;

	public OurcosmosdbExampleApplication(UserRepository repository) {
		this.repository = repository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OurcosmosdbExampleApplication.class, args);
        System.exit(0);
	}

	@Override
	public void run(String... args) throws Exception {
		 // Create a unique identifier.
        String uuid = UUID.randomUUID().toString();

        // Create a new User class.
        final User testUser = new User(uuid, "Carl", "Jr");

        // For this example, remove all of the existing records.
//        repository.deleteAll();

        // Save the User class to the Azure database.
        repository.save(testUser);

        // Retrieve the database record for the User class you just saved by ID.
        Optional<User> result = repository.findById(testUser.getId());

        // Display the results of the database record retrieval.
        System.out.println("\nSaved user is: " + result + "\n");
		
	}

}
