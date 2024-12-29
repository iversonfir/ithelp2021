package scholarship;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScholarshipTest {

    // 81 81 80
    // 81 80 80   1/3<1/2  0
    // 81 81 80 80

    // VVV
    // VVX
    // VXX

    @Test
    public void get10000_scholarship() {
        // 獎學金 Scholarship
        // 至少1/2學科有達80分以上   就發一萬
        // Affairs office 教務處
        Transcript transcript = new Transcript(Arrays.asList(
                new Course("國語", 80),
                new Course("英文", 90),
                new Course("數學", 85)
        ));


        ScholarshipService scholarshipService = new ScholarshipService(transcript);
        assertEquals(10000, scholarshipService.grantingScholarship());
    }

    @Test
    public void noScholarship() {
        Transcript transcript = new Transcript(Arrays.asList(
                new Course("國語", 79),
                new Course("英文", 60),
                new Course("數學", 85)
        ));

        ScholarshipService scholarshipService = new ScholarshipService(transcript);
        assertEquals(0, scholarshipService.grantingScholarship());
    }

    @Test
    public void get10000_scholarship2() {
        Transcript transcript = new Transcript(Arrays.asList(
                new Course("國語", 81),
                new Course("英文", 81),
                new Course("數學", 81),
                new Course("歷史", 79)
        ));


        ScholarshipService scholarshipService = new ScholarshipService(transcript);
        assertEquals(10000, scholarshipService.grantingScholarship());
    }


    @Test
    public void noCourse() {
        Transcript transcript = new Transcript(Collections.emptyList());
        ScholarshipService scholarshipService = new ScholarshipService(transcript);
        assertEquals(0, scholarshipService.grantingScholarship());
    }
}
