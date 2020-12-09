package Classes;

import static Interfaces.MantenimientoGuardar.database;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.types.ObjectId;

public class PC extends  Equipo{
    private String procesador; // INTEL O AMD 
    private String discoDuro; // GB
    private String ram; // GB

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public PC() {
    }

    @Override
    public void obtenerInformacion() {
         Document oData = this.database.getMongoCollection(
                 Utils.Constant.equiposCollection)
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
        this.setProcesador(oData.getString("procesador"));
        this.setDiscoDuro(oData.getString("discoDuro"));
        this.setRam(oData.getString("ram"));
    }

    @Override
    public String guardar() {
           // VALIDACION
        String rsVal=super.validar();
        if(rsVal != null){
            return rsVal;
        }
        if(procesador == null){
            return "Ingrese descripción de el procesador";
        }
         if(discoDuro == null){
            return "Ingrese capacidad de disco duro en gb";
        }
         if(ram == null){
            return "Ingrese capacidad de memoria Ram en gb";
        }
        Document equipo = new Document("_id",new ObjectId());
        equipo.append("claseEquipo", getClaseEquipo());
        equipo.append("codigoPatrimonial", getCodigoPatrimonial());
        equipo.append("modelo", getModelo());
        equipo.append("marca", getMarca());
        equipo.append("estado", getEstado());
        equipo.append("observaciones", getObservaciones());
        equipo.append("ubicacionActual", getUbicacionActual());
        equipo.append("procesador", procesador);
        equipo.append("discoDuro", discoDuro);
        equipo.append("ram", ram);
        database.insertMongoDocument(equipo, Utils.Constant.equiposCollection);
        return null;
    }

    
}
