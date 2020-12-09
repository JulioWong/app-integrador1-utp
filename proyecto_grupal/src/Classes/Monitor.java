package Classes;

import Data.Database;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
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
        Document oData = this.database.getMongoCollection(Utils.Constant.equiposCollection)
         .find(Filters.and(
             eq("codigoPatrimonial", this.getCodigoPatrimonial()),
             eq("claseEquipo", this.getClaseEquipo())
         )
        ).first();
        if(oData==null){
            this.setCodigoPatrimonial("");
            return;
        }
        this.setCodigoPatrimonial(oData.getString("codigoPatrimonial"));
        this.setMarca(oData.getString("marca"));
        this.setModelo(oData.getString("modelo"));
        this.setEstado(oData.getBoolean("estado"));
        this.setObservaciones(oData.getString("observaciones"));
        this.setTipoPantalla(oData.getString("tipoPantalla"));
        this.setResolucion(oData.getString("resolucion"));
    }

    @Override
    public String guardar() {
        String rsVal=super.validar();
        if(rsVal != null){
            return rsVal;
        }
        if(resolucion == null){
            return "Ingrese resolución de pantalla en pulgadas";
        }
        Document equipo = new Document("equipoId",new ObjectId());
        equipo.append("claseEquipo", getClaseEquipo());
        equipo.append("codigoPatrimonial", getCodigoPatrimonial());
        equipo.append("modelo", getModelo());
        equipo.append("marca", getMarca());
        equipo.append("estado", getEstado());
        equipo.append("observaciones", getObservaciones());
        equipo.append("ubicacionActual", getUbicacionActual());
        equipo.append("resolucion", resolucion);
        equipo.append("tipoPantalla", tipoPantalla);
        database.insertMongoDocument(equipo, Utils.Constant.equiposCollection);
        return null;
    }

    
}
