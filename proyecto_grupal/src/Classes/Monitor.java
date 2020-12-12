package Classes;

import Utils.StringBuilderPlus;
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

    @Override
    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    @Override
    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    @Override
    public void obtenerInformacion() {
        Document oData = this.database.getMongoCollection(
            Utils.Constant.equiposCollection).find(Filters.and(
             eq("codigoPatrimonial", this.getCodigoPatrimonial()),
             eq("claseEquipo", this.getClaseEquipo())
         )
        ).first();
        if(oData == null){
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
        
        Dependencia dependencia = new Dependencia(
                oData.getString("ubicacionActual"));
        this.setDependencia(dependencia);
    }

    @Override
    public String guardar() {
        String rsVal=super.validar();
        if(rsVal != null){
            return rsVal;
        }
        if(resolucion.isEmpty()){
            return "Ingrese resolución de pantalla en pulgadas";
        }
        Document equipo = new Document("equipoId",new ObjectId());
        equipo.append("claseEquipo", getClaseEquipo());
        equipo.append("codigoPatrimonial", getCodigoPatrimonial());
        equipo.append("modelo", getModelo());
        equipo.append("marca", getMarca());
        equipo.append("estado", getEstado());
        equipo.append("observaciones", getObservaciones());
        equipo.append("ubicacionActual", getDependencia().getDescripcion());
        equipo.append("resolucion", resolucion);
        equipo.append("tipoPantalla", tipoPantalla);
        database.insertMongoDocument(equipo, Utils.Constant.equiposCollection);
        return null;
    }

    @Override
    public String imprimirInformacion() {
        StringBuilderPlus sbInformacion = new StringBuilderPlus();
        sbInformacion.appendLine("Código Patrimonial: "
                + this.getCodigoPatrimonial());
        sbInformacion.appendLine("Dependendecia: "
                + this.getDependencia().getDescripcion());
        sbInformacion.appendLine("Marca: " + this.getMarca());
        sbInformacion.appendLine("Modelo: " + this.getModelo());
        sbInformacion.appendLine("Tipo de pantalla: " + this.getTipoPantalla());
        sbInformacion.appendLine("Resolución: " + this.getResolucion());
        sbInformacion.appendLine("Estado: " 
                + (this.getEstado() ? "Habilitado" : "Inhabilitado"));
        sbInformacion.appendLine("Observaciones: " + this.getObservaciones());    
        return sbInformacion.toString();
    }
}
