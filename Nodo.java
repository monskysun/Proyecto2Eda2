package proyecto2;

	public class Nodo {
	Nodo padre = null;
    int valor = -1;
    Nodo izq = null;
    Nodo der = null;
    
    public Nodo(){
        izq=der=padre=null;
    }
    public Nodo(int data){
        this(data,null,null);
    }
    public Nodo(int data, Nodo lt, Nodo rt){
        valor=data;
        izq = lt;
        der = rt;
    }   
    
    public void setPadre(Nodo padre) {
    	
        this.padre = padre;
    }
    
    public Nodo getPadre() {
        return this.padre;
    }
    
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    public void setDer(Nodo der) {
        this.der = der;
    }
    
     void printNode( Nodo node) {
		for(int var = 0; var< 2; var++) {
		
		}
	}
     
     void printHijos( ) {
		 System.out.println("\nNodo "+ this.valor+":\n");
		 System.out.println("     "+ this.valor);
		 if(this.izq!= null && this.der == null) {
			 System.out.println("   "+ this.izq.valor);
		 }
		 else if(this.der != null && this.izq == null )
			 System.out.println("      "+ this.der.valor);
		 
		 else if ( this.izq!= null  && this.der != null) {
			 System.out.print("   "+ this.izq.valor);
			 System.out.println("   "+ this.der.valor);
		 }

	}
}
