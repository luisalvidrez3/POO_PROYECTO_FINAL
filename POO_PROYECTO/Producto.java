/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_avance_codigo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author luisa
 */
public class Producto implements Serializable {
   
  
    private double precio;
  
    private int codigo;

    public Producto() { 
          boolean datoErroneo = true;
         do{
       
        
        try{
        Scanner input= new Scanner(System.in);
         System.out.println("Inserte el precio");
       precio = input.nextDouble();
       input.nextLine();
       
       System.out.println("Inserte el codigo del producto");
       codigo = input.nextInt();
       input.nextLine();
       datoErroneo = false;
          }catch(InputMismatchException e){
            System.out.println( "Introdujise un dato no valido");
        }
        
          }while(datoErroneo);
    }

    public Producto( int precio,  int codigo) {
       
        this.precio = precio;
        this.codigo = codigo;
    }

  

   
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

  

   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
     public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch = new FileOutputStream("producto.txt");
            ObjectOutputStream guardarObj = new ObjectOutputStream(abrirArch); 
            guardarObj.writeObject(obj);
            guardarObj.flush();
            guardarObj.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
     
     }
      public void leerObj(Object obj){
        try {
            FileInputStream abrirArch = new FileInputStream("producto.txt");
            ObjectInputStream leerObjeto = new ObjectInputStream(abrirArch); 
          ArrayList<Producto> miLista= (ArrayList<Producto>)leerObjeto.readObject();
          for(int i = 0;i< miLista.size(); i ++){
              Producto producto =miLista.get(i);
            System.out.println("Precio: " + producto.getPrecio()+" Codigo: " + producto.getCodigo());
        }
            leerObjeto.close();
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
           ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        }
        
    }
      
       
    
    

   
}
