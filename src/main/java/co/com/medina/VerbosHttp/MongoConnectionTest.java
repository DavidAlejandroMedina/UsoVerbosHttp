package co.com.medina.VerbosHttp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoConnectionTest implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            // Intenta obtener una lista de las colecciones en la base de datos
            boolean connected = mongoTemplate.getDb().listCollectionNames().first() != null;
            if (connected) {
                System.out.println("Conexión a MongoDB exitosa.");
            } else {
                System.out.println("Conexión a MongoDB fallida.");
            }
        } catch (Exception e) {
            System.out.println("Error al conectarse a MongoDB: " + e.getMessage());
        }
    }
}
