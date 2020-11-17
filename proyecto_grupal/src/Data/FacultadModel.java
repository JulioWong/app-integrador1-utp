package Data;

import com.mongodb.client.FindIterable;
import org.bson.Document;

public class FacultadModel {

    private final Database database;
    private final String collection;

    public FacultadModel() {
        this.database = new Database();
        this.collection = "facultad";
    }
    
    public FindIterable<Document> getAll() {
        return this.database.getMongoCollection(this.collection).find();
    }
}
