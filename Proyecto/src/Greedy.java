import utils.Maquina;

public class Greedy extends Tecnica {
 
    
    public Greedy(String pathMaquinas){
       super(pathMaquinas);
    }
    //Metodo de busqueda iterativo, no recursivo:
    //Los candidatos son todas las maquinas de la lista(se pueden repetir) y mientras existan piezas por producir
    //y no exista solucion(conbinacion mas optima de maquinas), es que voy a continuar seleccionando candidatos
    //La funcion seleccion() es quien implementa la Estrategia Greedy: vamos a ir seleccionando en primer lugar 
    //aquellas maquinas con mayor cantidad de piezas a producir; con el fin de alcanzar antes la cantidad de 
    //piezas totales a producir con la menor cantidad de maquinas en funcionamiento.
    //Una vez seleccionada voy a verificar que esa maquina esFactible() que sea solucion, si la cantidad de 
    //piezas que produce es menor o igual a la cantidad de piezas que tengo por producir
    //Si esFactible(): esa maquina formara parte de la solucion y quedaran entonces menos piezas por producir.
    //Al ser un metodo de busqueda no recursivo, una vez que selecciono un candidato y lo considera solucion, 
    //no hay posibilidad de volver para atras y deshacer. No existe un arbol de exploracion, de acuerdo a la 
    //estrategia greddy implementada es que se recorre un unico "camino".
    //Es un metodo de busqueda polinomial, NO SIEMPRE encuentra (de existir) la mejor solucion.
    //Respecto al tiempo computacional: es una algoritmo de busqueda mas rapido, no genera llamadas recursivas 
    //y no explora un arbol; pero no asegura que de existir solucion la encuentre.
    //Una forma de utilizarlo es como una aproximacion a mejor una solucion, aplico Greddy y esa solucion sera 
    //implementada como una estrategia de poda en el algoritmo de busqueda backtracking: asegurandome de 
    //encontrar si o si la mejor solucion y en el menor tiempo de busqueda.

    public void ConfiguracionOptima(){
        while(piezasTotales>0 && !existeSolucion()){
        incrementarEstado();   
         Maquina candidata=seleccionar();
          if(esFactible(candidata)){
            solucion.add(candidata);
              decrementar(candidata);
          }   
        }
        if(existeSolucion()){
           System.out.println("Greedy\nConfiguracion optima:" + solucion +"\ncantidad de piezas producidas:" + this.sumar()+"\ncantidad de puestas en funcionamiento:" + solucion.size()+"\ncosto de la solucion:" + estado); 
        }
        else{
            System.out.println("No existe solucion");
        }
    }
}
