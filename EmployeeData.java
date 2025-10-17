import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeData {
    public static List<Employee> get() {
        return new ArrayList<Employee>(Arrays.asList(
            new Employee(1, "Sienna", "Toyota", "DEV", "CEO", 50000.00, 25),
            new Employee(2, "LandCruise", "Toyota", "HR", "CEO", 60000.00, 45),
            new Employee(3, "Camry", "Toyota", "PRODUCT", "CEO", 40000.00, 28),
            new Employee(4, "Odyssey", "Honda", "ADMIN", "CEO", 43000.00, 23),
            new Employee(5, "Accord", "Honda", "DEV", "CEO", 35000.00, 22),
            new Employee(6, "Rogue", "Nissan", "PRODUCT", "CEO", 25000.00, 31),
            new Employee(7, "Pathfinder", "Nissan", "DEV", "CEO", 35000.00, 37),
            new Employee(8, "QX80", "Infinity", "PRODUCT", "CEO", 48000.00, 41),
            new Employee(9, "Tahoe", "Chevrolet", "HR", "CEO", 45000.00, 34),
            new Employee(10, "Navigator", "Lincoln", "DEV", "CEO", 44000.00, 27),
            new Employee(11, "Suburban", "Chevrolet", "ADMIN", "CEO", 480000.00, 39)
        ));
    }
}
