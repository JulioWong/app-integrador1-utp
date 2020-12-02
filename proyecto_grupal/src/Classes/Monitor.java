package Classes;

import Data.Database;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Monitor extends Equipo{

    private String resolucion;
    private String tipoPantalla;
    
    public Monitor() {
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    

    @Override
    public void obtenerInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardar() {
        Document equipo = new Document("_id",new ObjectId());
        equipo.append("CodigoPatrimonial", getCodigoPatrimonial());
        equipo.append("Modelo", getModelo());
        equipo.append("Marca", getMarca());
        equipo.append("Estado", getEstado());
        equipo.append("Resolucion", resolucion);
        equipo.append("TipoPantalla", tipoPantalla);
        database.insertMongoDocument(equipo, "Equipo");
    }
    
}
