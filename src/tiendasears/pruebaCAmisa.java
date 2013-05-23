/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendasears;

import tiendasears.capaNegocio.Camisa;

/**
 *
 * @author sergio
 */
public class pruebaCAmisa {
    public static void main(String[] args) {
        Camisa camisanueva= new Camisa();
        camisanueva.setDescripcion("POLO");
        camisanueva.setPrecio(400);
        camisanueva.insertarCamisa();
    }
}
