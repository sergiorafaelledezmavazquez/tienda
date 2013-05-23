/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendasears;

import tiendasears.capaNegocio.Sombrero;
import tiendasears.capaNegocio.Pantalon;
import tiendasears.capaNegocio.Catalogo;
import tiendasears.capaNegocio.Camisa;

/**
 *
 * @author sergio
 */
public class pruebaCatalogo {
    public static void main(String[] args) {
      
      Catalogo catalogo = new Catalogo();
      
      //hacer conexion
      catalogo.obtenerInformacion("camisa");
      
      
    }
}
