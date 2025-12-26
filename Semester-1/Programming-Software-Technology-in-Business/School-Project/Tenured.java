public class Tenured extends Teacher{
    private double monthlyIncome;
    private double deductionRate;
    private int protectedMembers;


    public Tenured(double montlyIncome, double deductionRate, int protectedMembers, String lastName, String taxCode) {
        super(lastName, taxCode);
        this.monthlyIncome = montlyIncome;
        this.deductionRate = deductionRate;
        this.protectedMembers = protectedMembers;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getDeductionRate() {
        return deductionRate;
    }

    public int getProtectedMembers() {
        return protectedMembers;
    }

    @Override
    public double totalIncome() {
        return monthlyIncome * (1-deductionRate) + protectedMembers * 100;
    }
}

