//Создайте класс компании Company, содержащей сотрудников и реализующей методы:
//        найм одного сотрудника — hire(),
//        найм списка сотрудников – hireAll(),
//        увольнение сотрудника – fire(),
//        получение значения дохода компании – getIncome().
// Аргументы и возвращаемое значение методов выберите на основании логики работы вашего приложения.

package company;
import java.util.ArrayList;

public class Company {

    public ArrayList<Employee> employees = new ArrayList<>();

    public static double income;
    public String name;

    public Company(String name, double income) {
        this.name = name;
        this.income = income;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getName(){
        return name;
    }

    public static double getIncome() {
        return income;
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void fire (Employee employee){
        employees.remove(employee);
    }

    public void printAll (){
        for (Employee employee : employees){
            System.out.println(employee.getToString());
        }
    }

    public ArrayList<Employee> hireAll (String position, int count){
            for (int i = 0; i < count; i++) {
                switch (position) {
                    case "Operator":
                        employees.add(new Operator());
                        break;
                    case "Manager":
                        employees.add(new Manager());
                        break;
                    case "TopManager":
                        employees.add(new TopManager());
                        break;
                }
            }
        return employees;
    }

    public ArrayList<Employee> fireAll (int count) {
        if (count > 0 && count < employees.size()) {
            for (int i = 0; i < count; i++) {
                employees.remove(i);
            }
        }
        return employees;
    }
    public ArrayList<Employee> getLowestSalaryStaff ( int count ){
        if (count > 0 && count < employees.size()) {
            employees.sort(new EmployeeComparator());
            System.out.println(count + " lowest salary ");
            int i = 0;
            for (Employee employee : employees) {
                if (i < count) {
                    System.out.println(employee.getToString());
                    i++;
                }
            }
        }
        return null;
    }

    public ArrayList<Employee> getTopSalaryStaff ( int count ){
        if (count > 0 && count < employees.size()) {
            employees.sort(new EmployeeComparator().reversed());
            System.out.println(+count + " top salary:");
            int i = 0;
            for (Employee employee : employees) {
                if (i < count) {
                    System.out.println(employee.getToString());
                    i++;
                }
            }
        }
        return null;
    }


}
