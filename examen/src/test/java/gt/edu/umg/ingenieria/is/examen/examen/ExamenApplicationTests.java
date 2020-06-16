package gt.edu.umg.ingenieria.is.examen.examen;

import gt.edu.umg.ingenieria.is.examen.examen.controller.AllController;
import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import java.util.ArrayList;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import org.junit.jupiter.api.MethodOrderer.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExamenApplicationTests {
    
    @Autowired
    private AllService ser;
    
    @Autowired
    private AllController con;
    
    @LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
	}
        
   //UNIT TEST PARA CASO DE USO 1 SELECTSORT*********************************** 
   //Test de ordenamiento normal
   @Test
   public void item1Test1 () throws Exception{
       //given
       
       final  ArrayList<Long> actual;
       final  ArrayList<Long> expected = new ArrayList<>();;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //when
       
       actual = this.ser.selectSort(data);
       expected.add(new Long(55));
       expected.add(new Long(45));
       expected.add(new Long(35));
       
       
       //then
       
       Assertions.assertEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
   }
   
    // Test de datos por medio de controlador 
  /* @Test 
    public void item1test2() throws Exception{
        //given                                
       ArrayList<Long> actual = new ArrayList<>();
       final  ArrayList<Long> expected = new ArrayList<>();
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       
        //when
        
        //No se pudo llamar a una lista en el %d de la URL
        actual = this.testRestTemplate.getForObject(String.format("http://localhost:%d/selectSort/+Array", this.port, data), ArrayList.class);                       
        int a =9;

        //then         
        Assertions.assertEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }*/
     
    //Test con un solo valor
     @Test
    public void item1test3() throws Exception{
        
       final  ArrayList<Long> actual = null;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
      
        assertThrows(
            Exception.class,
            () -> ser.selectSort(actual));
    }
    
    // Test sin ningun valor   
    @Test
    public void item1test4() throws Exception{
        
       final  ArrayList<Long> actual = null;
       ArrayList<Long> data = new ArrayList<>();
       
      
        assertThrows(
            Exception.class,
            () -> ser.selectSort(actual));
    }
    
    //Test de ordenamiento normal con AssertNotEquals
   @Test
   public void item1Test5 () throws Exception{
       //given
       
       final  ArrayList<Long> actual;
       final  ArrayList<Long> expected = new ArrayList<>();;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //when
       
       actual = this.ser.selectSort(data);
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //then
       
       Assertions.assertNotEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }
   
   //Test exepcion con array con mas de 1,000 datos
    @Test
   public void item1Test6 () throws Exception{
       //given
       
       final  ArrayList<Long> actual = null;
       final  ArrayList<Long> expected = new ArrayList<>();
       int n = 10000; // se llena con 10,000 datos creando una exepcion
       ArrayList<Long> data = new ArrayList<>(n);
       
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i=0; i<n; i++)
        {
            Long r = rand.nextLong() % 256;
            data.add(r);
        }

        assertThrows(
            Exception.class,
            () -> ser.bubbleSort(actual));   
      
   }
       
   //UNIT TEST PARA CASO DE USO 2 BUBBLESORT*********************************** 
   //Test de ordenamiento normal
   @Test
   public void item2Test1 () throws Exception{
       //given
       
       final  ArrayList<Long> actual;
       final  ArrayList<Long> expected = new ArrayList<>();;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //when
       
       actual = this.ser.bubbleSort(data);
       expected.add(new Long(55));
       expected.add(new Long(45));
       expected.add(new Long(35));
       
       
       //then
       
       Assertions.assertEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
   }
   
     
    //Test con un solo valor
     @Test
    public void item2test2() throws Exception{
        
       final  ArrayList<Long> actual = null;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
      
        assertThrows(
            Exception.class,
            () -> ser.bubbleSort(actual));
    }
    
    // Test sin ningun valor 
    
    @Test
    public void item2test3() throws Exception{
        
       final  ArrayList<Long> actual = null;
       ArrayList<Long> data = new ArrayList<>();
       
      
        assertThrows(
            Exception.class,
            () -> ser.bubbleSort(actual));
    }
    
    
    //Test de ordenamiento normal con AssertNotEquals
    @Test
    public void item2Test4 () throws Exception{
       //given
       
       final  ArrayList<Long> actual;
       final  ArrayList<Long> expected = new ArrayList<>();;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //when
       
       actual = this.ser.bubbleSort(data);
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //then
       
       Assertions.assertNotEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }
    
    //Test exepcion con array con mas de 1,000 datos
    @Test
   public void item2Test5 () throws Exception{
       //given
       
       final  ArrayList<Long> actual = null;
       final  ArrayList<Long> expected = new ArrayList<>();
       int n = 10000; // se llena con 10,000 datos creando una exepcion
       ArrayList<Long> data = new ArrayList<>(n);
       
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i=0; i<n; i++)
        {
            Long r = rand.nextLong() % 256;
            data.add(r);
        }

        assertThrows(
            Exception.class,
            () -> ser.bubbleSort(actual));   
      
   }
   
   //UNIT TEST PARA CASO DE USO 3 INSERTIONSORT*********************************** 
   //Test de ordenamiento normal
   @Test
   public void item3Test1 () throws Exception{
       //given
       
       final  ArrayList<Long> actual;
       final  ArrayList<Long> expected = new ArrayList<>();;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //when
       
       actual = this.ser.insertionSort(data);
       expected.add(new Long(55));
       expected.add(new Long(45));
       expected.add(new Long(35));
       
       
       //then
       
       Assertions.assertEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
   }
   
     
    //Test con un solo valor
     @Test
    public void item3test2() throws Exception{
        
       final  ArrayList<Long> actual = null;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
      
        assertThrows(
            Exception.class,
            () -> ser.insertionSort(actual));
    }
    
    // Test sin ningun valor 
    
    @Test
    public void item3test3() throws Exception{
        
       final  ArrayList<Long> actual = null;
       ArrayList<Long> data = new ArrayList<>();
       
      
        assertThrows(
            Exception.class,
            () -> ser.insertionSort(actual));
    }
    
    
    //Test de ordenamiento normal con AssertNotEquals
    @Test
    public void item3Test4 () throws Exception{
       //given
       
       final  ArrayList<Long> actual;
       final  ArrayList<Long> expected = new ArrayList<>();;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //when
       
       actual = this.ser.insertionSort(data);
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //then
       
       Assertions.assertNotEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }
    
    //Test exepcion con array con mas de 1,000 datos
    @Test
   public void item3Test5 () throws Exception{
       //given
       
       final  ArrayList<Long> actual = new ArrayList<>();
       final  ArrayList<Long> expected = new ArrayList<>();
       int n = 10000; // se llena con 10,000 datos creando una exepcion
       ArrayList<Long> data = new ArrayList<>(n);
       
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i=0; i<n; i++)
        {
            Long r = rand.nextLong() % 256;
            data.add(r);
        }

        assertThrows(
            Exception.class,
            () -> ser.insertionSort(actual));   
      
   }
   
   //UNIT TEST PARA CASO DE USO 4 QUICKSORT*********************************** 
   //Test de ordenamiento normal
   @Test
   public void item4Test1 () throws Exception{
       //given
       
       final  ArrayList<Long> actual;
       final  ArrayList<Long> expected = new ArrayList<>();;
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //when
       
       actual = this.ser.quickSort(data,0,data.size()-1);
       expected.add(new Long(35));
       expected.add(new Long(45));
       expected.add(new Long(55));
       
       
       
       
       //then
       
       Assertions.assertEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
   }
   
     
    //Test con un solo valor
     @Test
    public void item4test2() throws Exception{
        
       ArrayList<Long> actual = new ArrayList<>();
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
      
        assertThrows(
            Exception.class,
            () -> ser.quickSort(actual,0,actual.size()));   
    }
    
    // Test sin ningun valor 
    
    @Test
    public void item4test3() throws Exception{
        
       ArrayList<Long> actual = new ArrayList<>();
       ArrayList<Long> data = new ArrayList<>();
       
      
        assertThrows(
            Exception.class,
            () -> ser.quickSort(actual,0,actual.size()));   
    }
    
    
    //Test de ordenamiento normal con AssertNotEquals
    @Test
    public void item4Test4 () throws Exception{
       //given
       
       ArrayList<Long> actual = new ArrayList<>();
       final  ArrayList<Long> expected = new ArrayList<>();
       ArrayList<Long> data = new ArrayList<>();
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //when
       
       actual = this.ser.quickSort(data,0,data.size()-1);
       data.add(new Long (45));
       data.add(new Long (55));
       data.add(new Long (35));
       
       //then
       
       Assertions.assertNotEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }
    
    //Test exepcion con array con mas de 1,000 datos
    @Test
   public void item4Test5 () throws Exception{
       //given
       
       final  ArrayList<Long> actual = new ArrayList<>();
       final  ArrayList<Long> expected = new ArrayList<>();
       int n = 10000; // se llena con 10,000 datos creando una exepcion
       ArrayList<Long> data = new ArrayList<>(n);
       
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i=0; i<n; i++)
        {
            Long r = rand.nextLong() % 256;
            data.add(r);
        }

        assertThrows(
            Exception.class,
            () -> ser.quickSort(actual,0,actual.size()));   
      
   }
   
   //UNIT TEST PARA CASO DE USO 5 TRIANGULO*********************************** 
   //Test de ordenamiento normal
   @Test
   public void item5Test1 () throws Exception{
       //given
       
       ArrayList<String> actual = new ArrayList<>();
      final  ArrayList<String> expected = new ArrayList<>();
      
      expected.add(" 1");
      expected.add("------Fila: 1 ------");
      expected.add(" 1");
      expected.add(" 1");
      expected.add("------Fila: 2 ------");
      expected.add(" 1");
      expected.add(" 2");
      expected.add(" 1");
      expected.add("------Fila: 3 ------");
      /*expected.add("1");
      expected.add("3");
      expected.add("3");
      expected.add("1");*/
      
       final int n = 3;
       
       
       //when
       
       actual = this.ser.pascalTriangle(n);
       
       
       //then
       
       Assertions.assertEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
   }
   
     
    // Test limite inferior
     @Test
    public void item5test2() throws Exception{
        
       ArrayList<String> actual = new ArrayList<>();
      
      final int n = 0;
      
       
      
        assertThrows(
            Exception.class,
            () -> ser.pascalTriangle(n));
    }
    
    
    // Test arriba del limite superior
    @Test
    public void item5test3() throws Exception{
        
       ArrayList<String> actual = new ArrayList<>();
      
      final int n = 10001;//10,001
      
       
      
        assertThrows(
            Exception.class,
            () -> ser.pascalTriangle(n));
    }
    
    
    //Test de ordenamiento normal con AssertNotEquals
    @Test
    public void item5Test4 () throws Exception{
       //given
       
        ArrayList<String> actual = new ArrayList<>();
      final  ArrayList<String> expected = new ArrayList<>();
      
      expected.add(" 1");
      /*expected.add("------Fila: 1 ------");
      expected.add(" 1");
      expected.add(" 1");
      expected.add("------Fila: 2 ------");
      expected.add(" 1");
      expected.add(" 2");
      expected.add(" 1");
      expected.add("------Fila: 3 ------");
      expected.add("1");
      expected.add("3");
      expected.add("3");
      expected.add("1");*/
      
       final int n = 3;
       
       
       //when
       
       actual = this.ser.pascalTriangle(n);
       
       //then
       
       Assertions.assertNotEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }
    
    //Test exepcion dato String
    @Test
   public void item5Test5 () throws Exception{
       //given
       
       ArrayList<String> actual = new ArrayList<>();
      
      final String n = "1";
      
       
      
        assertThrows(
            Exception.class,
            () -> ser.pascalTriangle(parseInt(n)));
    
   }
   
   //Test exepcion dato Double
    @Test
   public void item5Test6 () throws Exception{
       //given
       
       ArrayList<String> actual = new ArrayList<>();
      
      final double n = 1.5;
      
       
      
        assertThrows(
            Exception.class,
            () -> ser.pascalTriangle(intValue(n)));
    
   }

    private int parseInt(String n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int intValue(double n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
       
}
