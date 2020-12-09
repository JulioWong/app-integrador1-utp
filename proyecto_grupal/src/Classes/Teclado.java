package Classes;

import static Interfaces.MantenimientoGuardar.database;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.types.ObjectId;

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
        this.setTipoTeclado(oData.getString("tipoTeclado"));
        this.setConexion(oData.getString("conexion"));
        this.setDistribucion(oData.getString("distribucion"));
    }

    @Override
    public String guardar() {
           // VALIDACION
        String rsVal=super.validar();
        if(rsVal != null){
            return rsVal;
        }
        Document equipo = new Document("_id",new ObjectId());
        equipo.append("claseEquipo", getClaseEquipo());
        equipo.append("codigoPatrimonial", getCodigoPatrimonial());
        equipo.append("modelo", getModelo());
        equipo.append("marca", getMarca());
        equipo.append("estado", getEstado());
        equipo.append("observaciones", getObservaciones());
        equipo.append("ubicacionActual", getUbicacionActual());
        equipo.append("tipoTeclado", tipoTeclado);
        equipo.append("conexion", conexion);
        equipo.append("distribucion", distribucion);
        database.insertMongoDocument(equipo, Utils.Constant.equiposCollection);
        return null;
    }

}
