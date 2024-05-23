package exception;

import model.Course;


import java.util.List;
import java.util.Optional;

public class HandRemove {
    public static Optional<Course> searchCourseById(int courseId, List<Course> courses) {
        return courses.stream()
                .filter(c -> c.id == courseId)
                .findFirst();
    }

    public static void removeCourseById(int courseId, List<Course> courses) {
        Optional<Course> optionalCourse = searchCourseById(courseId, courses);
        if (optionalCourse.isPresent()) {
            courses.remove(optionalCourse.get());
            System.out.println("Course with ID " + courseId + " removed successfully.");
        } else {
            System.out.println("Course with ID " + courseId + " not found.");
        }
    }
}
