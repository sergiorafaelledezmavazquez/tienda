/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendasears.capaNegocio;
import tiendasears.capaDatos.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import tiendasears.capaNegocio.Camisa;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sergio
 * Nota 6 nov 2012: este programa lo hice con arreglos pero quedaria mejor con vectores
 * Nota 9 mayo 2013: me di cuenta que el catalogo en realidad es un vista o consuta SQL 
 * y lo unico que are es mostrar estas consultas en una tabla
 */
public class Catalogo {
    //atributos
    public String temporada="";
    public int cantidadDeProductos=0;
    //para poder guardar Camisas, Pantalon y Sombreros en mi arreglo 
    public Ropa[] arreglo = new Ropa[100];
     
    
    //contructor
    public Catalogo(){}
    //********************METODOS DEL NEGOCIO****************************************************
    
    //metodo 1 : para obtener informacion de la base de datos de tblropa y ponerla en un JTable
     public  DefaultTableModel obtenerInformacion(String tipoproducto){
      //creo objeto tipo tabla
       DefaultTableModel tablaCatalogo= new DefaultTableModel();
      //consulta sql
      String consulta="SELECT * FROM tblropa WHERE tipoproducto =" + "'" + tipoproducto + "'";
      //creo objeto para obtener consulta
        try {
         
            System.out.println(Conexion.hacerConexion());
          
            ResultSet rs = Conexion.ejecutaConsultaSQL(consulta);
        
            //Obteniendo la informacion de las columnas que estan siendo consultadas
            ResultSetMetaData rsMd = rs.getMetaData();
            //La cantidad de columnas que tiene la consulta
            int cantidadColumnas = rsMd.getColumnCount();
            //Establecer como cabezeras el nombre de las colimnas
            for (int i = 1; i <= cantidadColumnas; i++) {
            tablaCatalogo.addColumn(rsMd.getColumnLabel(i));
            }
            //Creando las filas para el JTable
            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i]=rs.getObject(i+1);
                }
                tablaCatalogo.addRow(fila);
            }
          
            Conexion.cerrarConexion();
         
        } catch (SQLException ex) {
            ex.printStackTrace();
          
        } catch (Exception ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      
      
      
      return tablaCatalogo;  
        
     }  
    
    
//    public void imprimirProductos(){
//        for(int i=0; i< this.cantidadDeProductos; i++ ){
//            //if para preguntar si lo que esta guardado es una Camisa
//           
//            if (arreglo[i] instanceof Camisa){
//              //hacemos el casting del contenido del arreglo y lo guardo en un objeto camisa
//                Camisa miCamisa= (Camisa)arreglo[i];
//                miCamisa.imprimirInformacionCamisa();    
//            } 
//            
//            if (arreglo[i] instanceof Pantalon){
//                Pantalon miPantalon=(Pantalon)arreglo[i]; 
//                miPantalon.imprimirInformacionPantalon();
//            }
//            
//            if (arreglo[i] instanceof Sombrero){
//                Sombrero miSombrero =(Sombrero)arreglo[i];
//                miSombrero.imprimirInformacionSombrero();
//            
//            } 
//        
//        }
//    
//    }    
//    public void agregarProductoAlCatologo(Ropa ropaNueva){
//       //valido para que no sobrepase el tamaño del arreglo
//        if (cantidadDeProductos<=99){                            
//            arreglo[cantidadDeProductos]=ropaNueva;
//            cantidadDeProductos=cantidadDeProductos+1;
//        
//        }
//        else{
//            JOptionPane.showMessageDialog(null,"El Catalogo esta completo");    
//        }
//    }
//    public void borrarCamisaDelCatalogo(int ID){
//        //for para buscar la camisa que borrare
//        for(int i=0; i<cantidadDeProductos; i++){
//            if(arreglo[i] != null){ 
//                if(ID == arreglo[i].getID()){
//                    arreglo[i]=null; 
//                    JOptionPane.showMessageDialog(null, "El producto a sido eliminado del catalogo");
//                }
//            }    
//        }
//        
//        
//    }
//    public void modificarProductoDelCatalogo(int ID, Ropa ropaNueva){
//            //for para buscar la camisa que borrare
//            for(int i=0; i<cantidadDeProductos; i++){
//                if(ID == arreglo[i].getID()){
//                    arreglo[i]=ropaNueva; 
//                    JOptionPane.showMessageDialog(null, "Los datos del producto han sido  modificados en el catalogo");
//            } 
//        }
//    
//    
//    }
//    //esto codigo es regresa una tabla
//    public DefaultTableModel DatosDelCatalogo(){
//        //creo un modelo en blanco : 
//         DefaultTableModel modelo = new DefaultTableModel(); 
//         Object[] renglon = new Object[6];  
//                        //agrego los nombre de las columnas padre
//                        modelo.addColumn("ID"); 
//                        modelo.addColumn("Descripcion");
//                        modelo.addColumn("Precio");
//                        modelo.addColumn("Cantidad");
//                        //hijos
//                        modelo.addColumn("Color");
//                        modelo.addColumn("tamaño");
//
//        //pregunto el tipo de dato 
//         for (int i=0;i<=this.cantidadDeProductos;i++){
//            if (this.arreglo[i] != null){
//                //pregunto si es una camisa
//                if (this.arreglo[i] instanceof Camisa){
//                       
//                        renglon[0] = this.arreglo[i].getID();
//                        renglon[1] = this.arreglo[i].getDescripcion();
//                        renglon[2] = this.arreglo[i].getPrecio();
//                        renglon[3] = this.arreglo[i].getCantidad();
//                        //casting para poder acceder a los metodos de Camisa
//                        renglon[4] = ((Camisa)this.arreglo[i]).getColor(); 
//                        modelo.addRow(renglon);
//
//                } 
//                //pregunto si es un pantalon
//                if (this.arreglo[i] instanceof Pantalon){
//                     
//
//                }
//                //pregunto si es un sombrero
//                if (this.arreglo[i] instanceof Sombrero){
//
//
//                } 
//            }
//         
//         
//         }
//         
//           
//        return modelo;
//    
//    } 
    
    
    
    
    
    
}
