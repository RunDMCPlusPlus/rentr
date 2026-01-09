package se.johan.rentr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for Rentr.
 */
@SpringBootApplication
public class RentrApplication {

	/**
	 * Main method to start the Rentr application.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(RentrApplication.class, args);
	}
}
