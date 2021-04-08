//TopManager — зарплата складывается из фиксированной части и бонуса в виде 150% от заработной платы,
//если доход компании более 10 млн рублей.
package company;

public class TopManager implements Employee{

    private final double FIX_SALARY = 50000;
    private double MONTH_SALARY;
    private String position = "Top-manager";

    public TopManager() {
        getPosition();
        getMonthSalary();
    }


    @Override
    public double getMonthSalary() {
        if (Company.getIncome() > 10000000) {
            this.MONTH_SALARY = (FIX_SALARY + ((FIX_SALARY * 150) / 100));
        } else {
            this.MONTH_SALARY = FIX_SALARY;
        }
        return this.MONTH_SALARY;
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
