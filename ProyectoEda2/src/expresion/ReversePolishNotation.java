
package expresion;

import java.util.LinkedList;
import java.util.Stack;

public class ReversePolishNotation {
    Stack<Double> pila = new Stack();  //Trabajamos con un objeto de tipo Stack
    
    /*Dentro de esté método se realiza el algoritmo para resolver notación polaca inversa, 
    recordando que se debe realizar un  push cuando se encuentre un operando o cuando se realice una operación, 
    y se realiza 2 veces un pop cuando se encuentra un operando o en el resultado final*/
    public void evaluacion(LinkedList<String> expresion){
        
        for (int i = 0; i < expresion.size(); i++) {
            
            String elemAc=expresion.get(i);
            boolean existeNum=Utilerias.verifSiNum(elemAc);
            boolean existeOperador=Utilerias.verifSiOperador(elemAc);
            
            if(existeNum){              //Se valida si el índice actual es un número
                pila.push(Double.valueOf(elemAc));         //Al ser un número se almacena en la pila 
                
            }else if(existeOperador){       //Se verifica en caso contrario que sea un operador
                Double val2=pila.pop();    //Se extrae y se almacena en 2 variables consecutivas ambos números
                Double val1=pila.pop();
                Double resultado=0.0;
                
                switch(elemAc){             //De acuerdo al operador, se efectía la operación entre ambos valores
                    case "+" -> resultado=val1+val2;
                    case "-" -> resultado=val1-val2;
                    case "*" -> resultado=val1*val2;
                    case "/" -> resultado=val1/val2;
                }
                pila.push(resultado);   //Se ingresa nuevamente en la pila el resultado
            }
            if(i==expresion.size()-1){          //Cuando se ha efectuado todas las operaciones, se extrae el resultado y se imprime
                System.out.println(pila.pop());
            }           
        }
    }
}
