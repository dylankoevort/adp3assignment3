package za.ac.cput.controller.curriculum;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.curriculum.Subject;

import za.ac.cput.factory.curriculum.SubjectFactory;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * Created test for SubjectController class.
 * Author: Shane Knoll (218279124)
 * Date:13 August 2021
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SubjectControllerTest {

    private static Subject sub = SubjectFactory.build("Applications Development 3",965,"363s",344);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/subject";



    @Test
    @Order(1)
    void create_Sub() {
        String url = BASE_URL + "/creates";
        ResponseEntity<Subject> postResponse = restTemplate.postForEntity(url, sub, Subject.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        sub = postResponse.getBody();
        System.out.println("Saved subject: " + sub);
        assertEquals(sub.getSubjectCode(), postResponse.getBody().getSubjectCode());
    }

    @Test
    @Order(2)
    void read_Sub() {
        String url = BASE_URL + "/readsub" + sub.getSubjectCode();
        System.out.println("URL for read: " + url);
        ResponseEntity<Subject> response = restTemplate.getForEntity(url, Subject.class);
        assertEquals(response.getBody().getSubjectCode(), response.getBody().getSubjectCode());

    }

    @Test
    @Order(3)
    void update_Sub() {
       Subject updated = new Subject.SubjectBuilder().copy(sub).setsubjectName("Information Systems 3").build();
        String url = BASE_URL + "/updatesub";
        System.out.println("URL for update: " + url);
        System.out.println("Post data of subject: " + updated);
        ResponseEntity<Subject> response = restTemplate.postForEntity(url, updated, Subject.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void delete_Sub() {
        String url = BASE_URL + "/deletesub" + sub.getSubjectCode();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void getAll_Sub() {
        String url = BASE_URL + "/getallsub";
        HttpHeaders head = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, head);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(url);
        System.out.println("Show all Subjects:");
        System.out.println(response);
        System.out.println(response.getBody());
    }



}