package company;

public class Main {
    public static void main(String[] args){
        Company test = new Company("test", 15000000);
        test.setIncome(15000000);

        Company test1 = new Company("test1", 15000000);
        test.setIncome(25000000);

        System.out.println(test.getIncome());

        System.out.println(test1.getIncome());

        Employee operator = new Operator();
        test.hire(operator);

        test.fire(operator);
        test.hireAll(new Operator(), 180);
        test.hireAll(new TopManager(), 10);
        test.hireAll(new Manager(), 80);
        test.fireAll(135);

//        test.printAll();

        test.getTopSalaryStaff(7);
        test.getLowestSalaryStaff(11);

    }
}
