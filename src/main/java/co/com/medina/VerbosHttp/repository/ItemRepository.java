package co.com.medina.VerbosHttp.repository;


import co.com.medina.VerbosHttp.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {

}
