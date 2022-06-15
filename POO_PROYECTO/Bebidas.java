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
public class Bebidas extends Producto {
    private String marca;
    private String sabor;
        
    public Bebidas() {
        boolean datoErroneo = true;
         do{
       
        
        try{
        Scanner input = new Scanner(System.in);
         System.out.println("Inserte el sabor");
       sabor = input.nextLine();
       System.out.println("Inserte la marca");
       marca = input.nextLine();
       datoErroneo = false;
        }catch(InputMismatchException e){
            System.out.println( "Introdujise un dato no valido");
        }
        
          }while(datoErroneo);
    }

   

    public Bebidas(String marca, String sabor, int precio, int codigo) {
        super( precio, codigo);
        this.marca = marca;
        this.sabor = sabor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

   
   public void escribirObj(Object obj){
        try {
            FileOutputStream abrirArch = new FileOutputStream("bebida.txt");
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
            FileInputStream abrirArch = new FileInputStream("bebida.txt");
            ObjectInputStream leerObjeto = new ObjectInputStream(abrirArch); 
          ArrayList<Bebidas> miLista= (ArrayList<Bebidas>)leerObjeto.readObject();
          for(int i = 0;i< miLista.size(); i ++){
             Bebidas bebida =miLista.get(i);
            System.out.println("Bebida: "+"Precio: " + bebida.getPrecio()+" Codigo: " + bebida.getCodigo()+ " Marca: " + bebida.getMarca()+ " Sabor: " + bebida.getSabor());
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

   
    
    
    

