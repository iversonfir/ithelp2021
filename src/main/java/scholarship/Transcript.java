package scholarship;

import lombok.Data;

import java.util.List;

@Data
public class Transcript {
    private List<Course> courses;

    public Transcript(List<Course> courses) {
        this.courses = courses;
    }
}
