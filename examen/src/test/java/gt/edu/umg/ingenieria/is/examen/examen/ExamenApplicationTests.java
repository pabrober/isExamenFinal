package gt.edu.umg.ingenieria.is.examen.examen;

import gt.edu.umg.ingenieria.is.examen.examen.controller.AllController;
import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExamenApplicationTests {

    
    @Autowired
    private AllController con;
    
    @Autowired 
    private AllService ser;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    
	@Test
	void Item6Prueba1 () throws Exception {
            
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
            
            int a = 1;
            Assertions.assertEquals(expected, actual,"Columnas no coinciden");
            
            
	}

}
