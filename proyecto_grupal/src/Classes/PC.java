package Classes;

import static Interfaces.MantenimientoGuardar.database;
import Utils.StringBuilderPlus;
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

    @Override
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getDiscoDuro() {
        return discoDuro;
    }

    @Override
    public void setDiscoDuro(String discoDuro) {
        this.discoDuro = discoDuro;
    }

    public String getRam() {
        return ram;
    }

    @Override
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
        
        Dependencia dependencia = new Dependencia(
                oData.getString("ubicacionActual"));
        this.setDependencia(dependencia);
    }

    @Override
    public String guardar() {
           // VALIDACION
        String rsVal=super.validar();
        if(rsVal != null){
            return rsVal;
        }
        if(procesador.isEmpty()){
            return "Ingrese descripción de el procesador";
        }
         if(discoDuro.isEmpty()){
            return "Ingrese capacidad de disco duro en gb";
        }
         if(ram.isEmpty()){
            return "Ingrese capacidad de memoria Ram en gb";
        }
        Document equipo = new Document("_id",new ObjectId());
        equipo.append("claseEquipo", getClaseEquipo());
        equipo.append("codigoPatrimonial", getCodigoPatrimonial());
        equipo.append("modelo", getModelo());
        equipo.append("marca", getMarca());
        equipo.append("estado", getEstado());
        equipo.append("observaciones", getObservaciones());
        equipo.append("ubicacionActual", getDependencia().getDescripcion());
        equipo.append("procesador", procesador);
        equipo.append("discoDuro", discoDuro);
        equipo.append("ram", ram);
        database.insertMongoDocument(equipo, Utils.Constant.equiposCollection);
        return null;
    }

    @Override
    public String imprimirInformacion() {
        StringBuilderPlus sbInformacion = new StringBuilderPlus();
        sbInformacion.appendLine("Código Patrimonial: "+ this.getCodigoPatrimonial());
        sbInformacion.appendLine("Marca: "+this.getMarca());
        sbInformacion.appendLine("Modelo: "+this.getModelo());
        sbInformacion.appendLine("Procesador: "+this.getProcesador());
        sbInformacion.appendLine("Capacidad de disco: "+this.getDiscoDuro());
        sbInformacion.appendLine("Capacidad de Ram: "+this.getRam());
        sbInformacion.appendLine("Estado: "+(this.getEstado()?"Habilitado":"Inhabilitado"));
        sbInformacion.appendLine("Observaciones: "+this.getObservaciones());   
        return sbInformacion.toString();
    }
}
