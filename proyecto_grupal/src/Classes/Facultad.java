package Classes;

import Data.Database;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import org.bson.Document;

public class Facultad {
    private final Database database;
    private final int facultadId;
    private List<Dependencia> dependencia;
    private String descripcion;

    public Facultad(int facultadId) {
        this.database = new Database();
        Document data = this.database.getMongoCollection
                    (Utils.Constant.facultadCollection).find(Filters.and(
                        eq("facultadId", facultadId)
                    )).first();
        this.facultadId = facultadId;
        this.descripcion = data.get("description").toString();
    }

    public int getFacultadId() {
        return facultadId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Dependencia> listarDependencias() {
        
        return dependencia;
    }
    
    @Override
    public String toString() {
        return this.getDescripcion();
    }
}
