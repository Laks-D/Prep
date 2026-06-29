class SmartThermostat {
    // Private state: Cannot be modified directly by external code
    private double currentTemperature;
    private final double MIN_LIMIT = 16.0; // Celsius
    private final double MAX_LIMIT = 32.0; // Celsius

    // Constructor
    public SmartThermostat(double initialTemp) {
        // Default to a safe room temperature if initial input is out of bounds
        if (initialTemp >= MIN_LIMIT && initialTemp <= MAX_LIMIT) {
            this.currentTemperature = initialTemp;
        } else {
            this.currentTemperature = 22.0; 
        }
    }

    // Getter: Allows read access to the temperature
    public double getCurrentTemperature() {
        return this.currentTemperature;
    }

    // Setter: Enforces strict guardrails before updating the state
    public void setTemperature(double newTemp) {
        if (newTemp >= MIN_LIMIT && newTemp <= MAX_LIMIT) {
            System.out.println("Adjusting temperature to " + newTemp + "°C.");
            this.currentTemperature = newTemp;
        } else {
            // Reject invalid state transitions gracefully
            System.out.println("Error: Temperature " + newTemp + "°C is out of safe operational limits (" + MIN_LIMIT + "°C - " + MAX_LIMIT + "°C).");
        }
    }
}

public class ThermostatDemo {
    public static void main(String[] args) {
        SmartThermostat nest = new SmartThermostat(24.0);

        // nest.currentTemperature = 500.0; // COMPILE ERROR: Variable is private

        // Trying an invalid update
        nest.setTemperature(45.0); 
        
        // Trying a valid update
        nest.setTemperature(18.5);
        System.out.println("Current Nest Temp: " + nest.getCurrentTemperature() + "°C");
    }
}
