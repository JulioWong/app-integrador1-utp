package Classes;

import Data.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import org.bson.Document;

public class Facultad {
    private final Database database;
    
    private final int facultadId;
    private ArrayList<Dependencia> dependencias;
    private final String descripcion;

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

    public void setDependencias(ArrayList<Dependencia> dependencias) {
        this.dependencias = dependencias;
    }

    public ArrayList<Dependencia> getDependencias() {
        FindIterable<Document> data = this.database.getMongoCollection
                (Utils.Constant.dependenciaCollection).find(Filters.and(
                    eq("facultadId", facultadId),
                    eq("deleted", "0")
                ));
        
        ArrayList<Dependencia> allDependencias = new ArrayList<>();
        for (Document document : data) {
            Dependencia dep = new Dependencia();
            dep.setDependenciaId(document.getObjectId("_id").toString());
            dep.setDescripcion(document.get("description").toString());
            allDependencias.add(dep);
        }
        setDependencias(allDependencias);
        return dependencias;
    }
    
    @Override
    public String toString() {
        return this.getDescripcion();
    }
}
