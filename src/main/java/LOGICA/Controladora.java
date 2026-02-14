
package LOGICA;

import PERSISTENCIA.ControladorPersistencia;
import java.util.List;

public class Controladora {
    
    ControladorPersistencia controlPersis= new ControladorPersistencia();

    public String validarUsuario(String usuario, String contrasenia) {
   
        String mensaje="";
        List<Usuario> listaUsuarios= controlPersis.traerUsuarios();
    
       for (Usuario usu : listaUsuarios ){
           
           if(usu.getNombreUsuario().equals(usuario)){
               if(usu.getContraseña().equals(contrasenia)){
                   mensaje="Usuario y Contraseña correctos";
                   return mensaje;
               
               }
               else {
                   mensaje="Contraseña incorrecta "  ;
                  
               }
           }else {
               mensaje="Usuario no encontrado " ;
               
           }
       
       }
       
return mensaje;
    }

}

