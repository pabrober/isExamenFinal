package gt.edu.umg.ingenieria.is.examen.examen.service;
import java.util.ArrayList;
import static java.util.Collections.reverse;
import org.springframework.stereotype.Service;

@Service
public class AllService extends Exception{
    
//Exceptions
    public AllService(){
        super("Número de elementos fuera de rango");
    }    
    
    
//Algoritmo de ordenamiento por selección**************************************
    public ArrayList<Long> selectSort(ArrayList<Long> elements) throws Exception, AllService{
        ArrayList<Long> listaOrdenada = null;
        if(elements.size()<2||elements.size()>1000){
           throw new AllService();
        }
        int i,j,min;
        long aux;
        for (i=0;i<elements.size();i++){
            min=i;
            for(j=i+1;j<elements.size();j++){
                if(elements.get(j)<elements.get(min)){
                    min = j;
                }
            }
            aux= elements.get(i);
            elements.set(i, elements.get(min));
            elements.set(min, aux);
        }   
        if(elements.size() > 1) {                   
            Object value = elements.remove(0);
            reverse(elements);
            elements.add((Long) value);
        }
        listaOrdenada = elements;
        return listaOrdenada; 
    }
    
//Algoritmo de ordenamiento de burbuja**************************************
    public ArrayList<Long> bubbleSort(ArrayList<Long> elements)throws Exception, AllService{
        ArrayList<Long> listaOrdenada = null;
        if(elements.size()<2||elements.size()>1000){
           throw new AllService();
        }
        int i,j;
        long aux;
        for(i=0;i<elements.size()-1;i++){
            for(j=0;j<elements.size()-1;j++){
                if(elements.get(j)>elements.get(j+1)){
                    aux = elements.get(j);
                    elements.set(j, elements.get(j+1));
                    elements.set(j+1, aux);
                }
            }
        }
        if(elements.size() > 1) {                   
            Object value = elements.remove(0);
            reverse(elements);
            elements.add((Long) value);
        }        
        listaOrdenada = elements;
        return listaOrdenada; 
    }


//Algoritmo de ordenamiento de burbuja**************************************
    public ArrayList<Long> insertionSort(ArrayList<Long> elements)throws Exception, AllService{
        ArrayList<Long> listaOrdenada = null;
        if(elements.size()<2||elements.size()>1000){
           throw new AllService();
        }     
        int i,j,pos;
        long aux;
        for(i=0;i<elements.size();i++){
            pos = i;
            aux = elements.get(i);
            while((pos>0)&&(elements.get(pos-1)>aux)){
                elements.set(pos, elements.get(pos-1));
                pos--;
            }
            elements.set(pos, aux);
        }
        if(elements.size() > 1) {                   
            Object value = elements.remove(0);
            reverse(elements);
            elements.add((Long) value);
        }        
        listaOrdenada = elements;
        return listaOrdenada;
    }
    
//Algoritmo de ordenamiento de quicksort**************************************   
    public ArrayList<Long> quickSort(ArrayList<Long> elements,int primero, int ultimo)throws Exception, AllService{
        ArrayList<Long> listaOrdenada = null;
        if(elements.size()<2||elements.size()>1000){
           throw new AllService();
        }        
        int i, j;
        long aux,pivote;
        i=primero;
        j=ultimo;
        pivote = elements.get((primero+ultimo)/2);
        do{
            while(elements.get(i)<pivote){
                i++;
            }
            while (elements.get(j)>pivote){
                j--;
            }
            if(i<=j){
                aux = elements.get(i);
                elements.set(i,elements.get(j));
                elements.set(j,aux);
                i++;
                j--;
            }
        }while(i<=j);
        if(primero<j){
            quickSort(elements,primero,j);
        }
        if(i<ultimo){
            quickSort(elements,i,ultimo);
        }     
        listaOrdenada = elements;
        return listaOrdenada;
    }
 
    
//Algoritmo de triangulo de pascal**************************************   
    public ArrayList<String> pascalTriangle(int pisos)throws Exception, AllService{
        ArrayList<String> aux = null;
        ArrayList<String> lista = null;
        for(int i=1; i<=pisos;i++){
            ArrayList<String> pascal;
            for(int k=pisos;k>i;k--){
                lista.set(i,aux.get(i)+" ");
            }
            for(int j=0; j<i; j++){
                if(j==0||j==(i-1)){
                   // lista                   
                }
            }
        }
        
        
        return null;
    }
}
