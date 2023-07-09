import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        menuTodo();

    }

    public static void menuTodo(){
        String input = null;
        do {
            System.out.println("Todo List Sederhana");
            System.out.println("1. Tambah todo");
            System.out.println("2. Update todo");
            System.out.println("3. Hapus todo");
            System.out.println("4. Lihat todo");
            System.out.println("5. Exit");
            System.out.print("Masukan Pilihan : ");
            input = sc.nextLine();
            switch (input){
                case "1" :
                    System.out.println("Tambah Todo");
                    System.out.print("Masukan Todo : ");
                    String todoInput = sc.nextLine();
                    String addTodoRes = TodoListService.addTodo(todoInput);
                    System.out.println(addTodoRes);
                    break;
                case "2" :
                    System.out.println("Update Todo");
                    System.out.println("Masukan Id : ");
                    Integer id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Masukan Todo Baru : ");
                    String newTodo = sc.nextLine();
                    Integer resultTodo = TodoListService.updateTodo(id, newTodo);
                    if(resultTodo == 0) {
                        System.out.println("Berhasil Merubah Todo");
                    }else {
                        System.out.println("Gagal Merubah Todo Dengan Id : " + resultTodo);
                    }
                    break;
                case "3" :
                    System.out.print("Hapus Todo : ");
                    Integer deleteId = sc.nextInt();
                    boolean deletedTodo = TodoListService.deleteTodo(deleteId);
                    if(deletedTodo){
                        System.out.println("Berhasil Menghapus Todo");
                    }
                    sc.nextLine();
                    break;
                case "4" :
                    TodoListService.allTodo();
                    break;
                case "5" :
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }while (!"5".equals(input));
    }
}