package Classes;

public class Facultad {
    private final int facultadId;
    private final String descripcion;

    public Facultad(int facultadId, String descripcion) {
        this.facultadId = facultadId;
        this.descripcion = descripcion;
    }

    public int getFacultadId() {
        return facultadId;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        return this.getDescripcion();
    }
}
