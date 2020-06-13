package gt.edu.umg.ingenieria.is.examen.examen;

import gt.edu.umg.ingenieria.is.examen.examen.controller.AllController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExamenApplicationTests {

        @Autowired
        private AllController allController;
        
        
	@Test
	public void binarytree() {
            //given
            final int[] expected = {6,7,5,3,1};
            
            //when
            
            //then
            
	}

}
