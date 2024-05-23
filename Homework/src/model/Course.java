package model;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.text.SimpleDateFormat;
import java.util.*;

import static exception.Handle.getStringInput;

public class Course {
    public static List<Course> courses = new ArrayList<>();

    public int id;
    public String title;
    private String[] instructorNames;
    private String[] requirements;
    private Date startDate;

    public Course(int id, String title, String[] instructorNames, String[] requirements, Date startDate) {
        this.id = id;
        this.title = title;
        this.instructorNames = instructorNames;
        this.requirements = requirements;
        this.startDate = startDate;
    }



    public static void addNewCourse(Scanner scanner) {
        System.out.print("Enter course title: ");
        String title = getStringInput(scanner);

        System.out.print("Enter instructor :");
        String[] instructorNames = getStringInput(scanner).split(",");

        System.out.print("Enter course requirement :");
        String[] requirements = getStringInput(scanner).split(",");

        // Dummy start date for simplicity
        Date startDate = new Date();

        Course course = new Course(courses.size() + 1, title, instructorNames, requirements, startDate);
        courses.add(course);

        System.out.println("Course added successfully.");
    }


    public static void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("List of Courses:");
            for (Course course : courses) {
                System.out.println("Course ID: " + course.id);
                System.out.println("Title: " + course.title);
                System.out.println("Instructor: " + String.join(", ", course.instructorNames));
                System.out.println("Requirements: " + String.join(", ", course.requirements));
                System.out.println("Start Date: " + formatStartDate(course.startDate)); // Format the date
                System.out.println();
            }
        }
    }

    private static String formatStartDate(Date startDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM yyyy");
        return "ICT " + sdf.format(startDate);
    }
    public static void displayCourseTable() {
        if (!courses.isEmpty()) {
            Table tb = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
            for(int i=0; i<5; i++){
                tb.setColumnWidth(i,30,30);
            }
            tb.addCell("Course ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Title",new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Instructor(s)",new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Requirements",new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Start Date",new CellStyle(CellStyle.HorizontalAlign.CENTER));

            for (Course course : courses) {
                tb.addCell(String.valueOf(course.id));
                tb.addCell(course.title);
                tb.addCell(String.join(", ", course.instructorNames));
                tb.addCell(String.join(", ", course.requirements));
                tb.addCell(String.valueOf(course.startDate));
            }

            System.out.println(tb.render());
        }
    }


    public static void displayCoursesInTable(List<Course> courses) {
        if (!courses.isEmpty()) {
            Table tb = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
            for (int i = 0; i < 5; i++) {
                tb.setColumnWidth(i, 30, 30);
            }
            tb.addCell("Course ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Instructor(s)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Requirements", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Start Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

            for (Course course : courses) {
                tb.addCell(String.valueOf(course.id));
                tb.addCell(course.title);
                tb.addCell(String.join(", ", course.instructorNames));
                tb.addCell(String.join(", ", course.requirements));
                tb.addCell(String.valueOf(course.startDate));
            }

            System.out.println(tb.render());
        }
    }

    private static void displayCoursesById(List<Course> courses) {
        if (!courses.isEmpty()) {
            Table tb = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
            for (int i = 0; i < 5; i++) {
                tb.setColumnWidth(i, 30, 30);
            }
            tb.addCell("Course ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Instructor(s)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Requirements", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Start Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

            for (Course course : courses) {
                tb.addCell(String.valueOf(course.id));
                tb.addCell(course.title);
                tb.addCell(String.join(", ", course.instructorNames));
                tb.addCell(String.join(", ", course.requirements));
                tb.addCell(String.valueOf(course.startDate));
            }

            System.out.println(tb.render());
        }
    }

    private static void displayCoursesByTitle(List<Course> courses) {
        if (courses == null || courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            Table tb = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
            for (int i = 0; i < 5; i++) {
                tb.setColumnWidth(i, 30, 30);
            }
            tb.addCell("Course ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Title", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Instructor(s)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Requirements", new CellStyle(CellStyle.HorizontalAlign.CENTER));
            tb.addCell("Start Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

            for (Course course : courses) {
                tb.addCell(String.valueOf(course.id));
                tb.addCell(course.title);
                tb.addCell(String.join(", ", course.instructorNames));
                tb.addCell(String.join(", ", course.requirements));
                tb.addCell(String.valueOf(course.startDate));
            }

            System.out.println(tb.render());
        }
    }



}


