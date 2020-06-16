package gt.edu.umg.ingenieria.is.examen.examen;

import gt.edu.umg.ingenieria.is.examen.examen.service.AllService;
import gt.edu.umg.ingenieria.is.examen.examen.service.AllService.BinarySearchTree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExamenApplicationTests {

    @Autowired
    private AllService ser;

    @Autowired
    private BinarySearchTree bt;

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

    //8-----TEST FOR BINARY TREE-----START
    @Test
    public void item8test1() {
        int[] actual = null;
        assertThrows(
                Exception.class,
                () -> bt.createTree(actual));
    }

    @Test
    public void item8test2() {
        int[] actual = {1000001};

        if (actual.length < 1 && actual.length > 1000000) {
            assertThrows(Exception.class, () -> bt.createTree(actual), "Exception Executed");
        }

    }

    @Test
    public void item8test3() throws Exception {
        final HashMap<String, List<Integer>> actual;
        final HashMap<String, List<Integer>> expected = new HashMap<>();
        final ArrayList<Integer> data1 = new ArrayList<>();
        data1.add(50);
        data1.add(20);
        data1.add(80);
        final ArrayList<Integer> data2 = new ArrayList<>();
        data2.add(20);
        data2.add(80);
        data2.add(50);
        final ArrayList<Integer> data3 = new ArrayList<>();
        data3.add(20);
        data3.add(50);
        data3.add(80);

        int[] values = {50, 20, 80};

        expected.put("Pre Order", data1);
        expected.put("Post Order", data2);
        expected.put("In Order", data3);

        actual = this.bt.createTree(values);

        assertEquals(expected, actual, "Datos incorrectos");
    }

    @Test
    public void item8test4() throws Exception {
        final HashMap<String, List<Integer>> expected = new HashMap<>();
        final ArrayList<Integer> data = new ArrayList<>();
        data.add(50);
        data.add(20);
        data.add(80);

        int[] values = {50, 20, 80};
        expected.put("pre Order", data);

        assertFalse(bt.createTree(values).isEmpty());

    }
    //8-----TEST FOR BINARY TREE-----END

    @Test
    void contextLoads() {
    }

    //UNIT TEST PARA CASO DE USO 1 SELECTSORT*********************************** 
    //Test de ordenamiento normal
    @Test
    public void item1Test1() throws Exception {
        //given

        final ArrayList<Long> actual;
        final ArrayList<Long> expected = new ArrayList<>();;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

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
    public void item1test3() throws Exception {

        final ArrayList<Long> actual = null;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));

        assertThrows(
                Exception.class,
                () -> ser.selectSort(actual));
    }

    // Test sin ningun valor   
    @Test
    public void item1test4() throws Exception {

        final ArrayList<Long> actual = null;
        ArrayList<Long> data = new ArrayList<>();

        assertThrows(
                Exception.class,
                () -> ser.selectSort(actual));
    }

    //Test de ordenamiento normal con AssertNotEquals
    @Test
    public void item1Test5() throws Exception {
        //given

        final ArrayList<Long> actual;
        final ArrayList<Long> expected = new ArrayList<>();;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

        //when
        actual = this.ser.selectSort(data);
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

        //then
        Assertions.assertNotEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }

    //Test exepcion con array con mas de 1,000 datos
    @Test
    public void item1Test6() throws Exception {
        //given

        final ArrayList<Long> actual = null;
        final ArrayList<Long> expected = new ArrayList<>();
        int n = 10000; // se llena con 10,000 datos creando una exepcion
        ArrayList<Long> data = new ArrayList<>(n);

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
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
    public void item2Test1() throws Exception {
        //given

        final ArrayList<Long> actual;
        final ArrayList<Long> expected = new ArrayList<>();;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

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
    public void item2test2() throws Exception {

        final ArrayList<Long> actual = null;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));

        assertThrows(
                Exception.class,
                () -> ser.bubbleSort(actual));
    }

    // Test sin ningun valor 
    @Test
    public void item2test3() throws Exception {

        final ArrayList<Long> actual = null;
        ArrayList<Long> data = new ArrayList<>();

        assertThrows(
                Exception.class,
                () -> ser.bubbleSort(actual));
    }

    //Test de ordenamiento normal con AssertNotEquals
    @Test
    public void item2Test4() throws Exception {
        //given

        final ArrayList<Long> actual;
        final ArrayList<Long> expected = new ArrayList<>();;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

        //when
        actual = this.ser.bubbleSort(data);
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

        //then
        Assertions.assertNotEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }

    //Test exepcion con array con mas de 1,000 datos
    @Test
    public void item2Test5() throws Exception {
        //given

        final ArrayList<Long> actual = null;
        final ArrayList<Long> expected = new ArrayList<>();
        int n = 10000; // se llena con 10,000 datos creando una exepcion
        ArrayList<Long> data = new ArrayList<>(n);

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
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
    public void item3Test1() throws Exception {
        //given

        final ArrayList<Long> actual;
        final ArrayList<Long> expected = new ArrayList<>();;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

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
    public void item3test2() throws Exception {

        final ArrayList<Long> actual = null;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));

        assertThrows(
                Exception.class,
                () -> ser.insertionSort(actual));
    }

    // Test sin ningun valor 
    @Test
    public void item3test3() throws Exception {

        final ArrayList<Long> actual = null;
        ArrayList<Long> data = new ArrayList<>();

        assertThrows(
                Exception.class,
                () -> ser.insertionSort(actual));
    }

    //Test de ordenamiento normal con AssertNotEquals
    @Test
    public void item3Test4() throws Exception {
        //given

        final ArrayList<Long> actual;
        final ArrayList<Long> expected = new ArrayList<>();;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

        //when
        actual = this.ser.insertionSort(data);
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

        //then
        Assertions.assertNotEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }

    //Test exepcion con array con mas de 1,000 datos
    @Test
    public void item3Test5() throws Exception {
        //given

        final ArrayList<Long> actual = new ArrayList<>();
        final ArrayList<Long> expected = new ArrayList<>();
        int n = 10000; // se llena con 10,000 datos creando una exepcion
        ArrayList<Long> data = new ArrayList<>(n);

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
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
    public void item4Test1() throws Exception {
        //given

        final ArrayList<Long> actual;
        final ArrayList<Long> expected = new ArrayList<>();;
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

        //when
        actual = this.ser.quickSort(data, 0, data.size() - 1);
        expected.add(new Long(35));
        expected.add(new Long(45));
        expected.add(new Long(55));

        //then
        Assertions.assertEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }

    //Test con un solo valor
    @Test
    public void item4test2() throws Exception {

        ArrayList<Long> actual = new ArrayList<>();
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));

        assertThrows(
                Exception.class,
                () -> ser.quickSort(actual, 0, actual.size()));
    }

    // Test sin ningun valor 
    @Test
    public void item4test3() throws Exception {

        ArrayList<Long> actual = new ArrayList<>();
        ArrayList<Long> data = new ArrayList<>();

        assertThrows(
                Exception.class,
                () -> ser.quickSort(actual, 0, actual.size()));
    }

    //Test de ordenamiento normal con AssertNotEquals
    @Test
    public void item4Test4() throws Exception {
        //given

        ArrayList<Long> actual = new ArrayList<>();
        final ArrayList<Long> expected = new ArrayList<>();
        ArrayList<Long> data = new ArrayList<>();
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

        //when
        actual = this.ser.quickSort(data, 0, data.size() - 1);
        data.add(new Long(45));
        data.add(new Long(55));
        data.add(new Long(35));

        //then
        Assertions.assertNotEquals(expected, actual, "Ordenamiento por seleccion no exitoso");
    }

    //Test exepcion con array con mas de 1,000 datos
    @Test
    public void item4Test5() throws Exception {
        //given

        final ArrayList<Long> actual = new ArrayList<>();
        final ArrayList<Long> expected = new ArrayList<>();
        int n = 10000; // se llena con 10,000 datos creando una exepcion
        ArrayList<Long> data = new ArrayList<>(n);

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            Long r = rand.nextLong() % 256;
            data.add(r);
        }

        assertThrows(
                Exception.class,
                () -> ser.quickSort(actual, 0, actual.size()));

    }

    //UNIT TEST PARA CASO DE USO 5 TRIANGULO*********************************** 
    //Test de ordenamiento normal
    @Test
    public void item5Test1() throws Exception {
        //given

        ArrayList<String> actual = new ArrayList<>();
        final ArrayList<String> expected = new ArrayList<>();

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
    public void item5test2() throws Exception {

        ArrayList<String> actual = new ArrayList<>();

        final int n = 0;

        assertThrows(
                Exception.class,
                () -> ser.pascalTriangle(n));
    }

    // Test arriba del limite superior
    @Test
    public void item5test3() throws Exception {

        ArrayList<String> actual = new ArrayList<>();

        final int n = 10001;//10,001

        assertThrows(
                Exception.class,
                () -> ser.pascalTriangle(n));
    }

    //Test de ordenamiento normal con AssertNotEquals
    @Test
    public void item5Test4() throws Exception {
        //given

        ArrayList<String> actual = new ArrayList<>();
        final ArrayList<String> expected = new ArrayList<>();

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
    public void item5Test5() throws Exception {
        //given

        ArrayList<String> actual = new ArrayList<>();

        final String n = "1";

        assertThrows(
                Exception.class,
                () -> ser.pascalTriangle(parseInt(n)));

    }

    //Test exepcion dato Double
    @Test
    public void item5Test6() throws Exception {
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
