
import java.util.Date;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
//        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year
        Date setDate = new Date(year - 1900,01,01);
//        System.out.println(setDate);
        staff.stream()
                .map(employee -> employee)
                .filter(employee -> employee.getWorkStart().after(setDate))
                .max((o1, o2) -> o1.getSalary())
                .ifPresent(System.out::println);
        return null;
    }
}