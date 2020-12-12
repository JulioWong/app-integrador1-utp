package Classes;

import static Interfaces.MantenimientoGuardar.database;
import Utils.StringBuilderPlus;
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

    @Override
    public void setTipoTeclado(String tipoTeclado) {
        this.tipoTeclado = tipoTeclado;
    }

    public String getConexion() {
        return conexion;
    }

    @Override
    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getDistribucion() {
        return distribucion;
    }

    @Override
    public void setDistribucion(String distribucion) {
        this.distribucion = distribucion;
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
        this.setTipoTeclado(oData.getString("tipoTeclado"));
        this.setConexion(oData.getString("conexion"));
        this.setDistribucion(oData.getString("distribucion"));
        
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
        Document equipo = new Document("_id",new ObjectId());
        equipo.append("claseEquipo", getClaseEquipo());
        equipo.append("codigoPatrimonial", getCodigoPatrimonial());
        equipo.append("modelo", getModelo());
        equipo.append("marca", getMarca());
        equipo.append("estado", getEstado());
        equipo.append("observaciones", getObservaciones());
        equipo.append("ubicacionActual", getDependencia().getDescripcion());
        equipo.append("tipoTeclado", tipoTeclado);
        equipo.append("conexion", conexion);
        equipo.append("distribucion", distribucion);
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
        sbInformacion.appendLine("Tipo de teclado: " + this.getTipoTeclado());
        sbInformacion.appendLine("Tipo conexión: " + this.getConexion());
        sbInformacion.appendLine("Distribución de teclas: " + this.getDistribucion());
        sbInformacion.appendLine("Estado: "
                + (this.getEstado() ? "Habilitado" : "Inhabilitado"));
        sbInformacion.appendLine("Observaciones: " + this.getObservaciones());  
        return sbInformacion.toString();
    }
}
