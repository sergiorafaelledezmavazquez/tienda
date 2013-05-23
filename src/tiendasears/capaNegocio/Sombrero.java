/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendasears.capaNegocio;

/**
 *
 * @author sergio
 */
public class Sombrero extends Ropa{
    
   //1.-Atributos
    private String color;
   //2.-Metodo constructor
    public Sombrero(){
    }
   //3.-metodo set y get
   public void setColor(String dato){
       this.color=dato;
   } 
   public String getColor(){
       return this.color;
   }  
   //4.-Metodos del negocio
   public void imprimirInformacionSombrero(){
   //proceso
        String informacion ="---------------------------------------" + "\n" +
                            "id sombrero: " + super.getID() + "\n" + 
                            "precio: " + super.getPrecio() + "\n" +
                            "descripcion: " + super.getDescripcion() + "\n" +
                            "color: " + this.color + "\n"+
                            "---------------------------------------" + "\n";
                             
        System.out.println(informacion);
   } 
}
