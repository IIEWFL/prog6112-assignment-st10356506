import java.util.ArrayList;
import java.util.Scanner;

// Car class to represent individual cars
//create car attributes
class Vehicle {
    public String make;
    public String model;
    public String colour;
    public int year;
    public double price;
//initalize the vehicle arrtibutes
    public Vehicle(String make, String model, String colour, int year, double price) {
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.year = year;
        this.price = price;
    }

    @Override
    // overrides a method in the superclass
    //https://docs.oracle.com/javase/tutorial/java/land/override.html#:~:text=When%20overriding%20a%20method%2C%2you,it%20%will%20generate%20an%20error.
    public String toString() {
        //converts user input to string
        return "Make: " + make + "\nModel: " + model + "\nColour: " + colour + "\nYear: " + year + "\nPrice: R" + price + "\n";
    }
}

// CarInventory class to manage car data
class CarInventory {
     //create car array to store user input
    private ArrayList<Vehicle> cars;

    public CarInventory() {
       //initialize the array list
        cars = new ArrayList<>();
    }

    public void addCar(Vehicle car) {
        cars.add(car);
        //message to be displayed if car is added successfully
        System.out.println("Car successfully added");
    }

    public void listCars() {
        if (cars.isEmpty()) {
            //message to be displayed if inventory is empty
            System.out.println("Inventory is empty");
            return;
        }

        System.out.println("Car Inventory : ");
        //displays all the cars in the inventory
        for (Vehicle car : cars) {
            System.out.println(car);
        }
    }

    public Vehicle searchCar(String make, String model, int year) {
          //https://stackoverflow.com/questions/12496038/searching-in-a-arraylist-with-custom-objects-for-certain-strings
        for (Vehicle car : cars) {
            if (car.make.equalsIgnoreCase(make) && car.model.equalsIgnoreCase(model) && car.year == year) {
                return car;
            }
        }
        return null; // Car not found
    }
}

public class TunersParadise {
    public static void main(String[] args) {
       menu();
    }
    public static void menu(){
         Scanner scanner = new Scanner(System.in);
        CarInventory carInventory = new CarInventory();

        System.out.println("Welcome to Tuners Paradise! ");

        while (true) {
             //https://www.theserverside.com/blog/Coffee-Talk-Java-News-Stories-and-Opinions/Java-user-input-with-a-Swing-JOptionPane-example
             //above reference does apply to joptionpane but was useful to me in this example
            //while loop loops until user exits application
            System.out.println("\nMenu:" + "\n"
                               +"1. Add Car to Inventory" + "\n"
                               +"2. List Available Cars" + "\n"
                               +"3. Search for a Car" + "\n"
                               +"4. Exit" + "\n");
            System.out.print("Enter function : ");
            int choice = scanner.nextInt();
            scanner.nextLine(); //scan user input and store it into the array

            switch (choice) {
                case 1:
                    System.out.print("Enter Make : ");
                    String make = scanner.nextLine();
                    System.out.print("Enter Model : ");
                    String model = scanner.nextLine();
                    System.out.println("Enter Colour : ");
                    String colour = scanner.nextLine();
                    System.out.print("Enter Year : ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Price: R");
                    double price = scanner.nextDouble();
                    Vehicle car = new Vehicle(make, model, colour, year, price);
                    carInventory.addCar(car);
                    break;
                    //break statement used to break the loop therefore avoiding an infinite loop.
                    //https://www.programiz.com/java-programming/break-statement#:~:text=The%20break%20statement%20in%20Java,...else%20Statement).
                case 2:
                    carInventory.listCars();
                    break;
                    //breaks the loop
                case 3:
                    System.out.print("Enter Make: ");
                    String searchMake = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    String searchModel = scanner.nextLine();
                    System.out.print("Enter Year: ");
                    int searchYear = scanner.nextInt();
                    Vehicle foundCar = carInventory.searchCar(searchMake, searchModel, searchYear);
                    if (foundCar != null) {
                        System.out.println("Car Found:\n" + foundCar);
                    } else {
                        System.out.println("Car not found in inventory.");
                    }
                    break;
                    //breaks the loop
                case 4:
                    System.out.println("Goodbye :)");
                    scanner.close();
                    System.exit(0);
                    //https://stackoverflow.com/questions/7951690/how-do-i-exit-a-while-loop-in-java
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
