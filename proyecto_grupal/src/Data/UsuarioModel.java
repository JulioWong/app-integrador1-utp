package Data;

import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;

public class UsuarioModel {
    private final Database database;
    private final String collection;

    public UsuarioModel() {
        this.database = new Database();
        this.collection = "user";
    }
    
    public Document getUserByLogin(int facultadId, String usuario, 
            String password) {
        return this.database.getMongoCollection(this.collection)
            .find(Filters.and(
                eq("user", usuario), 
                eq("password", password),
                eq("facultadId", String.valueOf(facultadId))
            )
        ).first();
    }
}