package Classes;
public class Proyector extends Equipo {

    private String tecnologia;// DLP O LCD
    private String contraste; // NATIVO O DINAMICO
    private String resolucion; // ALTA O BAJA
    
    public String getTecnologia() {
        return tecnologia;
    }

    public String getContraste() {
        return contraste;
    }

    public String getResolucion() {
        return resolucion;
    }

    public Proyector() {
    }

    @Override
    public void obtenerInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
