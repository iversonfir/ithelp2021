package scholarship;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ScholarshipService {

    private static final int SCHOLARSHIP_THRESHOLD = 80;
    private static final int SCHOLARSHIP_AMOUNT = 10000;

    private final Transcript transcript;


    public int grantingScholarship() {
        if (CollectionUtils.isEmpty(transcript.getCourses())) {
            return 0;
        }
        List<Course> courses = transcript.getCourses();
        long qualifiedCourseCount = courses.stream()
                .filter(course -> course.getScore() >= SCHOLARSHIP_THRESHOLD)
                .count();
        int total = courses.size();
        double rate = (double) qualifiedCourseCount / total;

        if (rate > (double) 1 / 2) {
            return 10000;
        }
        if (rate > (double) 1 / 3) {
            return 5000;
        }
        return 0;
    }
}
