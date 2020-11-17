package Classes;

import Data.UsuarioModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;

public class Usuario {
    private int userId;
    private final Facultad facultad;
    private final String usuario;
    private final String contrasena;
    private final UsuarioModel usuarioModel;

    public Usuario(Facultad facultad, String usuario, String contrasena) {
        this.facultad = facultad;
        this.usuario = usuario;
        this.contrasena = DigestUtils.md5Hex(contrasena);
        this.usuarioModel = new UsuarioModel();
    }

    public int getUserId() {
        return userId;
    }
    
    public Boolean login() {
        try {
            Document usuario = this.usuarioModel.getUserByLogin(
            facultad.getFacultadId(), this.usuario, this.contrasena);
            if (!usuario.get("userId").toString().equals("")) {
                this.userId = Integer.parseInt(usuario.get("userId").toString());
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}