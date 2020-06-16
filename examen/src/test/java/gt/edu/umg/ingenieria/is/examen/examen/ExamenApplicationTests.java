package gt.edu.umg.ingenieria.is.examen.examen;

import gt.edu.umg.ingenieria.is.examen.examen.controller.AllController;
import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExamenApplicationTests {

    @Autowired
    private AllController con;

    @Autowired
    private AllService ser;

    @Autowired
    private AllController allController;    

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    //7-----TEST FOR GENETIC ALGORITHM-----START
    @Test
    public void item7test1() {
        //given                     
        final Long generation = new Long(100);
        final Long expected = new Long(100);
        final Long[] actual;

        //when        
        actual = this.ser.genes(generation);

        //then         
        Assertions.assertEquals(actual[0] + actual[1], expected, "error de valores");
    }

    @Test
    public void item7test2() {
        //given                                
        final Long generation = new Long(10001);
        HashMap<String, String> expected = new HashMap<String, String>();
        HashMap<String, String> actual = new HashMap<String, String>();
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
        Assertions.assertEquals(lenghtOfDetail, expected, "PopulationÂ´s details doesnÂ´t matched");
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
        temp1 = actualser.get("men").replaceAll("%", "").replaceAll(" ", "").trim();
        temp2 = actualser.get("women").replaceAll("%", "").replaceAll(" ", "").trim();
        actual = Integer.parseInt(temp1) + Integer.parseInt(temp2);
        //then         
        Assertions.assertEquals(actual, expected, "Proportions are wrong");
    }

    @Test
    public void item7test5() {
        //This Unit Test is to test the mutation proportions.
        //given                                
        final Long generation = new Long(150);
        final int expected = 0;
        final int actual1;
        final int actual2;
        String temp1;
        String temp2;
        HashMap<String, String> actualser = new HashMap<>();
        //when
        actualser = this.testRestTemplate.getForObject(String.format("http://localhost:%d/ia?generation=%d", this.port, generation), HashMap.class);
        temp1 = actualser.get("men").replaceAll("%", "").replaceAll(" ", "").trim();
        temp2 = actualser.get("women").replaceAll("%", "").replaceAll(" ", "").trim();
        actual1 = Integer.parseInt(temp1);
        actual2 = Integer.parseInt(temp2);
        //then
        Assertions.assertNotEquals(expected, actual1, "MenÂ´s mutation canÂ´t be 0%");
        Assertions.assertNotEquals(expected, actual2, "WomenÂ´s mutation canÂ´t be 0%");
    }

    @Test
    public void item7test6() {
        //given                                
        final Long generation = new Long(120);
        final int actual;
        final int expected = 3;
        HashMap<String, String> actualser = new HashMap<>();
        //when
        actualser = this.testRestTemplate.getForObject(String.format("http://localhost:%d/ia?generation=%d", this.port, generation), HashMap.class);
        actual = actualser.size();
        //then
        Assertions.assertEquals(actual, expected, "objeto incompleto");
    }

    //7-----TEST FOR GENETIC ALGORITHM-----END
    //test ejercicio 6
    @Test
    void Item6Prueba1() throws Exception {

        //given
        final ArrayList<String> actual;
        final ArrayList<String> expected = new ArrayList<>();
        final int columns = 5;
        expected.add("A");
        expected.add("B");
        expected.add("C");
        expected.add("D");
        expected.add("E");
        //when            
        actual = this.ser.excel(columns);
        //then                      
        Assertions.assertEquals(expected, actual, "Columnas no coinciden");

    }

    @Test
    void Item6Prueba2() {
        int actual = 0;
        assertThrows(
                Exception.class,
                () -> ser.excel(actual));
    }

    @Test
    void Item6Prueba3() {
        int actual = 100001;
        assertThrows(
                Exception.class,
                () -> ser.excel(actual));
    }

    //fin test ejercicio 6
    
    @Test
    public void binarytree() {
        //given
        final int[] expected = {6, 7, 5, 3, 1};

        //when
        //then
    }
}
