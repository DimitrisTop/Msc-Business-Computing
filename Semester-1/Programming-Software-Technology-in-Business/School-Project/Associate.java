public class Associate extends Teacher{
    private double hourlyWage;
    private int hoursPerMonth;

    public Associate(double hourlyWage, int hoursPerMonth, String lastName, String taxCode) {
        super(lastName,taxCode);
        this.hourlyWage = hourlyWage;
        this.hoursPerMonth = hoursPerMonth;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public int getHoursPerMonth() {
        return hoursPerMonth;
    }

    @Override
    public double totalIncome() {
        return hourlyWage * hoursPerMonth;
    }
}
