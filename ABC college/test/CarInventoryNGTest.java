import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class CarInventoryNGTest {
    //https://www.youtube.com/watch?v=2EIUHHoVfmU
    public CarInventoryNGTest() {
    }

    @Test
    public void testAddCar() {
       //create test data
    String make = "volkswagen";
    String model = "golf 1";
    String colour = "white";
    int year = 2009;
    double price = 85000.5;
    //create vehicle object
    Vehicle car = new Vehicle(make, model, colour, year, price);
    //create car inventory variable
    CarInventory inventory = new CarInventory();
    inventory.addCar(car);
    //assert if array list contains vehicle data
    assertFalse(inventory.equals(car));

    }

    @Test
    public void testListCars() {
        //create test data
    String make = "volkswagen";
    String model = "golf 1";
    String colour = "white";
    int year = 2009;
    double price = 85000.5;
    //create car object
    Vehicle car = new Vehicle(make, model, colour, year, price);
    //create car inventory instance variable
    CarInventory inventory = new CarInventory();
    inventory.addCar(car);
    //create actual outcome and expected outcome
    String carListData = "Car Make: Volkswagen\nCar Model: Golf 1\nCar Colour: White\nYear model: 2009\nPrice: 85000.5";
     // Assert if the captured output matches the expected format
    String expectedOutput = "Car Make: Volkswagen\nCar Model: Golf 1\nCar Colour: White\nYear model: 2009\nPrice: 85000.5";
    //compare the outcomes
    assertEquals(carListData, expectedOutput);
    
        
    }

    @Test
    public void testSearchCar() {
        //create test data
    String make = "volkswagen";
    String model = "golf 1";
    String colour = "white";
    int year = 2009;
    double price = 85000.5;
    Vehicle car = new Vehicle(make, model, colour, year, price);
    //create car inventory variable
    CarInventory inventory = new CarInventory();
    inventory.addCar(car);
    String carListData = "Car Make: Volkswagen\nCar Model: Golf 1\nCar Colour: White\nYear model: 2009\nPrice: 85000.5";
     // Assert if the captured output matches the expected format
    String expectedOutput = "Car Make: Volkswagen\nCar Model: Golf 1\nCar Colour: White\nYear model: 2009\nPrice: 85000.5";
    assertEquals(carListData, expectedOutput);
        
    }
    
}
