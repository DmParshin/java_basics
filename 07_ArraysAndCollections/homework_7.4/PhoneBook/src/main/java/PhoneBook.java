import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    public static final String NAME = "^[A-ЯЁ][а-яё]*[а-яё]+$";
    public static final String PHONE_NUMBER = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";

    TreeMap<String, String> phonebook = new TreeMap<>();

//    public void addContact(String phone, String name) {
//        // проверьте корректность формата имени и телефона
//        // если такой номер уже есть в списке, то перезаписать имя абонента

    public void addContact(String phone, String name){

        if (name.matches(PhoneBook.NAME)){
            if (phonebook.containsKey(name)){
                System.out.println("Такое имя уже есть: " + name + " - " + phonebook.get(phone));
            }else {
                System.out.println("Такого имени в телефонной книге нет.\nВведите номер телефона для абонента \"" + name + "\"");
                String getStr = UserInput.getLine();
                phonebook.put(name, getStr);
                System.out.println("Контакт сохранен!\n");
            }
        }
        if(phone.matches(PhoneBook.PHONE_NUMBER)){
            if (getNameByPhone(phone) != ""){
                System.out.println("Такой номер уже есть в списке: " + getNameByPhone(phone) + "\nВведите новое имя абонента для номера \"" + phone + "\"" );
                String getStr = UserInput.getLine();
                for( String key : phonebook.keySet()){
                    if (phonebook.get(key).contains(phone)){
                        phonebook.remove(key);
                    }
                }
                phonebook.put(getStr, phone);
                System.out.println("Контакт сохранен\n");

            }
            else {
                System.out.println("Такого номера нет в телефонной книге.\nВведите имя абонента для номера \"" + phone + "\"");
                String getStr = UserInput.getLine();

                if (phonebook.containsKey(getStr)){
                      phonebook.replace(getStr, phonebook.get(getStr), phonebook.get(getStr) + ", " + phone);
                }
                else phonebook.put(getStr, phone);
                System.out.println("Контакт сохранен\n");
            }
        }
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String str = "";
        for (String key : phonebook.keySet()) {
            if (phonebook.get(key).contains(phone)) {
                str = str + key + " - " + phone;
//                System.out.println(key + " - " + phonebook.get(key));
            }
        }
        return str;
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet numbers = new TreeSet();
        for (String key : phonebook.keySet()) {
            if (key.equals(name)) {
                numbers.add(name + " - " + phonebook.get(key));
//                System.out.println(key + " - " + phonebook.get(key));
            }
        }
        return numbers;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        TreeSet numbers = new TreeSet();
        if (!phonebook.isEmpty()){
            for (String key : phonebook.keySet()){
                numbers.add(key + " - " + phonebook.get(key));
                System.out.println(key + " - " + phonebook.get(key));
            }
        }
        return numbers;
    }

}