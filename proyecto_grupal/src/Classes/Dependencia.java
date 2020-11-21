package Classes;

import java.util.List;

public class Dependencia {
    private final int dependenciaId;
    private List<Equipo> equipos;
    private String descripcion;

    public Dependencia(int dependenciaId) {
        this.dependenciaId = dependenciaId;
    }

    public int getDependenciaId() {
        return dependenciaId;
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
    public void guardarDependencia(){
        
    }
}