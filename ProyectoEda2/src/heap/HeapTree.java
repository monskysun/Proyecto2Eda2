
package heap;
import Arboles.*;
import java.util.LinkedList;
import java.util.Queue;

public class HeapTree {
    Nodo root;
	 
	 
    // Para inicializar la raíz con un nodo existente
    public void HeapTree(Nodo root){
         this.root=root;
    }
    
    //Para subir al nodo nuevo si es mayor que el padre
     public int comparacionUp(Nodo hijo) { // se pasa al hijo como parametro
        Nodo aux = new Nodo(); // se crea un axuliar para hacer el cambio de valores
        if( hijo.padre != null) { // se revisa que el nodo no sea la raíz
            Nodo padre =  hijo.padre; 
            if(hijo.valor > padre.valor) { //Si el hijo es mayor que el padre hace el cambio de valores
                aux.valor = padre.valor;
                padre.valor= hijo.valor;
                hijo.valor = aux.valor;
                comparacionUp(hijo.padre); //Se hace la comparación recursivamente 
                //con el padre hasta que llegue a la posición correcta
                //(puesto que ya subió)
            }
            return 1;// Cuando el nodo hijo ya no es mayor que el padre retorna 1, 
            //en este caso no se aumulan operaciones
        }
        else 
                return 0; //Si ya llego a la raíz sale del método

     }
     
    //Para insertar a la izquierda
    public void insertarIzq(Nodo padre, Nodo hijo) { 
        padre.setIzq(hijo);//se le asigna hijo izquierdo al nodo padre
        hijo.setPadre(padre); // se le asigna padre al hijo izquierdo
        comparacionUp(hijo); // se revisa que el nodo insertado no sea mayor que su padre, en caso afirmativo se realiza un cambio 

    }
    //Para insertar a la derecha
    public void insertarDer(Nodo padre, Nodo hijo) {
        padre.setDer(hijo); //se le asigna hijo derecho al nodo padre
        hijo.setPadre(padre);// se le asigna padre al hijo derecho
        comparacionUp(hijo);  // se revisa que el nodo insertado no sea mayor que su padre, en caso afirmativo se realiza un cambio

    }
	
    //Retorna el último padre que no está "Completo"
    public Nodo BuscarUltimo(){
        Nodo r = root; //Se declara un nodo y se iguala a la raíz del HEAP
        Queue<Nodo> queue = new LinkedList(); //Se declara una cola 
        if(r!=null){ // si la raíz existe
            queue.add(r); // se encola al nodo
            while(!queue.isEmpty()){ //mientras haya nodos en la cola va a revisar si  tienen a sus hijos completos
                r = (Nodo)queue.poll(); // desencola
                    if(r.izq!=null)  // si tiene izquierdo lo encola 
                        queue.add(r.izq);
                    else // si no retorna el nodo padre para después saber donde insertar un nuevo nodo
                        return r;
                    if(r.der!=null) //de igual forma si tiene hijo der lo encola
                        queue.add(r.der);
                    else // si no retorna el nodo padre 
                        return r;
                } 
        }
        return r;
   }
    //retorna el último nodo que se añadió al Heap
    public Nodo FindLast(Nodo seleccionado){ // Se le pasa el nodo raíz para este caso

        Queue<Nodo> queue = new LinkedList();
        if(seleccionado!=null){ // se revisa que el nodo exista
            queue.add(seleccionado); // lo agrega a la cola
            while(!queue.isEmpty()){ // miestras la cola no esté vacía
                seleccionado = (Nodo)queue.poll(); // desencola el nodo

                    if(seleccionado.izq!=null) // si tiene hijo izq lo agrega
                        queue.add(seleccionado.izq);
                    if(seleccionado.der!=null)// si tiene hijo derecho lo agrega
                        queue.add(seleccionado.der);
            }
            return seleccionado;//retorna el último nodo de la cola, es decir el último nodo que se agrego al heap
        }
        return seleccionado;
    }
    
