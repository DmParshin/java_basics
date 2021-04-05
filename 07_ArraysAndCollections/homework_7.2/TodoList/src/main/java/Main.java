import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        Scanner in = new Scanner(System.in);
        String task;
        String task1;
        Integer number;

        while(true){
            System.out.println("Введите команду: ");
            String command = in.nextLine();
            switch (command){
                case "ADD":
                    System.out.println("Введите дело");
                    task = in.nextLine();
                    System.out.println("Введите номер в списке");
                    number = in.nextInt();
                    todoList.add(number, task);
                    break;
                case "EDIT":
                    System.out.println("Введите дело");
                    task = in.nextLine();
                    System.out.println("Введите номер в списке");
                    number = in.nextInt();
                    todoList.edit(task, number);
                    break;
                case "DELETE":
                    System.out.println("Введите номер в списке");
                    number = in.nextInt();
                    todoList.delete(number);
                    break;
                case "LIST":
                    todoList.getTodos();
                    break;
                case "EXIT":
                    return;
            }
        }
//        return;
    }
}

