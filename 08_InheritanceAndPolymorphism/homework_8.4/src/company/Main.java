package company;

public class Main {
    public static void main(String[] args){
        Company test = new Company("test", 15000000);
        test.setIncome(15000000);

        System.out.println(test.getIncome());

        Employee operator = new Operator();
        test.hire(operator);
        test.fire(operator);

        test.hireAll("Operator", 180);
        test.hireAll("TopManager", 10);
        test.hireAll("Manager", 80);

        int count = test.employees.size() / 2;
        System.out.println(count);
        test.fireAll(count);

//        test.printAll();

        test.getLowestSalaryStaff(11);
        test.getTopSalaryStaff(7);

    }
}
