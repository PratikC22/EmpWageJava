/**
 * Employee wage program using oops.
 *
 * @author Pratik Chaudhari
 * @since 16/06/2021
 */
package empWage;

public class EmpWage {
	// declaring static variables
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalWage;

	public EmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;

	}

	public void computeEmpWage() {
		// variables
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		// computation
		while (totalEmpHrs <= maxHoursPerMonth && totalWorkingDays < numOfWorkingDays) {

			totalWorkingDays++;

			int empCheck = (int) (Math.random() * 10) % 3;
			// using switch statement to check the employee working time
			switch (empCheck) {

			case IS_FULL_TIME:
				empHrs = 8;
				System.out.println("Employee is present as Full time");
				break;
			case IS_PART_TIME:

				empHrs = 4;
				System.out.println("Employee is working as part time");
				break;
			default:
				empHrs = 0;
				System.out.println("Employee is Absent");
			}
			totalEmpHrs += empHrs;
			System.out.println("Day#" + totalWorkingDays + "Emp Hr:" + empHrs);
		}
		// calculating total Employee wage for company
		totalWage = totalEmpHrs * empRatePerHour;

	}

	@Override
	public String toString() {
		return "Total Emp Wage for Company:" + company + " is: " + totalWage;
	}

	public static void main(String args[]) {

		System.out.println("Welcome to Employee Wage calculation");
		EmpWage dmart = new EmpWage("Dmart", 20, 2, 10);
		EmpWage reliance = new EmpWage(" Reliance ", 5, 25, 25);
		dmart.computeEmpWage();
		System.out.println(dmart);
		reliance.computeEmpWage();
		System.out.println(reliance);
	}

}
