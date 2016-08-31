package co.uk.vehicle.inc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.uk.vehicle.inc.entity.Vehicle;
import co.uk.vehicle.inc.entity.constant.Status;
import co.uk.vehicle.inc.entity.constant.VehicleType;
import co.uk.vehicle.inc.repository.IVehicleRepository;

@SpringBootApplication
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(IVehicleRepository repository) {
		return (args) -> {

			repository.save(new Vehicle("X-45", 4, 30, Status.AVAILABLE, VehicleType.CAR));
			repository.save(new Vehicle("Tuareg", 4, 4, Status.AVAILABLE, VehicleType.CAR));
			repository.save(new Vehicle("Vesper TX", 2, 1, Status.AVAILABLE, VehicleType.MOTORBIKE));
			repository.save(new Vehicle("VW Bus", 4, 10, Status.AVAILABLE, VehicleType.CAR));
			repository.save(new Vehicle("Audi 360", 4, 4, Status.AVAILABLE, VehicleType.CAR));
			repository.save(new Vehicle("M345", 4, 1, Status.AVAILABLE, VehicleType.CONVERTIBLE));

			// fetch all movies
			LOGGER.info("Vehicles found with findAll():");
			LOGGER.info("-------------------------------");
			for (Vehicle v : repository.findAll()) {
				LOGGER.info(v.toString());
			}
			LOGGER.info("");

			// fetch an individual movie by ID
			Vehicle v = repository.findOne(1L);
			LOGGER.info("Vehicle found with findOne(1L):");
			LOGGER.info("--------------------------------");
			LOGGER.info(v.toString());
			LOGGER.info("");

			// fetch movies by title Underworld
			LOGGER.info("Movie found by findByModel('X-45'):");
			LOGGER.info("--------------------------------------------");
			for (Vehicle x45 : repository.findByModelContaining("X-45")) {
				LOGGER.info(x45.toString());
			}

		};
	}
}
