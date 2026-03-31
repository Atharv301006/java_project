import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private final String fileName = "tasks.txt";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public TaskManager() {
        loadTasks();
    }

    public void addTask(String title, String deadline, String priority, String category) {
        tasks.add(new Task(title, deadline, priority, category, false));
        saveTasks();
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.printf("%d. %s | %s | %s | %s | Completed: %b\n",
                    i + 1,
                    t.getTitle(),
                    t.getDeadline(),
                    t.getPriority(),
                    t.getCategory(),
                    t.isCompleted());
        }
    }

    public void viewPendingTasks() {
        boolean found = false;
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            if (!t.isCompleted()) {
                System.out.println((i + 1) + ". " + t.getTitle() + " | " + t.getDeadline());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No pending tasks.");
        }
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            saveTasks();
            System.out.println("Task marked complete.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasks();
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void searchTask(String keyword) {
        boolean found = false;
        for (Task t : tasks) {
            if (t.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(t.getTitle() + " | " + t.getDeadline() + " | Completed: " + t.isCompleted());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found matching '" + keyword + "'.");
        }
    }

    public void sortByDeadline() {
        tasks.sort((a, b) -> {
            try {
                LocalDate da = LocalDate.parse(a.getDeadline(), formatter);
                LocalDate db = LocalDate.parse(b.getDeadline(), formatter);
                return da.compareTo(db);
            } catch (DateTimeParseException e) {
                return a.getDeadline().compareTo(b.getDeadline());
            }
        });
        viewTasks();
    }

    public void showStatistics() {
        long completed = tasks.stream().filter(Task::isCompleted).count();
        System.out.println("Total Tasks: " + tasks.size());
        System.out.println("Completed: " + completed);
        System.out.println("Pending: " + (tasks.size() - completed));
    }

    private void saveTasks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Task t : tasks) {
                bw.write(t.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    private void loadTasks() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("\\|");
                if (p.length >= 5) {
                    tasks.add(new Task(p[0], p[1], p[2], p[3], Boolean.parseBoolean(p[4])));
                }
            }
        } catch (IOException e) {
            // first run or missing file
        }
    }
}