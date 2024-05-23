package exception;

import model.Course;

import java.util.Optional;

import static model.Course.courses;

public class HandleFindId {
    public static Course searchCourseById(int courseId) {
        try {
            Optional<Course> optionalCourse = courses.stream()
                    .filter(c -> c.id == courseId)
                    .findFirst();
            return optionalCourse.orElseThrow(() -> new IllegalArgumentException("Course with ID " + courseId + " not found."));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
