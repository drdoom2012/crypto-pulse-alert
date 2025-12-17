package cz.erebos.cpa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoPulseAlertApplication {

	private static final Logger log = LoggerFactory.getLogger(CryptoPulseAlertApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CryptoPulseAlertApplication.class, args);
		log.info("🟩 CryptoPulseAlertApplication started successfully – system is up");
	}

}
