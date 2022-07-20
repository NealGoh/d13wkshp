package sg.edu.nus.iss.day13wkshp;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sg.edu.nus.iss.day13wkshp.services.DatabaseService;

@SpringBootApplication
public class Day13wkshpApplication implements ApplicationRunner {

	@Autowired
	DatabaseService dbSvc;

	public static void main(String[] args) {
		SpringApplication.run(Day13wkshpApplication.class, args);
	}

	//mvn spring-boot:run -Dspring-boot.run.arguments="--dataDir=c:\data" 
	//key this command line in the terminal to run the program with the required arguments
	@Override
	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			dbSvc.setDataDir(new File(dataDir));

			if (!dbSvc.isDataDirValid()) {
				System.err.printf("%s does not exist, it is not a directory or not writable.", dataDir);
				System.exit(-1);
			}

			System.out.printf("Using %s as data directory\n", dataDir);
		} else {
			///Users/Zerouf/data
			dbSvc.setDataDir(new File("./data"));
		}
	}

}
