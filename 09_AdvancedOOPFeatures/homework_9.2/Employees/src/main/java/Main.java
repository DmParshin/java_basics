
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Date setDate = new Date(year - 1900,00,00);
//        System.out.println(setDate);
        Optional <Employee> optional =staff.stream()
                .map(employee -> employee)
                .filter(employee -> employee.getWorkStart().after(setDate))
                .max(Comparator.comparing(Employee::getSalary));

        return optional.get();

    }
}