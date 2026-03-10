
package LOGICA;

import PERSISTENCIA.ControladorPersistencia;
import java.util.List;

public class Controladora {
    
    ControladorPersistencia controlPersis= new ControladorPersistencia();

    public Usuario validarUsuario(String usuario, String contrasenia) {
   
      //  String mensaje="";
      Usuario usr= null;
        List<Usuario> listaUsuarios= controlPersis.traerUsuarios();
    
       for (Usuario usu : listaUsuarios ){
           
           if(usu.getNombreUsuario().equals(usuario)){
               if(usu.getContrasenia().equals(contrasenia)){
              //     mensaje="Usuario y Contraseña correctos";
               usr=usu;
              return usr;
               
               }
               else {
                   //mensaje="Contraseña incorrecta "  ;
                  usr=null;
                  return usr;
               }
           }else {
               //mensaje="Usuario no encontrado " ;
               usr=null;
           }
       
       }
       
return usr;
    }

    public List<Usuario> traerUsuarios() {
        
      
       return controlPersis.traerUsuarios();
    }

}

