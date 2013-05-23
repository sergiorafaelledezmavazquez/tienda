/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendasears.capaNegocio;


import tiendasears.capaDatos.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author sergio
 * 
 * Nota 6 nov 2012 : Es muy practico tener un metodos que te regresen los atributos en forma de vector, arreglo y tal vez hasta archivo de texto 
 */
//modificador /class/ nombre de la clase
public class Camisa extends Ropa{
   ///PASO 1:
    //atributos, descripcion de mi objeto, variables globales
 
   private int tam=0;
   private String color="";
  
   
   
   //estas variables las uso para obtener todos los atributos
   public String[] atributos  = new String[5]; 
   //public Vector vector = new Vector();
   //PASO2 METODOS CONSTRUCTORES
   //metodo constructor por default
      public Camisa(){
          
      }
   //metodo constructor 1
                   //datos de entrada
   public Camisa( int tam, String color){
     this.color=color;
     this.tam= tam;
   }
   //metodos set y get "encapsulacion"
  
   public void setTam(int dato){
       this.tam=dato;
   }
   public void setColor(String dato){
       if(dato.equals("verde") || dato.equals("rojo")|| dato.equals("azul")  ){
            this.color=dato;
       }
       else{
           JOptionPane.showMessageDialog(null, "el color debe ser verde, azul o rojo");
       
       }
   }
  
  
   public int getTam(){
       return this.tam;
   }
   public String getColor(){
       return this.color;
   }
  
    //operaciones de mi objeto    (metodos o funciones)
    //modificador / tipo de devolucion o datos de salida / nombre del metodo / (datos de entrada)
    public void desplegarInformacion(){
        
    JOptionPane.showMessageDialog(null, "id camisa: " + super.getID() + "\n" + 
                                        "precio: " + super.getPrecio() + "\n" +
                                        "tamaño: " + this.tam + "\n" +
                                        "color: " + this.color + "\n" +
                                        "descripcion: " + super.getDescripcion()+"\n"+
                                        "temporada: " + super.getTemporada()
                                          );
    }  
    
    @Override
    public String obtenerInformacion(){
        //proceso
        String informacion =  "---------------------------------------" + "\n" +
                              "id camisa: " + super.getID() + "\n" + 
                              "precio: " + super.getPrecio() + "\n" +
                              "tamaño: " + this.tam + "\n" +
                              "color: " + this.color + "\n" +
                              "descripcion: " + super.getDescripcion() + "\n"+
                              "temporada: " + super.getTemporada() + "\n" +
                              "---------------------------------------";
        
        //salida
        
        return informacion;      
    
    }
   public void imprimirInformacionCamisa(){
       //proceso
        String informacion =  "---------------------------------------" + "\n" +
                              "id camisa: " + super.getID() + "\n" + 
                              "precio: " + super.getPrecio() + "\n" +
                              "tamaño: " + this.tam + "\n" +
                              "color: " + this.color + "\n" +
                              "descripcion: " + super.getDescripcion() + "\n"+
                              "temporada: " + super.getTemporada() +"\n" +
                              "---------------------------------------" +"\n";
        System.out.println(informacion);
        
   }
    
    public void obtenerInformacionenVector(){
         
    
    }
    
    public String[] obtenerInformacionenArreglo(){
        atributos[0]=String.valueOf(super.getID()); 
        atributos[1]=super.getDescripcion();
        atributos[2]=this.color;
        atributos[3]=String.valueOf(super.getPrecio()); 
        atributos[4]=String.valueOf(this.tam);
        return atributos;
    }
    
//insertar camisa en una base de datos
    public boolean insertarCamisa(){
       try {
           System.out.println(Conexion.hacerConexion());
           

           String mySQL= "INSERT INTO tblropa(descripcion, precio, cantidad , color, tam, genero, temporada, tipoproducto) "
                                  + "VALUES("+ "'" + super.getDescripcion() + "'," + super.getPrecio() + ","+ super.getCantidad()+"," + "'" + this.getColor()+ "',"+ this.getTam()+",'NO APLICA'"+ ",'" + this.getTemporada()+ "'" + ",'camisa'" +  ")";                             
           // System.out.println(mySQL);
          Conexion.ejecutarActualizacionSQL( mySQL  );
          
          Conexion.cerrarConexion();
              
           return true;
       } catch (Exception ex) {
          
           return false;
       }
    }
 //borrar camisa de la base de datos 
        public boolean borrarCamisa(){
                try {
                    System.out.println(Conexion.hacerConexion());
                    String mySQL= "DELETE FROM tblropa WHERE id ="+ this.getID() ; 
                                                             
                    // System.out.println(mySQL);
                    Conexion.ejecutarActualizacionSQL( mySQL  );
                    Conexion.cerrarConexion();
                    return true;
                } catch (Exception ex) {
                    return false;
                }
        
        }
     public boolean modificarCamisa(){
        try {
                    System.out.println(Conexion.hacerConexion());
                    String mySQL= "UPDATE tblropa SET " +
                                  "cantidad = " + this.getCantidad() +
                                  ",color = " + "'" + this.getColor() +"'" +
                                  ",descripcion = " +"'"+ this.getDescripcion()+ "'" +
                                  ",precio = " + this.getPrecio() +
                                  ",tam = " + this.getTam() +
                                  ",temporada = " +"'" +this.getTemporada() + "'" +
                                  ",tipoproducto = " + "'camisa'" +
                                  " WHERE id = " + this.getID(); 
                                                             
                    // System.out.println(mySQL);
                    Conexion.ejecutarActualizacionSQL(mySQL);
                    Conexion.cerrarConexion();
                    return true;
                } catch (Exception ex) {
                    return false;
                }
        
        
        
     }
    
    
}
