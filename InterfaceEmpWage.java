package empWage;
   //using interface
public interface InterfaceEmpWage {
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);

	public void computeWage();
	public int getTotalWage(String company);
}
