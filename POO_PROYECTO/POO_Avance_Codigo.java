/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo_avance_codigo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author luisa
 */
public class POO_Avance_Codigo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int input;
       
        Scanner scanner = new Scanner(System.in);
       
         Nieve nieve;
         Bebidas bebida;
         ArrayList <Bebidas> bebidaList = new ArrayList();
          ArrayList <Nieve>nieveList = new ArrayList();
        do
        {
            System.out.println("Sistema");
            System.out.println("1. Agregar un nuevo producto");
            System.out.println("2. Ver una lista de los productos");
            System.out.println("3. Fin del programa");
            
            
            System.out.println("");
            System.out.println("Porfavor seleccione una opcion del 1 al 3");
          input = (scanner.nextInt());
            if (input ==(1))
            { //Agregar un nuevo producto
                
                System.out.println("1. Agregar nieve");
                System.out.println("2. Agregar bebida");
                 input = (scanner.nextInt());
                 if(input ==(1))
                 {
                 nieveList.add(new Nieve ());
               
                nieve = nieveList.get(nieveList.size()-1);
                nieve.escribirObj(nieveList);
                   
                     System.out.println("Se agrego una nieve");
                 }else if (input==(2)){
                     bebidaList.add(new Bebidas());
                     bebida = bebidaList.get(bebidaList.size()-1);
                     bebida.escribirObj(bebidaList);
                   
                     
                     
                    
                     System.out.println("Se agrego una bebida");
                 }
                     
                
                
             
                
        }
            else if (input==(2)){
                if(bebidaList.size() !=0){  
                    bebida = bebidaList.get(bebidaList.size()-1);
                  bebida.leerObj(bebidaList);
                }
                if(nieveList.size() !=0){
                
                    nieve = nieveList.get(nieveList.size()-1);
             
               nieve.leerObj(nieveList);
                }
            }
           
           
        }while(input!=(3));
    
    }
}
