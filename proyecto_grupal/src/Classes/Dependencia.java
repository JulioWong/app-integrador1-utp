package Classes;

import Interfaces.MantenimientoGuardar;
import static Interfaces.MantenimientoGuardar.database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Dependencia implements MantenimientoGuardar{
    private String dependenciaId;
    private ArrayList<Equipo> equipos;
    private String descripcion;
    private Facultad facultad;

    public Dependencia() {
    }
    
    public Dependencia(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDependenciaId() {
        return dependenciaId;
    }

    public void setDependenciaId(String dependenciaId) {
        this.dependenciaId = dependenciaId;
    }

    public ArrayList<Equipo> getEquipos() {
        try {
            FindIterable<Document> data = this.database.getMongoCollection
                (Utils.Constant.equiposCollection).find(Filters.and(
                    eq("ubicacionActual", descripcion)
                ));
            ArrayList<Equipo> allEquipo = new ArrayList<>();
            for (Document document : data) {
                Equipo oEquipo = new Impresora();
                oEquipo.setCodigoPatrimonial(document.getString("codigoPatrimonial"));
                oEquipo.setClaseEquipo(document.getString("claseEquipo"));
                oEquipo.setEstado(document.getBoolean("estado"));
                Dependencia dependencia = new Dependencia();
                dependencia.setDescripcion(document.getString("ubicacionActual"));
                oEquipo.setDependencia(dependencia);
                allEquipo.add(oEquipo);
            }
            this.setEquipos(allEquipo);
        } catch (Exception e) {}
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
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
    public String guardar() {
        Document equipo = new Document("_id",new ObjectId());
        equipo.append("description", getDescripcion());
        equipo.append("facultadId", getFacultad().getFacultadId());
        database.insertMongoDocument(equipo, Utils.Constant.dependenciaCollection);
        return "";
    }

    @Override
    public String toString() {
        return this.descripcion;
    }  
}