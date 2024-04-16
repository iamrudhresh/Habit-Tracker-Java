import java.util.*;

class Habit {
    private String name;
    private boolean completed;

    public Habit(String name) {
        this.name = name;
        this.completed = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public void markIncomplete() {
        this.completed = false;
    }
}

class HabitTracker {
    private List<Habit> habits;

    public HabitTracker() {
        habits = new ArrayList<>();
    }

    public void addHabit(String habitName) {
        Habit habit = new Habit(habitName);
        habits.add(habit);
    }

    public void markHabitCompleted(String habitName) {
        for (Habit habit : habits) {
            if (habit.getName().equalsIgnoreCase(habitName)) {
                habit.markCompleted();
                return;
            }
        }
        System.out.println("Habit not found!");
    }

    public void displayHabits() {
        if (habits.isEmpty()) {
            System.out.println("No habits added yet.");
        } else {
            System.out.println("Habits:");
            for (Habit habit : habits) {
                System.out.println(habit.getName() + " - Completed: " + (habit.isCompleted() ? "Yes" : "No"));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HabitTracker habitTracker = new HabitTracker();

        boolean running = true;
        while (running) {
            System.out.println("\nHabit Tracker Menu:");
            System.out.println("1. Add Habit");
            System.out.println("2. Mark Habit as Completed");
            System.out.println("3. View Habits");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter habit name: ");
                    String habitName = scanner.nextLine();
                    habitTracker.addHabit(habitName);
                    System.out.println("Habit added successfully!");
                    break;
                case 2:
                    System.out.print("Enter habit name to mark as completed: ");
                    String habitToComplete = scanner.nextLine();
                    habitTracker.markHabitCompleted(habitToComplete);
                    break;
                case 3:
                    habitTracker.displayHabits();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }
}
