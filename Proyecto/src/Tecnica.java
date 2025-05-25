import java.util.LinkedList;
import utils.CSVReader;
import utils.Maquina;


public class Tecnica {
    protected LinkedList<Maquina>maquinas;
    protected LinkedList<Maquina>solucion;
    protected LinkedList<Integer>piezas;
    protected Integer piezasTotales;
    protected LinkedList<Maquina>parcial;
    protected Integer estado;

    public Tecnica(String pathMaquinas){
        CSVReader reader=new CSVReader();
        this.maquinas=reader.read2(pathMaquinas);
        this.piezas=reader.read1(pathMaquinas);
        this.piezasTotales=piezas.get(0);
        this.solucion=new LinkedList<>();
        this.parcial=new LinkedList<>();
        this.estado=0;
    }

     public Integer getEstado() {
        return estado;
    }
    
    public void incrementarEstado(){
        this.estado++;
    }

     public void reducir(Maquina m){
        piezasTotales=piezasTotales-m.getPiezas();
    }
    
    public void sumar(Maquina m){
        piezasTotales=piezasTotales+m.getPiezas();
    }

    public boolean mejorSolucion(){
        return parcial.size()<solucion.size()||solucion.isEmpty();
    }

    public void decrementar(Maquina candidata){
       this.piezasTotales=piezasTotales-candidata.getPiezas();
    }

    public boolean esFactible(Maquina candidata){
       return piezasTotales>=candidata.getPiezas();
    }
    
    public boolean existeSolucion(){
       return piezasTotales==0;    
    }

    public Integer sumar(){
      Integer suma=0;
       for(Maquina m:solucion){
           suma=suma+m.getPiezas();
       }
       return suma;
    }

    public Maquina seleccionar(){
     Integer mayor=0;
     Maquina candidata=null;
        for(Maquina m:maquinas){
          if(m.getPiezas()>mayor && m.getPiezas()<=piezasTotales){
            mayor=m.getPiezas();
            candidata=m;
          }  
        }
    return candidata;
    }
}
