//        Manager — зарплата складывается из фиксированной части и бонуса в виде 5% от заработанных для компании денег.
//        Количество заработанных денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей

package company;

public class Manager implements Employee {

    private final double MIN_INCOME = 115000;
    private final double MAX_INCOME = 140000;

    private final double FIX_SALARY = 50000;
    private double MONTH_SALARY;
    private String position = "Manager";

    public Manager() {
        getPosition();
        getMonthSalary();
    }

    @Override
    public double getMonthSalary() {
        double random_income = MIN_INCOME + (Math.random() * MAX_INCOME);
        MONTH_SALARY = Math.round(FIX_SALARY + ((random_income * 5) / 100));
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
