package exception;

import model.Course;

import static model.Course.courses;

public class HandleTitle {
    public static Course findCourseByTitle(String title) {
        try {
            return courses.stream()
                    .filter(course -> course.title.equalsIgnoreCase(title))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Course with title \"" + title + "\" not found."));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
