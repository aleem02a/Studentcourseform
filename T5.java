import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private List<String> schedule;
    private int availableSlots;

    public Course(String code, String title, String description, int capacity, List<String> schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.availableSlots = capacity;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void decreaseSlot() {
        availableSlots--;
    }

    public void increaseSlot() {
        availableSlots++;
    }
}

class Student {
    private String id;
    private String name;
    private List<Course> courses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void registerCourse(Course course) {
        if (course.getAvailableSlots() > 0) {
            courses.add(course);
            course.decreaseSlot();
            System.out.println("Course " + course.getTitle() + " registered successfully for student " + name);
        } else {
            System.out.println("Sorry, the course " + course.getTitle() + " is full.");
        }
    }

    public void dropCourse(Course course) {
        if (courses.remove(course)) {
            course.increaseSlot();
            System.out.println("Course " + course.getTitle() + " dropped successfully for student " + name);
        } else {
            System.out.println("Student " + name + " is not enrolled in the course " + course.getTitle());
        }
    }
}

public class Main {
    private static Map<String, Course> courseDatabase = new HashMap<>();
    private static List<Student> studentDatabase = new ArrayList<>();

    public static void main(String[] args) {
        initializeCourses();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Course Listing");
            System.out.println("2. Student Registration");
            System.out.println("3. Course Removal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayCourseListing();
                    break;
                case 2:
                    performStudentRegistration(scanner);
                    break;
                case 3:
                    performCourseRemoval(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void initializeCourses() {
        List<String> schedule = new ArrayList<>();
        schedule.add("Monday 10:00 AM - 12:00 PM");
        schedule.add("Wednesday 10:00 AM - 12:00 PM");
        Course course1 = new Course("CS101", "Introduction to Computer Science",
                "An introductory course to computer science concepts", 30, schedule);
        courseDatabase.put(course1.getCode(), course1);

        schedule = new ArrayList<>();
        schedule.add("Tuesday 2:00 PM - 4:00 PM");
        schedule.add("Thursday 2:00 PM - 4:00 PM");
        Course course2 = new Course("MATH201", "Calculus", "A course on calculus", 25, schedule);
        courseDatabase.put(course2.getCode(), course2);
    }

    private static void displayCourseListing() {
        System.out.println("\nCourse Listing:");
        for (Course course : courseDatabase.values()) {
            System.out.println("Course Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + course.getAvailableSlots());
            System.out.println();
        }
    }

    private static void performStudentRegistration(Scanner scanner) {
        System.out.print("\nEnter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentId, studentName);
        studentDatabase.add(student);

        System.out.println("\nAvailable Courses for Registration:");
        displayCourseListing();

        System.out.print("\nEnter course code to register: ");
        String courseCode = scanner.nextLine();
        Course selectedCourse = courseDatabase.get(courseCode);
        if (selectedCourse != null) {
            student.registerCourse(selectedCourse);
        } else {
            System.out.println("Invalid course code.");
        }
    }

    private static void performCourseRemoval(Scanner scanner) {
        System.out.print("\nEnter student ID: ");
        String studentId = scanner.nextLine();

        Student studentToRemove = null;
        for (Student student : studentDatabase) {
            if (student.getId().equals(studentId)) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("\nCourses registered by " + studentToRemove.getName() + ":");
        List<Course> courses = studentToRemove.getCourses();
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCode() + ", Title: " + course.getTitle());
        }

        System.out.print("\nEnter course code to remove: ");
        String courseCode = scanner.nextLine();
        Course courseToRemove = null;
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                courseToRemove = course;
                break;
            }
        }

        if (courseToRemove == null) {
            System.out.println("Course not found or student not enrolled in the course.");
        } else {
            studentToRemove.dropCourse(courseToRemove);
        }
    }
}