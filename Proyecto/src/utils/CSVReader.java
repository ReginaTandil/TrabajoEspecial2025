package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CSVReader {

      public CSVReader() {      
	   }
    
	public LinkedList<Integer> read1(String path) {
      LinkedList<Integer>cantidad=new LinkedList<>();
		try{
                List<List<String>>data=new ArrayList<>();
                String file=path;
                FileReader fr=new FileReader(file);
                BufferedReader br=new BufferedReader(fr);

                String line=br.readLine();
                while(line!=null){
                   List<String>lineData=Arrays.asList(line.split(";"));
                     data.add(lineData);
                       line=br.readLine();
                }
                for(List<String>list:data){
                  for(String str:list){
                     if(str.equals("12")){
                        Integer piezas_totales=Integer.parseInt(str);
                        cantidad.add(piezas_totales);
                     }
                  }        
                }
                br.close();
        }
        catch(Exception e){
        }	
		return cantidad;
	}

   public LinkedList<Maquina> read2(String path) {
      LinkedList<Maquina>fabricas=new LinkedList<>();
		try{
                List<List<String>>data=new ArrayList<>();
                String file=path;
                FileReader fr=new FileReader(file);
                BufferedReader br=new BufferedReader(fr);

                String line=br.readLine();
                while(line!=null){
                   List<String>lineData=Arrays.asList(line.split(";"));
                     data.add(lineData);
                       line=br.readLine();
                }
                for(List<String>list:data){
                  if(list!=data.get(0)){
                     String nombre=list.get(0).trim();
                     Integer piezas=Integer.parseInt(list.get(1).trim());
                      
                        fabricas.add(new Maquina(nombre, piezas));
                     }
                  }       
                br.close();
        }
        catch(Exception e){
        }	
		return fabricas;
	}
}
