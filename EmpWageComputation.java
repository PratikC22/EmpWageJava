/**
 * Employee wage computation problem.
 *
 * @author Pratik Chaudhari
 * @since 14/06/2021
 */
package EmpWage;

public class Wage {
    // Constants.
    public static final int FULL_TIME = 1;
    public static final int PART_TIME = 2;
    public static final int WAGE_PER_HOUR = 20;
    public static final int DAYS_PER_MONTH = 20;
    public static final int MAX_WORK_HOURS = 100;

    // Printing welcome statement.
    void greet() {      // Printing welcome statement.
        System.out.println("Welcome to employee wage computation.");
    }
    // Calculating employee wage
    void empWage() {
        int empHours,totalHours = 0, workingDays = 0;           // Variables
        while (workingDays <= DAYS_PER_MONTH && totalHours <= MAX_WORK_HOURS) {
            int empCheck = (int) (Math.floor(Math.random() * 10)) % 3;          //Using random for generating employee attendance.
            empHours = switch (empCheck) {          //Using switch to simulate full time, part time or absent.
                case FULL_TIME -> 8;        // If full time then empHrs = 8.
                case PART_TIME -> 4;        // If part time then empHrs = 4.
                default -> 0;               // if absent then empHrs = 0.
            };
            totalHours = totalHours + empHours;     // Calculating total working hours.
            workingDays++;
        }
        int dailyWage = totalHours * WAGE_PER_HOUR;     // Calculating daily wage.
        System.out.println("Employee wage is "+dailyWage);
    }
    public static void main(String[] args) {
        Wage Employee = new Wage();     // Creating object named Employee.
        Employee.greet();           // Calling greet method.
        Employee.empWage();         // Calling empWage method.
    }
}
