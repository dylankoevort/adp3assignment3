package za.ac.cput.controller.person;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.person.Student;
import za.ac.cput.factory.person.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
    private static Student student = StudentFactory.build("Dylan", "Koevort", "218@gmail.com", "073112", 21);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/student";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Student> postResponse = restTemplate.postForEntity(url, student, Student.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        student = postResponse.getBody();
        System.out.println("Saved data: " + student);
        assertEquals(student.getStudentId(), postResponse.getBody().getStudentId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + student.getStudentId();
        System.out.println("URL: " + url);
        ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class);
        assertEquals(student.getStudentId(), response.getBody().getStudentId());
    }

    @Test
    void c_update() {
        Student updated = new Student.StudentBuilder().copy(student).setFirstName("Bob").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Student> response = restTemplate.postForEntity(url, updated, Student.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + student.getStudentId();
        System.out.println("URL: " + url);;
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}