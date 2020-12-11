
package Classes;

import Interfaces.MantenimientoGuardar;
import static Interfaces.MantenimientoGuardar.database;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

public class DocumentoTransferencia implements MantenimientoGuardar{
    
    public String documentoAutorizacion;
    public Dependencia dependenciaOrigen;
    public Dependencia dependenciaDestino;
    public ArrayList<Equipo> equipos = new ArrayList<>();
    public Usuario usuario;
    public String motivo;
    public String fecha;

    public DocumentoTransferencia() {
    }
    
    public void setDocumentoAutorizacion(String documentoAutorizacion) {
        this.documentoAutorizacion = documentoAutorizacion;
    }

    public void setDependenciaOrigen(Dependencia dependenciaOrigen) {
        this.dependenciaOrigen = dependenciaOrigen;
    }

    public void setDependenciaDestino(Dependencia dependenciaDestino) {
        this.dependenciaDestino = dependenciaDestino;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDocumentoAutorizacion() {
        return documentoAutorizacion;
    }

    public Dependencia getDependenciaOrigen() {
        return dependenciaOrigen;
    }

    public Dependencia getDependenciaDestino() {
        return dependenciaDestino;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public void agregarEquipo(Equipo equipo){
        this.equipos.add(equipo);
    }

    @Override
    public String guardar() {
        ArrayList<Equipo> eq = getEquipos();
        for (int i = 0; i < eq.size(); i++) {
            Document documentoTransferencia = new Document("_id", new ObjectId());
            documentoTransferencia.append("dependenciaOrigen", 
                eq.get(i).getDependencia().getDescripcion());
            documentoTransferencia.append("dependenciaDestino", 
                    getDependenciaDestino().getDescripcion());
            documentoTransferencia.append("documentoAutorizacion", 
                    getDocumentoAutorizacion());
            documentoTransferencia.append("codigoPatrimonial", 
                eq.get(i).getCodigoPatrimonial());
            documentoTransferencia.append("claseEquipo",
                    eq.get(i).getClaseEquipo());
            documentoTransferencia.append("modelo", eq.get(i).getModelo());
            documentoTransferencia.append("motivo", getMotivo());
             documentoTransferencia.append("fecha", getFecha());
            database.insertMongoDocument(documentoTransferencia, 
                    Utils.Constant.documentoTransferenciaCollection);
            eq.get(i).actualizarDependenciaActual(getDependenciaDestino());
        }
        return "";
    }
}
