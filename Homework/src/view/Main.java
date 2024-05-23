package view;

import exception.HandRemove;
import model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static exception.HandleFindId.searchCourseById;
import static exception.HandleTitle.findCourseByTitle;
import static model.Course.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.println("=====================================================================");
            System.out.println("1. Add new Course :");
            System.out.println("2. List Courses :");
            System.out.println("3. Find Course By ID :");
            System.out.println("4. Find Course By Title :");
            System.out.println("5. Remove Course By ID :");
            System.out.println("0.Exit");
            System.out.println("=====================================================================");
            System.out.print("Enter your choice:");
            number = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("=====================================================================");

            switch (number) {
                case 1:
                    addNewCourse(scanner);
                    break;
                case 2:
                    listCourses();
                    displayCourseTable();
                    break;
                case 3:
                    System.out.print("Enter course ID to find: ");
                    int courseId = scanner.nextInt();
                    Course foundCourse = searchCourseById(courseId);
                    if (foundCourse != null) {
                        List<Course> courseList = new ArrayList<>();
                        courseList.add(foundCourse);
                        displayCoursesInTable(courseList);
                    }
                    break;
                case 4:
                    System.out.print("Enter course title to find: ");
                    String courseTitle = scanner.nextLine();
                    Course foundCourseByTitle = findCourseByTitle(courseTitle);
                    if (foundCourseByTitle != null) {
                        List<Course> courseListByTitle = new ArrayList<>();
                        courseListByTitle.add(foundCourseByTitle);
                        displayCoursesInTable(courseListByTitle);
                    }
                    break;
                case 5:
                    System.out.print("Enter course ID to remove: ");
                    int courseIdToRemove = scanner.nextInt();
                    HandRemove.removeCourseById(courseIdToRemove, courses);
                    break;
                case 0:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + number);
            }
        } while (number != 0);

        scanner.close();
    }
}
