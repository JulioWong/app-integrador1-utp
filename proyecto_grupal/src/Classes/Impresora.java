package Classes;

public class Impresora extends Equipo{

    private String tipo;
    private Boolean impresionColor;

    public Impresora() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getImpresionColor() {
        return impresionColor;
    }

    public void setImpresionColor(Boolean impresionColor) {
        this.impresionColor = impresionColor;
    }

    @Override
    public void guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obtenerInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
