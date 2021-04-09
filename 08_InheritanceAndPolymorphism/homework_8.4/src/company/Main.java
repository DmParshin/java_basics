package company;

public class Main {
    public static void main(String[] args){
        Company test = new Company("test", 15000000);
        test.setIncome(15000000);

        Company test1 = new Company("test1", 15000000);
        test1.setIncome(25000000);

        System.out.println(test.getIncome());

        System.out.println(test1.getIncome());

        Employee operator = new Operator();
        test.hire(operator);

        Operator operator1 = new Operator();
        test.hire(operator1);

        TopManager topManager = new TopManager(test1);
        test1.hire(topManager);

//        test.fire(operator);
//        test.hireAll("Operator", 120);
//        test.hireAll("Operator", 180);
//        test.hireAll("TopManager", 10);
//        test.hireAll("Manager", 80);
//        test.fireAll(35);

        test.printAll();
        test1.printAll();

//        test.getTopSalaryStaff(7);
//        test.getLowestSalaryStaff(11);

    }
}
