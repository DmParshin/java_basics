package company;

public class Operator implements Employee {

    private final double FIX_SALARY = 50000;
    private final double MONTH_SALARY = FIX_SALARY;
    private String position = "Operator";

    public Operator() {
        getPosition();
        getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        return MONTH_SALARY;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public String getToString() {
        return position + ": " + MONTH_SALARY;
    }
}
