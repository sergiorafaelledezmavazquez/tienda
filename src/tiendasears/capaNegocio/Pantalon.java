/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendasears.capaNegocio;

import javax.swing.JOptionPane;

/**
 *
 * @author sergio
 */
public class Pantalon extends Ropa {
    //1.-atributos
    private int tam=0;
    private String color="";
    private String genero="";         
    //2.-Constructores
    public Pantalon (){
    }
    //3.-encapsulacion (metodos set y get)
    public void setTam(int dato){
        this.tam=dato;
    }
    public void setColor(String dato){
        if (dato.equals("azul") || dato.equals("AZUL") || dato.equals("naranja") || dato.equals("NARANJA")){
            this.color=dato;
        }
        else{
            JOptionPane.showMessageDialog(null, "el color no es valido");        
        }
        
    }
    public void setGenero(String dato){
        if (dato.equals("M")||dato.equals("F")||dato.equals("MASCULINO")||dato.equals("FEMENINO") ){
            this.genero=dato;
        }    
        else{
            JOptionPane.showMessageDialog(null, "El genero no es valido");
        }
    }
    
    public int getTam(){
        return this.tam;
    }
    public String getColor(){
        return this.color;
    
    }  
    public String getGenero(){
        return this.genero;
    }
    
    //4.-metodos del negocio
    @Override
     public String obtenerInformacion(){
        //proceso
        String informacion =            "id:" + super.getID()   + "\n" + 
                                        "precio: " + super.getPrecio() + "\n" +
                                        "tamaño: " + this.tam + "\n" +
                                        "descripcion: " + super.getDescripcion() +"\n" +
                                        "color:" + this.color +"\n" +
                                        "genero:" +this.genero;
        
        //salida
        
        return informacion;      
    
    }
     public void imprimirInformacionPantalon(){
          //proceso
        String informacion =  "---------------------------------------" + "\n" +
                                        "id:" + super.getID()   + "\n" + 
                                        "precio: " + super.getPrecio() + "\n" +
                                        "tamaño: " + this.tam + "\n" +
                                        "descripcion: " + super.getDescripcion() +"\n" +
                                        "color:" + this.color +"\n" +
                                        "genero:" +this.genero+ "\n"+
                               "---------------------------------------" + "\n";
        //salida
        System.out.println(informacion);
     
     }
    
    
}
