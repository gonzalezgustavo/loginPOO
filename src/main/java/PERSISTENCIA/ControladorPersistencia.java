
package PERSISTENCIA;

import LOGICA.Usuario;
import java.util.List;


public class ControladorPersistencia {
    
    UsuarioJpaController usuJpa= new UsuarioJpaController();
    RolJpaController rolJpa= new RolJpaController();

    public List<Usuario> traerUsuarios() {
    
    return usuJpa.findUsuarioEntities();
    }
    
    
}
