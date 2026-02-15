
package PERSISTENCIA;

import LOGICA.Usuario;
import java.util.List;


public class ControladorPersistencia {
    
    UsuarioJpaController usuJpa= new UsuarioJpaController();

    public List<Usuario> traerUsuarios() {
    
    return usuJpa.findUsuarioEntities();
    }
}
