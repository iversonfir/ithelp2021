package idv.kuma.itehlp2021.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    @Test
    void full_name() {

        Student student = new Student("Allen","Iverson");

        String actual = student.getFullName();

        assertEquals("Allen Iverson", actual);
    }
}