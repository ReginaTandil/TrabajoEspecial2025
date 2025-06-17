import utils.Maquina;


public class Backtracking extends Tecnica{
  
    public Backtracking(String pathMaquinas){
        super(pathMaquinas);
    }
    //Metodo de busqueda recursivo:
    //El arbol de exploracion se va formando a partir de la lista de maquinas disponibles para funcionar que se 
    //van combinando entre si, hasta alcanzar la cantidad de piezas a producir
    //En cada recursion la lista de maquinas se mantiene completa(se puede repetir el uso de una misma maquina)
    //Con cada llamado a recursion, se genera un nuevo estado parcial, mientras se va recorriendo una rama del arbol
    //En cada llamada a recursion, se verifica el corte de la recursion, lo que significa que llegue a un estado 
    //final; y luego verificamos si ese estado puede ser solucion(mejor solucion, mas optima)
    //Mientras se avanza en el recorrido del arbol(avanzamos en las recursiones) se utilizan estrategias de poda
    //del arbol, mecanismos que nos permiten no avanzar en la recursion, cortando esa rama(camino) del arbol,
    //porque por esa rama no llegaremos a una solucion final. Se vuelve innecesario avanzar por esa rama, se poda
    //no se avanza, se deshace lo que se hizo y se vuelve para atras en el arbol(backtracking) buscando una nueva
    //rama (no recorrida) por la que avanzar. Este mecanismo hace que el algoritmo se vuleva mas rapido y eficiente 
    //al no tener que explorar todo el arbol.
    //El backtracking es un algoritmo de busqueda exponencial, pero que de existir solucion SIEMPRE la encuentra
    //porque recorre todo el arbol.
    
    public void configuracionOptima(){
         configuracionOptima(0);
          if(!solucion.isEmpty()){
           System.out.println("Backtracking\nConfiguracion optima:" + solucion +"\ncantidad de piezas producidas:" + this.piezasTotales+"\ncantidad de puestas en funcionamiento:" + solucion.size()+"\ncosto de la solucion:" + estado);     
          }
          else{
           System.out.println("Backtracking:\nNo existe solucion, para la cantidad de piezas dadas");
          }
          }

    private void configuracionOptima(Integer faltantes){
       incrementarEstado();
        if(piezasTotales==faltantes){
          if(mejorSolucion()){
           solucion.clear();
            solucion.addAll(parcial);
            }
        }
        else{
           for(Maquina m:maquinas){
             parcial.add(m);
              reducir(m);
               if(piezasTotales>=0)
                if(mejorSolucion())
                  configuracionOptima(faltantes);
                   parcial.remove(m);
                    sumar(m);
            } 
        }
    }    
}

