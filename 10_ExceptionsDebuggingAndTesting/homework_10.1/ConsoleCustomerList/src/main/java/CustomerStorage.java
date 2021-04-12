import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        final String patternEmail = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
        final String patternPhone = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{10}$";

        String[] components = data.split("\\s+");

        if(components.length!=4) {
            throw new IllegalArgumentException("Wrong format. Correct format - add Василий Петров vasily.petrov@gmail.com +79215637722");}

        else if (!Pattern.matches(patternEmail,components[INDEX_EMAIL])) {
            throw new IllegalArgumentException("Wrong Email format. Correct format - vasily.petrov@gmail.com");}

        else if (!Pattern.matches(patternPhone,components[INDEX_PHONE])) {
            throw new IllegalArgumentException("Wrong phone number format. Correct format - +79215637722");}

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));

        }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if(!storage.containsKey(name)) {
            throw new IllegalArgumentException("Wrong name. Name is not found");}
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}