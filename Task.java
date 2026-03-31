public class Task {
    private String title;
    private String deadline;
    private String priority;
    private String category;
    private boolean isCompleted;

    public Task(String title, String deadline, String priority, String category, boolean isCompleted) {
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
        this.category = category;
        this.isCompleted = isCompleted;
    }

    public String getTitle() { return title; }
    public String getDeadline() { return deadline; }
    public String getPriority() { return priority; }
    public String getCategory() { return category; }
    public boolean isCompleted() { return isCompleted; }

    public void markCompleted() { isCompleted = true; }

    @Override
    public String toString() {
        return title + "|" + deadline + "|" + priority + "|" + category + "|" + isCompleted;
    }
}