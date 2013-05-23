/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendasears.capaNegocio;

/**
 *
 * @author sergio
 */
public class Ropa {
    //1.-atributos
    private int id=0;
    private String descripcion="";
    private double precio= 0.0;
    private int cantidad = 0;
     private String temporada="";
    
    //atributo especial para generar ID
    public static int ID_unico=0;  
    
    //2.-metodos constructor
    public Ropa(){
        this.id= ID_unico++;
   } 
    
    //3.-Encapsulacion de los atributos  (metodos get y set)
//    public void setID(int dato){
//        this.id = dato;
//    }
    public void setDescripcion(String dato){
        this.descripcion=dato;
    } 
      public void setPrecio(double dato){
        this.precio=dato;
    } 
      public void setCantidad(int dato){
        this.cantidad=dato;
    }   
   public void setTemporada(String dato){
       this.temporada=dato;
   }
    public void setID(int id){
         this.id = id;
     } 
   public String getTemporada(){
       return this.temporada;
   }
     public int getID(){
         return this.id;
     } 
     public String getDescripcion(){
         return this.descripcion;
     }
     public double getPrecio(){
         return this.precio;
     }
     public int getCantidad(){
         return this.cantidad;
     }
     
    //4.-metodos del negocio
      
     public String obtenerInformacion(){
        //proceso
        String informacion =  "id camisa: " + this.id + "\n" + 
                                        "precio: " + this.precio + "\n" +
                                        "cantidad: " + this.cantidad + "\n" +
                                        "descripcion: " + this.descripcion;   
        //salida
        return informacion;      
    }
     
     
     
}
