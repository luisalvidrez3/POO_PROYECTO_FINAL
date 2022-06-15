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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author luisa
 */

public class Nieve extends Producto {
     
    private String sabor;

    public Nieve() {
         boolean datoErroneo = true;
         do{
       
        
        try{
        Scanner input = new Scanner (System.in);
        System.out.println("Inserte el sabor");
       sabor = input.nextLine();
         datoErroneo = false;
         }catch(InputMismatchException e){
            System.out.println( "Introdujise un dato no valido");
        }
      
          }while(datoErroneo);
      
    }

    public Nieve(String sabor , int precio, String cantidad, int codigo) {
        super( precio,codigo);
        this.sabor = sabor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
   
  public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch = new FileOutputStream("nieve.txt");
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
            FileInputStream abrirArch = new FileInputStream("nieve.txt");
            ObjectInputStream leerObjeto = new ObjectInputStream(abrirArch); 
          ArrayList<Nieve> miLista= (ArrayList<Nieve>)leerObjeto.readObject();
          for(int i = 0;i< miLista.size(); i ++){
             Nieve nieve =miLista.get(i);
            System.out.println("Nieve: "+ "Precio: " + nieve.getPrecio()+" Codigo: " + nieve.getCodigo()+ " Sabor: " + nieve.getSabor());
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
    

  

