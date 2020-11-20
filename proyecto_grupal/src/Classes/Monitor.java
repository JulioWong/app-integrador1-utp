/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Data.Database;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author GUSTAVO
 */
public class Monitor extends Equipo{

    public String getResolucion() {
        return Resolucion;
    }

    public void setResolucion(String Resolucion) {
        this.Resolucion = Resolucion;
    }

    public String getTipoPantalla() {
        return TipoPantalla;
    }

    public void setTipoPantalla(String TipoPantalla) {
        this.TipoPantalla = TipoPantalla;
    }

    private String Resolucion;
    private String TipoPantalla;
    public Monitor() {
    }

    
    @Override
    public void GuardarEquipo() {
        Database DB = new Database();
        Document equipo = new Document("_id",new ObjectId());
        equipo.append("CodigoPatrimonial", getCodigoPatrimonial());
        equipo.append("Modelo", getModelo());
        equipo.append("Marca", getMarca());
        equipo.append("Estado", getEstado());
        equipo.append("Resolucion", Resolucion);
        equipo.append("TipoPantalla", TipoPantalla);
        DB.insertMongoDocument(equipo, "Equipo");
    }

    @Override
    public void ObtenerInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
