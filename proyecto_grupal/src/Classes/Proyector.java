package Classes;

import static Interfaces.MantenimientoGuardar.database;
import Utils.StringBuilderPlus;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Proyector extends Equipo {

    private String tecnologia;// DLP O LCD
    private String contraste; // NATIVO O DINAMICO
    private String resolucion; // ALTA O BAJA

    @Override
    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    @Override
    public void setContraste(String contraste) {
        this.contraste = contraste;
    }

    @Override
    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    
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
        this.setTecnologia(oData.getString("tecnologia"));
        this.setContraste(oData.getString("contraste"));
        this.setResolucion(oData.getString("resolucion"));
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
        equipo.append("ubicacionActual", getDependencia().getDescripcion());
        equipo.append("tecnologia", tecnologia);
        equipo.append("contraste", contraste);
        equipo.append("resolucion", resolucion);
        database.insertMongoDocument(equipo, Utils.Constant.equiposCollection);
        return null;
    }
    
    @Override
    public String imprimirInformacion() {
        StringBuilderPlus sbInformacion = new StringBuilderPlus();
        sbInformacion.appendLine("Código Patrimonial: "+ this.getCodigoPatrimonial());
        sbInformacion.appendLine("Marca: "+this.getMarca());
        sbInformacion.appendLine("Modelo: "+this.getModelo());
        sbInformacion.appendLine("Tecnología: "+this.getTecnologia());
        sbInformacion.appendLine("Contraste: "+this.getContraste());
        sbInformacion.appendLine("Resolución: "+this.getResolucion());
        sbInformacion.appendLine("Estado: "+(this.getEstado()?"Habilitado":"Inhabilitado"));
        sbInformacion.appendLine("Observaciones: "+this.getObservaciones());   
        return sbInformacion.toString();
    }
}
