/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendasears;

import tiendasears.capaDatos.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergio
 */
public class pruebaConexion {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            System.out.println(Conexion.hacerConexion());
        } catch (Exception ex) {
            Logger.getLogger(pruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        String mySQL= "INSERT INTO tblproductos(descripcion, precio, cantidad , color, tam, genero) "
                               + "VALUES( 'cecyteg', 500, 1000 ,'blanco' , 30, 'masculino') ";
        Conexion.ejecutarActualizacionSQL( mySQL  );
       
       
        
        Conexion.cerrarConexion();
       
       
        
    }
}
