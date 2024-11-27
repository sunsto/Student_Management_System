import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    // Constructor
    Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    String getGrade() {
        return grade;
    }

    void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

public class Student_Management_System {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--------- Student Management System ---------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter Your Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> Add_Student();
                case 2 -> view_all_Student();
                case 3 -> Update_Student();
                case 4 -> Delete_Student();
                case 5 -> searchStudent();
                case 6 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice! Please try again.");
            }
        }
    }

    private static void Add_Student() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        students.add(new Student(id, name, age, grade));
        System.out.println("Student added successfully!");
    }

    private static void view_all_Student() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void Update_Student() {
        System.out.print("Enter ID of the student to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();
                System.out.print("Enter new Age: ");
                int age = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.print("Enter new Grade: ");
                String grade = sc.nextLine();

                student.setName(name);
                student.setAge(age);
                student.setGrade(grade);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    private static void Delete_Student() {
        System.out.print("Enter ID of the student to delete: ");
        int id = sc.nextInt();

        boolean removed = students.removeIf(student -> student.getId() == id);
        if (removed) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Name or ID to search: ");
        sc.nextLine(); // Consume newline
        String input = sc.nextLine();

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(input) ||
                String.valueOf(student.getId()).equals(input)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("No student found with the given input.");
    }
}
