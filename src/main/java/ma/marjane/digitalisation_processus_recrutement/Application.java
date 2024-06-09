package ma.marjane.digitalisation_processus_recrutement;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @PostConstruct
    public void init() {
        // Créer le répertoire d'upload s'il n'existe pas
        String uploadDir = "./uploads";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

}
