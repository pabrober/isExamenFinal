/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.ingenieria.is.examen.examen.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author pc
 */
@Service
public class AllService {
    
    //7-----GENETIC ALGORITHM-----START
    public Long[] genes(Long muestra)
    {
        //algoritmo de genes
        double propo = Math.random()*0.9+0.1;
        //  canitad hombres
        Long hombres = Math.round(muestra * propo);
        //  cantidad mujeres
        Long mujeres = muestra - hombres;
        
        Long[] data = {hombres,mujeres}; 
        
        return data;
    }
    
    public int proporcionPobla(Long muestra){
        Long[] datapro = this.genes(muestra); 
        int  porcentajeHombres = 0;
        ArrayList<String> detail = new ArrayList<String>();
        
        if(muestra>=1 && muestra<=10000)
        {
            //porcentaje hombre
            porcentajeHombres = Math.round((datapro[0]*100)/muestra);
            //porcentaje mujeres
            int porcentajeMujeres = 100 - porcentajeHombres;
        
            for(int i = 0;i<datapro[0];i++)
            {
                detail.add("h");
                for(int j = 0;j<datapro[1];j++)
                {
                    detail.add("m");
                }
            }
        }
        
        return porcentajeHombres;
    }
    //7-----GENETIC ALGORITHM-----END
    
}
