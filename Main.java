import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        while (true) {
            System.out.println("\n==== Student Task Manager ====");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. View Pending Tasks");
            System.out.println("4. Mark Task Completed");
            System.out.println("5. Delete Task");
            System.out.println("6. Search Task");
            System.out.println("7. Sort by Deadline");
            System.out.println("8. Show Statistics");
            System.out.println("9. Exit");
            System.out.print("Choose: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Deadline (dd-MM-yyyy): ");
                    String deadline = sc.nextLine();

                    System.out.print("Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    System.out.print("Category (Assignment/Lab/Exam/Personal): ");
                    String category = sc.nextLine();

                    manager.addTask(title, deadline, priority, category);
                    break;

                case 2:
                    manager.viewTasks();
                    break;

                case 3:
                    manager.viewPendingTasks();
                    break;

                case 4:
                    System.out.print("Enter task number: ");
                    try {
                        int completeIndex = Integer.parseInt(sc.nextLine()) - 1;
                        manager.markTaskCompleted(completeIndex);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid task number.");
                    }
                    break;

                case 5:
                    System.out.print("Enter task number: ");
                    try {
                        int deleteIndex = Integer.parseInt(sc.nextLine()) - 1;
                        manager.deleteTask(deleteIndex);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid task number.");
                    }
                    break;

                case 6:
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    manager.searchTask(keyword);
                    break;

                case 7:
                    manager.sortByDeadline();
                    break;

                case 8:
                    manager.showStatistics();
                    break;

                case 9:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Choose between 1-9.");
            }
        }
    }
}