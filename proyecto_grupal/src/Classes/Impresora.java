package Classes;

import static Interfaces.MantenimientoGuardar.database;
import Utils.StringBuilderPlus;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Impresora extends Equipo{

    private String tipo;
    private Boolean impresionColor;

    public Impresora() {
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getImpresionColor() {
        return impresionColor;
    }

    @Override
    public void setImpresionColor(Boolean impresionColor) {
        this.impresionColor = impresionColor;
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
        this.setTipo(oData.getString("tipo"));
        this.setImpresionColor(oData.getBoolean("impresionColor"));
        this.setEstado(oData.getBoolean("estado"));
        this.setObservaciones(oData.getString("observaciones"));
        
    }

    @Override
    public String guardar() {
        // VALIDACION
        String rsVal=super.validar();
        if(rsVal != null){
            return rsVal;
        }
        if(tipo.contains("[")){
            return "Seleccione el tipo de impresora";
        }
        Document equipo = new Document("_id",new ObjectId());
        equipo.append("claseEquipo", getClaseEquipo());
        equipo.append("codigoPatrimonial", getCodigoPatrimonial());
        equipo.append("modelo", getModelo());
        equipo.append("marca", getMarca());
        equipo.append("estado", getEstado());
        equipo.append("observaciones", getObservaciones());
        equipo.append("ubicacionActual", getDependencia().getDescripcion());
        equipo.append("tipo", tipo);
        equipo.append("impresionColor", impresionColor);
        database.insertMongoDocument(equipo, Utils.Constant.equiposCollection);
        return null;
    }

    @Override
    public String imprimirInformacion() {
        StringBuilderPlus sbInformacion = new StringBuilderPlus();
        sbInformacion.appendLine("Código Patrimonial: "+ this.getCodigoPatrimonial());
        sbInformacion.appendLine("Marca: "+this.getMarca());
        sbInformacion.appendLine("Modelo: "+this.getModelo());
        sbInformacion.appendLine("Tipo de impresora: "+this.getTipo());
        sbInformacion.appendLine("Imprime a color: "+(this.getImpresionColor()?"SI":"NO"));
        sbInformacion.appendLine("Estado: "+(this.getEstado()?"Habilitado":"Inhabilitado"));
        sbInformacion.appendLine("Observaciones: "+this.getObservaciones());    
        return sbInformacion.toString();
    }
}
