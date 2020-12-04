package Classes;

import Interfaces.MantenimientoGuardar;
import static Interfaces.MantenimientoGuardar.database;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Dependencia implements MantenimientoGuardar{
    private String dependenciaId;
    private List<Equipo> equipos;
    private String descripcion;
    private Facultad facultad;

    public Dependencia() {
    }

    public String getDependenciaId() {
        return dependenciaId;
    }

    public void setDependenciaId(String dependenciaId) {
        this.dependenciaId = dependenciaId;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public void guardar() {
        Document equipo = new Document("_id",new ObjectId());
        equipo.append("description", getDescripcion());
        equipo.append("facultadId", getFacultad().getFacultadId());
        database.insertMongoDocument(equipo, Utils.Constant.dependenciaCollection);
    }
}