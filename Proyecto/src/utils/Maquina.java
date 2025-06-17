package utils;

public class Maquina {
    private String nombre;
    private Integer piezas;

    public Maquina(String nombre,Integer piezas){
        this.nombre=nombre;
        this.piezas=piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPiezas() {
        return piezas;
    }

    public void setPiezas(Integer piezas) {
        this.piezas = piezas;
    }

    public String toString(){
        return this.nombre+":"+this.piezas;
    }
    
 

}
