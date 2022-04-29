package com.tedaneblake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}
	
	@Bean 
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a few customers 
			
			repository.save(new Customer("Jack", "Jogn"));
			repository.save(new Customer("April", "James"));
			repository.save(new Customer("Micahel", "Husain"));
			repository.save(new Customer("Yammol", "Henry"));
			repository.save(new Customer("Killian", "Mpape"));
			
			//fetch all customers (method from CrudRepository)
			log.info("Customres found with findAll()");
			for(Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");
			
			//fetch customers by last name (custom method)
			log.info("Customer found with findByLastName('James')");
			repository.findByLastName("James").forEach(james -> {
				log.info(james.toString());
			});		
			log.info("");
			
			//find individual by id (custom method)
			log.info("Customer with id of 2L");
			Customer customer = repository.findById(2L);
			log.info(customer.toString());
			log.info("");
			
		};
	}

}
