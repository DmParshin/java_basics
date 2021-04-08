//        В классе Main реализуйте метод sortBySalaryAndAlphabet(), который должен выполнить сортировку переданного списка
//        сотрудников по заработной плате и алфавиту. То есть в начале списка будут минимальные значения зарплат,
//        если значение зарплат одинаковое у сотрудников, то сотрудники с одинаковой зарплатой должны быть отсортированы
//        по Ф. И. О.

import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
//        System.out.println(staff);
        sortBySalaryAndAlphabet(staff);

    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {

        System.out.println("**************          Unsorted          **************");
        for(Employee i : staff){
            System.out.println(i);
        }

        Collections.sort(staff, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        System.out.println("**************          Sort by name          **************");
        for(Employee i : staff){
            System.out.println(i);
        }

        Collections.sort(staff, (o1, o2)-> o1.getSalary().compareTo(o2.getSalary()));

        System.out.println("**************          Sort by salary          **************");
        for(Employee i : staff){
            System.out.println(i);
        }
    }
}