package com.telusko.SpringJDBCDemo;

import com.telusko.SpringJDBCDemo.model.Alien;
import com.telusko.SpringJDBCDemo.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		// inserting into h2 local database without spring data jpa and then fetching the data from the database and printing it to the console
		ApplicationContext context = SpringApplication.run(SpringJdbcDemoApplication.class, args);

		Alien a1 = context.getBean(Alien.class);
		a1.setName("Dheeraj");
		a1.setId(101);
		a1.setTech("Java");

		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(a1);

		System.out.println(repo.findAll());
	}

}
