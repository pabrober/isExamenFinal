package gt.edu.umg.ingenieria.is.examen.examen;

import gt.edu.umg.ingenieria.is.examen.examen.controller.AllController;
import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExamenApplicationTests {

    @Autowired
    private AllController con;
    
    @Autowired 
    private AllService ser;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    //7-----TEST FOR GENETIC ALGORITHM-----START
    @Test
    public void item7test1() {
        //given                     
        final Long generation = new Long(100);
        final Long expected = new Long (100); 
        final Long[] actual;

        //when        
        actual = this.ser.genes(generation);
        
        //then         
        Assertions.assertEquals(actual[0]+actual[1], expected, "error de valores");        
    }
    
   @Test
    public void item7test2() {
        //given                                
        final Long generation = new Long(10001);
        HashMap<String, String> expected = new HashMap<>(); 
        HashMap<String, String> actual = new HashMap<>(); 
        //when        
        actual = this.ser.proporcionPobla(generation);
        expected.put("error", "numero invalido");
        //then         
        Assertions.assertEquals(actual, expected, "Limites exedidos");        
    }

    @Test
    public void item7test3() {
        //given                                
        final Long generation = new Long(5);
        final int expected = 15;
        final String getDetail;
        final int lenghtOfDetail;
        HashMap<String, String> actual = new HashMap<>(); 
        //when
        actual = this.testRestTemplate.getForObject(String.format("http://localhost:%d/ia?generation=%d", this.port, generation), HashMap.class);                       
        getDetail = actual.get("Detail");
        lenghtOfDetail = getDetail.length();
        //then         
        Assertions.assertEquals(lenghtOfDetail, expected, "Population´s details doesn´t matched");        
    }
    
    @Test
    public void item7test4() {
        //This Unit Test is to test the calculation of proportions.
        //given                                
        final Long generation = new Long(130);
        final int expected = 100;
        final int actual;
        String temp1;
        String temp2;
        HashMap<String, String> actualser = new HashMap<>(); 
        //when
        actualser = this.testRestTemplate.getForObject(String.format("http://localhost:%d/ia?generation=%d", this.port, generation), HashMap.class);                       
        temp1 = actualser.get("men").replaceAll("%","").replaceAll(" ", "").trim();
        temp2 = actualser.get("women").replaceAll("%","").replaceAll(" ", "").trim();
        actual = Integer.parseInt(temp1) + Integer.parseInt(temp2);
        //then         
        Assertions.assertEquals(actual, expected, "Proportions are wrong");        
    }
    //7-----TEST FOR GENETIC ALGORITHM-----START
}
