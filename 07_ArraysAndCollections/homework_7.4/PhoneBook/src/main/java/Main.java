public class Main {
    private PhoneBook phoneBook;

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        for (; ; ) {
            System.out.println("Введите номер, имя или команду:");
            String userInput = UserInput.getLine();

            if (userInput.matches(PhoneBook.NAME) || userInput.matches(PhoneBook.PHONE_NUMBER)){
                phoneBook.addContact(userInput, userInput);
            }
            else if (userInput.equals("LIST")) {
                phoneBook.getAllContacts();
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }
}