    //Método para insertar un nodo
    public int insert(Nodo root, Nodo NodoHijo){ // se le pasa el nodo padre y el nodo hijo
        //por que se va a ocupar en insertarDer e insertarIzq
        if(root.izq == null) {// Si no tiene hijo izquierdo lo inserta 
            insertarIzq(root, NodoHijo);
            return 1; //Sale del método, retorna 1
        }
        else if(root.der == null) {
            insertarDer(root, NodoHijo); // Si no tiene hijo derecho lo inserta 
            return 1; // retorna 1
        // Hasta aquí ya se insertaron los primeros 3 nodos
        }
        else if(root.izq != null && root.der != null) { // si los nodos izq y der del root ya estña ocupados
            Nodo padre = new Nodo(); 
            padre = BuscarUltimo(); // busca al último padre con sus hijos incompletos
            insert(padre,NodoHijo); // Y lo inserta en el primer lugar disponible
        }
        return 0;
    }
    //Función que sirve para buscar el  nodo hijo de mayor valor
    public int buscarMayor(Nodo nodo) { // recibe el nodo padre
        if(nodo.izq != null && nodo.der != null) { // revisa que  sus dos hijos no sean nulos 
            if(nodo.izq.valor > nodo.der.valor ) // compara los valores 
                return 0;
            else
                return 1;// retorna el lado del hijo mayor //0 = izq// 1 = der
        }
        else if(nodo.izq != null && nodo.der == null) // si solo tiene hijo izquierdo
            return 0;
        else if (nodo.izq == null && nodo.der != null) // si solo tiene hijo derecho
            return 1;
        return -1; // cualquier "otro caso" retorna  -1
    }
	   
    //Para "bajar" al nodo padre si es menor que alguno de sus hijos
    public void comparacionDown(Nodo root) {
        Nodo aux = new Nodo(); // Nodo aux para realizar el cambio
        Nodo hijo = new Nodo();
        int lado = buscarMayor(root); // sirve para saber cual de sus hijos es el mayor
        // para pasarlo como parametro y realizar los cambios si es que se necesita
        if(lado == 0) {
            hijo = root.izq;
        }
        else if(lado == 1) {
            hijo = root.der;
        }
        //Se asigno valor al nodo hijo
        if(hijo != null) { // Si el nodo existe
            if(root.valor< hijo.valor) { // Si el valor dl padre es menor al del hijo
                // Se hace un cambio de valores
                aux.valor = root.valor; 
                root.valor = hijo.valor;
                hijo.valor = aux.valor;
                comparacionDown(hijo);  // Se hace una llamada recursiva para comparar al nodo con sus nuevos nodos hijo
                // Y hacer el cambio de posición de ser necesario
            }
        }
    }
    
    //Eliminar
    public void EliminarRaiz(){// Funcio que sirve para eliminar la raiz

        Nodo ultimo = new Nodo();
        ultimo = FindLast(root); // Encuentra al último nodo del heap para hacer el intercambio

        root.valor = ultimo.valor; // se cambia el valor de la raíz con el último nodo
        Nodo padre =  ultimo.getPadre(); // se busca al padre del nodo a eliminar

        int lado = buscarMayor(root); // se busca el mayor de los hijos de la nueva raíz para hacer lo intercambios
        if(lado == 0) {// Para saber que hijo se va a borrar
            padre.izq = null;// Se borra
        }
        else if(lado == 1) {
            padre.der = null;// Se borra
        }
        comparacionDown(root); 

    }
    // ------------BreadthFirts---------------
    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
    }	

    public void breadthFrist(){
        Nodo r = root;
        Queue<Nodo> queue = new LinkedList();
        if(r!=null){
        queue.add(r);

            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                visit(r);
                if(r.izq!=null) {
                    queue.add(r.izq);
                }
                if(r.der!=null) {
                    queue.add(r.der);
                }
            }
        }
    }
}
