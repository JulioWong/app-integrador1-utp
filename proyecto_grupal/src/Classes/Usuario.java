package Classes;

import Data.Database;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;

public class Usuario {
    private final Database database;
    
    private int usuarioId;
    private Facultad facultad;
    private final String usuario;
    private final String contrasena;

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = DigestUtils.md5Hex(contrasena);
        this.database = new Database();
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public Facultad getFacultad() {
        return facultad;
    }
      
    public Boolean login() {
        try {
            Document data = this.getUserByLogin(this.usuario, this.contrasena);
            if (!data.get("userId").toString().equals("")) {
                this.usuarioId = Integer.parseInt(data.get("userId").toString());
                this.facultad = new Facultad(
                        Integer.parseInt(data.get("facultadId").toString()));
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    private Document getUserByLogin(String usuario, String password) {
        return this.database.getMongoCollection(Utils.Constant.userCollection)
            .find(Filters.and(
                eq("user", usuario), 
                eq("password", password)
            )
        ).first();
    }
}