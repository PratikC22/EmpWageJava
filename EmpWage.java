/***********************************************************************************************************
 * Employee wage computation program
 * 
 * @author Pratik Chaudhari
 * @since 18/06/2021
 ***********************************************************************************************************/
package empWage;

//importing the libraries

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//implementing interface
public class EmpWage implements InterfaceEmpWage {
	// declaring static variables
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
	// Array list
	private ArrayList<CompanyEmpWage> companyEmpArrayList;
	private Map<String, CompanyEmpWage> companyToEmpWageMap;

	// using constructor
	public EmpWage() {
		companyEmpArrayList = new ArrayList<CompanyEmpWage>();
		companyToEmpWageMap = new HashMap<>();

	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {

		CompanyEmpWage companyEmpwage = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		companyEmpArrayList.add(companyEmpwage);
		companyToEmpWageMap.put(company, companyEmpwage);
	}

	public void DisplayDailyWageforCompany(CompanyEmpWage companyEmpwage) {
		for (int i = 0; i < companyEmpwage.empDailyWage.size(); i++) {
			int day = i + 1;
			System.out.println("Daily Wage For Day" + day + ":" + companyEmpwage.empDailyWage.get(i));
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
		// main method
		System.out.println("Welcome to Employee Wage calculation");
		EmpWage empwage = new EmpWage();
		empwage.addCompanyEmpWage("Dmart", 20, 20, 100);
		empwage.addCompanyEmpWage(" BigBazar ", 5, 50, 200);
		empwage.computeWage();
		System.out.println("Total Wage for Dmart:" + empwage.getTotalWage("Dmart"));
		System.out.println("Total Wage for BigBazar:" + empwage.getTotalWage("BigBazar"));
	}

	@Override
	public void computeWage() {
		for (int i = 0; i < companyEmpArrayList.size(); i++) {
			CompanyEmpWage companyEmpWage = companyEmpArrayList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println("Company Name : " + companyEmpWage.company);
			DisplayDailyWageforCompany(companyEmpWage);
			System.out.println("Total Wage is:" + companyEmpWage.totalWage);
		}

	}

	@Override
	public int getTotalWage(String company) {
		return companyToEmpWageMap.get(company).totalWage;
	}

}
