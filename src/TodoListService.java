public class TodoListService {

    public static String[] todoList = new String[5];

    public static String addTodo(String todo) {
        boolean isEmpty = true;

        for (String todos : todoList) {
            if (todos != null) {
                isEmpty = false;
                break;
            }
        }

        if (!isEmpty) {
            var temp = todoList;
            todoList = new String[todoList.length * 2];
            for (int i = 0; i < temp.length; i++) {
                todoList[i] = temp[i];
            }
        }

        for (int i = 0; i < todoList.length; i++) {
            if (todoList[i] == null) {
                todoList[i] = todo;
                return "Berhasil Menambahkan Todo";
            }
        }
        return null;
    }

    public static Integer updateTodo(Integer id, String todo) {
        if (id < 0) return -1;

        if (id > todoList.length) return -1;

        for (int i = 0; i < todoList.length; i++) {
            if ((id - 1) == i) {
                todoList[i] = todo;
                return 0;
            }
        }
        return -1;
    }

    public static boolean deleteTodo(Integer id) {
        id = id - 1;

        if(id < 0) return false;
        if(id > todoList.length) return false;

        for (int i = id; i < todoList.length; i++) {
            if(i == (todoList.length - 1)){
                todoList[i] = null;
            }else {
                todoList[i] = todoList[i + 1];
            }
        }
        return true;
    }

    public static void allTodo() {
        if(todoList.length == 0){
            System.out.println("Data masih kosong");
        }
        for (int i = 0; i < todoList.length; i++) {
            if(todoList[i] != null) {
                System.out.println((i + 1) + ". " + todoList[i]);
            }
        }
    }
}
