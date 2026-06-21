
package OOP;

// Defining a Class
class Car {
    // Fields / Instance Variables (State)
    String brand;
    String color;
    int maxSpeed;

    // Constructor: A special method used to initialize objects
    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;      // 'this' refers to the current instance variable
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    // Method (Behavior)
    public void displayDetails() {
        System.out.println("Brand: " + brand + ", Color: " + color + ", Max Speed: " + maxSpeed + " km/h");
    }
}

// Main Class to execute code
public class Main {
    public static void main(String[] args) {
        // Creating Objects (Instances of Car)
        Car car1 = new Car("Tesla", "Midnight Silver", 250);
        Car car2 = new Car("Porsche", "Forest Green", 300);

        // Accessing behaviors
        car1.displayDetails();
        car2.displayDetails();
    }
}
