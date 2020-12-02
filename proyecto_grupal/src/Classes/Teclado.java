package Classes;

public class Teclado extends Equipo{
    private String tipoTeclado; // ERGONOMICO, MULTIMEDIA, MEMBRANA O MECANICO
    private String conexion;  // CABLE USB O INALAMBRICO
    private String distribucion; // NUMERICO, COMANDO O ALFANUMERICO

    public Teclado() {
    }

    public String getTipoTeclado() {
        return tipoTeclado;
    }

    public void setTipoTeclado(String tipoTeclado) {
        this.tipoTeclado = tipoTeclado;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getDistribucion() {
        return distribucion;
    }

    public void setDistribucion(String distribucion) {
        this.distribucion = distribucion;
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
