
package PERSISTENCIA;

import LOGICA.Rol;
import LOGICA.Usuario;
import PERSISTENCIA.exceptions.NonexistentEntityException;
import java.util.List;


public class ControladorPersistencia {
    
    UsuarioJpaController usuJpa= new UsuarioJpaController();
    RolJpaController rolJpa= new RolJpaController();

    public List<Usuario> traerUsuarios() {
    
    return usuJpa.findUsuarioEntities();
    }

    public List<Rol> traerRoles() {
    return rolJpa.findRolEntities();
    }

    public void crearUsuario(Usuario usu) {
   
        usuJpa.create(usu);
    }

    public void borrarUsuario(int id_usuario) {
   
        try {
            usuJpa.destroy(id_usuario);
        } catch (NonexistentEntityException ex) {
            System.getLogger(ControladorPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public Usuario traerUsuario(int id_usuario) {
    
        return usuJpa.findUsuario(id_usuario);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            System.getLogger(ControladorPersistencia.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    
}
