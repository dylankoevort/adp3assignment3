package za.ac.cput.controller.tertiaryInstitution;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.tertiaryInstitution.Course;
import za.ac.cput.factory.tertiaryInstitution.CourseFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerTest {
    private static Course course = CourseFactory.build("ADP","Applications Development Practise","057",20,3, true);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/department";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Course> postResponse = restTemplate.postForEntity(url, course, Course.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        course = postResponse.getBody();
        System.out.println("Saved data: " + course);
        assertEquals(course.getcourseCode(), postResponse.getBody().getcourseTitle());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + course.getcourseCode();
        System.out.println("URL: " + url);
        ResponseEntity<Course> response = restTemplate.getForEntity(url, Course.class);
        assertEquals(course.getcourseCode(), response.getBody().getcourseTitle());
    }

    @Test
    void c_update() {
        Course updated = new Course.CourseBuilder().copy(course).setCredit(15).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        ResponseEntity<Course> response = restTemplate.postForEntity(url, updated, Course.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + course.getcourseCode();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = BASE_URL + "/getAll";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}