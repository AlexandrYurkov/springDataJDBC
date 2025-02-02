package ru.otus.alexandrYurkov.springApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.alexandrYurkov.springApp.entity.User;
import ru.otus.alexandrYurkov.springApp.repositories.UsersRepository;
import ru.otus.alexandrYurkov.springApp.services.ServiceApp;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringAppApplication  {
	private static final Logger logger = Logger.getLogger(SpringAppApplication.class.getName());
//	private final UsersRepository usersRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);

	}
//	public SpringAppApplication(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }
//	@Override
//	public void run(String... args) throws Exception {
//		logger.info(usersRepository.findAll().toString());
//		usersRepository.save(new User(null, "TEST", "10-02-2011"));
//		logger.info(usersRepository.allUsers().toString());
//
//	}
}
