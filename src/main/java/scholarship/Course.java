package scholarship;

import lombok.Data;

@Data
public class Course {
    private final String name;
    private final int score;

    public Course(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
