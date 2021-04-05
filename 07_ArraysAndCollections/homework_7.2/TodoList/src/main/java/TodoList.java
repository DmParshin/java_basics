import java.util.ArrayList;

public class TodoList {

    ArrayList<String> todoList = new ArrayList<>();

    public TodoList() {
        ArrayList<String> todoList = new ArrayList<>();
        this.todoList.add("Список дел:");
    }

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        this.todoList.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index <= todoList.size()){ this.todoList.add(index, todo); }
        else { this.todoList.add(todo);}
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index < todoList.size()){this.todoList.set(index, todo);}

    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < todoList.size()){this.todoList.remove(index);}
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        for (int i = 0; i < todoList.size(); i++){
            System.out.println(i + " - " + todoList.get(i));
        }
        return this.todoList;
    }

}