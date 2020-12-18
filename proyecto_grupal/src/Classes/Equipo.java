package Classes;

import Interfaces.MantenimientoObtener;
import Interfaces.MantenimientoGuardar;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.conversions.Bson;

public abstract class Equipo implements 
        MantenimientoGuardar, MantenimientoObtener{

    private String codigoPatrimonial;
    private String claseEquipo;
    private String modelo;
    private String marca;
    private String observaciones;
    private Boolean estado;
    private final ArrayList<DocumentoTransferencia> 
            transferencias = new ArrayList<>();
    private Dependencia dependencia;

    public Equipo() {
    }

    public String getCodigoPatrimonial() {
        return codigoPatrimonial;
    }
    
    public void setCodigoPatrimonial(String codigoPatrimonial) {
        this.codigoPatrimonial = codigoPatrimonial;
    }
    
    public String getClaseEquipo() {
        return claseEquipo;
    }

    public void setClaseEquipo(String claseEquipo) {
        this.claseEquipo = claseEquipo;
    }

    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getEstado() {
        return estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public void setDependencia(Dependencia dependencia) {
        this.dependencia = dependencia;
    }

    public ArrayList<DocumentoTransferencia> getTransferencias() {
        
        try {
            FindIterable<Document> data = this.database.getMongoCollection
                (Utils.Constant.documentoTransferenciaCollection)
                    .find(Filters.and(
                            eq("codigoPatrimonial", this.codigoPatrimonial)
                ));
            
            for (Document document : data) {
                DocumentoTransferencia oTransferencia = 
                        new DocumentoTransferencia();
                
                oTransferencia.setDependenciaOrigen(
                    new Dependencia(document.getString("dependenciaOrigen")));
                oTransferencia.setDependenciaDestino(
                    new Dependencia(document.getString("dependenciaDestino")));
                oTransferencia.setDocumentoAutorizacion(
                        document.getString("documentoAutorizacion"));
                oTransferencia.setFecha(document.getString("fecha"));
                
                ArrayList<Equipo> equipos = new ArrayList<>();
                equipos.add(this);
                oTransferencia.setEquipos(equipos);
                oTransferencia.setMotivo(document.getString("motivo"));
                
                this.transferencias.add(oTransferencia);
            }
        } catch (Exception e) { }
        return transferencias;
    }
    
    public abstract String imprimirInformacion();
    
    public String validar(){
        if(this.codigoPatrimonial.isEmpty()){
            return "Ingrese codigo patrimonial";
        }
        if(this.marca.isEmpty()){
            return "Ingrese Marca";
        }
        if(this.modelo.isEmpty()){
            return "Ingrese Modelo";
        }
        if(this.dependencia.getDescripcion().isEmpty()){
            return "Seleccione ubicación actual.";
        }
        Document oData = this.database.getMongoCollection(
                Utils.Constant.equiposCollection).find(Filters.and(
                eq("codigoPatrimonial", this.getCodigoPatrimonial())
            )
        ).first();
        
        if(oData != null){
            return "Ya existe un equipo registrado con el codigo patrimonial " 
                    + getCodigoPatrimonial();
        }
        return null;
    }
    
    public Boolean actualizarDependenciaActual(Dependencia dependencia) {
        try {
            Document data = this.database.getMongoCollection(
                    Utils.Constant.equiposCollection)
            .find(Filters.and(
                eq("codigoPatrimonial", this.getCodigoPatrimonial()), 
                eq("claseEquipo", this.getClaseEquipo())
                )
            ).first();
            if (data != null) {
                Bson updateValue  = new Document("ubicacionActual",
                    dependencia.getDescripcion());
            
                Bson updateOperation  = new Document("$set", updateValue);
            
                Boolean resultUpdate = this.database.updateMongoDocument(
                    data, updateOperation, Utils.Constant.equiposCollection);
                return resultUpdate;
            }
            
        } catch (Exception e) {
            
        }
        return false;
    }

    
    
    
    
    public void setTipo(String toString) {
        
    }

    public void setImpresionColor(Boolean impresionColor) {
        
    }

    public void setResolucion(String text) {
        
    }

    public void setTipoPantalla(String toString) {
        
    }

    public void setProcesador(String text) {
        
    }

    public void setDiscoDuro(String text) {
        
    }

    public void setRam(String text) {
        
    }

    public void setContraste(String toString) {
        
    }

    public void setTecnologia(String toString) {
        
    }

    public void setConexion(String toString) {
        
    }

    public void setTipoTeclado(String toString) {
        
    }

    public void setDistribucion(String toString) {
        
    }
    
}
