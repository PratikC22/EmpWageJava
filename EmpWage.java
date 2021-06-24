/***************************************************************************************************
 * Employee wage computation program using interface.
 * 
 * @author Pratik Chaudhari
 * @since 16/06/2021
 ***************************************************************************************************/
package empWage;
//implementing the interface
public class EmpWage implements InterfaceEmpWage {
	// declaring static variables
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmpWage() {
		companyEmpWageArray = new CompanyEmpWage[5];
	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays,
				maxHoursPerMonth);
		numOfCompany++;
	}

	public void computeEmpWage() {
		for (int i = 0; i < numOfCompany; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}

	public int computeEmpWage(CompanyEmpWage companyEmpWage) {
		// variables
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		// computation
		while (totalEmpHrs <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {

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
		return totalEmpHrs * companyEmpWage.empRatePerHour;

	}

	public static void main(String args[]) {

		System.out.println("Welcome to Employee Wage calculation");
		EmpWage empwage = new EmpWage();
		empwage.addCompanyEmpWage(" Dmart ", 20, 2, 10);
		empwage.addCompanyEmpWage(" Reliance ", 5, 25, 25);
		empwage.computeEmpWage();
	}

	@Override
	public void computeWage() {
		
	}

}
