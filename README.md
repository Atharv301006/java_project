# Java Project — 24BCY10463

> **Programming in Java Project** | VITyarthi | Programming in Java Flipped Course

---

## Student Information

| Field | Details |
|---|---|
| **Name** | Atharv Gupta |
| **Roll Number** | 24BCY10463 |
| **Slot** | B14+D21 |
| **Date of Submission** | 31 March 2026 |

---

# Student Task Manager

A simple yet powerful command-line application built in Java to help students manage their academic tasks — assignments, labs, exams, and personal to-dos — all saved persistently to a local file.

---

## Features

-  **Add Tasks** — with title, deadline, priority, and category
-  **View All Tasks** — see every task with its full details
-  **View Pending Tasks** — quickly filter incomplete tasks
-  **Mark as Completed** — update task status with one step
-  **Delete Tasks** — remove tasks you no longer need
-  **Search Tasks** — find tasks by keyword in the title
-  **Sort by Deadline** — automatically sort tasks by due date
-  **Statistics** — view total, completed, and pending task counts
-  **Persistent Storage** — tasks are saved to `tasks.txt` and reloaded on startup

---

##  Project Structure

```
StudentTaskManager/
│
├── Main.java          # Entry point — handles menu and user input
├── Task.java          # Task model — stores task fields and state
├── TaskManager.java   # Core logic — CRUD, search, sort, file I/O
└── tasks.txt          # Auto-generated file for persistent task storage
```

---

## Prerequisites

- **Java JDK 8 or above** installed on your system
- A terminal / command prompt

---

##  How to Compile & Run

**1. Clone or download the project files**

**2. Open terminal in the project folder**

**3. Compile all Java files:**
```bash
javac Main.java Task.java TaskManager.java
```

**4. Run the application:**
```bash
java Main
```

---

## Usage

Once running, you'll see the main menu:

```
==== Student Task Manager ====
1. Add Task
2. View All Tasks
3. View Pending Tasks
4. Mark Task Completed
5. Delete Task
6. Search Task
7. Sort by Deadline
8. Show Statistics
9. Exit
Choose:
```

Enter the number of your desired option and follow the prompts.

### Adding a Task
```
Title: Math Assignment
Deadline (dd-MM-yyyy): 05-04-2026
Priority (High/Medium/Low): High
Category (Assignment/Lab/Exam/Personal): Assignment
```

### Viewing All Tasks
```
1. Math Assignment | 05-04-2026 | High | Assignment | Completed: false
2. Physics Lab     | 10-04-2026 | Medium | Lab       | Completed: false
```

### Show Statistics
```
Total Tasks: 2
Completed: 1
Pending: 1
```

---

## Task Fields

| Field      | Description                              | Example Values                        |
|------------|------------------------------------------|---------------------------------------|
| Title      | Name of the task                         | `Math Assignment`                     |
| Deadline   | Due date in `dd-MM-yyyy` format          | `05-04-2026`                          |
| Priority   | Urgency level                            | `High`, `Medium`, `Low`               |
| Category   | Type of task                             | `Assignment`, `Lab`, `Exam`, `Personal` |
| Completed  | Completion status (auto-managed)         | `true` / `false`                      |

---

## 💾 Data Storage

Tasks are automatically saved to a file named **`tasks.txt`** in the same directory as the program. Each task is stored as a pipe-separated line:

```
Math Assignment|05-04-2026|High|Assignment|false
Physics Lab|10-04-2026|Medium|Lab|true
```

This file is loaded automatically every time the program starts, so your tasks are never lost.

---

## Known Limitations

- Deadline format must be strictly `dd-MM-yyyy` — invalid formats may cause sorting issues
- No input validation on Priority and Category fields (free text is accepted)
- No edit/update feature for existing tasks — delete and re-add as a workaround
- Single-user, local storage only — not suitable for multi-user environments

---

##  Possible Future Improvements

- [ ] Edit existing tasks
- [ ] Due-date reminder / overdue highlighting
- [ ] Filter tasks by category or priority
- [ ] Export tasks to CSV or PDF
- [ ] Colored terminal output for better readability
- [ ] GUI version using JavaFX or Swing

---

## 👨‍💻 Author

Built as a student utility project in Java. Feel free to fork, modify, and improve!

---

## 📄 License

This project is open-source and free to use for educational purposes.