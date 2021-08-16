package za.ac.cput.controller.person;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.person.Lecturer;

import za.ac.cput.factory.person.LecturerFactory;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * Created Test for LecturerController class.
 * Author: Shane Knoll (218279124)
 * Date:13 August 2021
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LecturerControllerTest {


    private static Lecturer lect = LecturerFactory.build("Zack","Will",25,"Markwill@gamil","0784442315");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/lecturer";



    @Test
    @Order(1)
    void create() {
        String url = BASE_URL+ "/createl";
        ResponseEntity<Lecturer> postResponse = restTemplate.postForEntity(url, lect, Lecturer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        lect = postResponse.getBody();
        System.out.println("Saved data: " + lect);
        assertEquals(lect.getLecturerID(), postResponse.getBody().getLecturerID());
    }

    @Test
    @Order(2)
    void read_Lect() {
        String url = BASE_URL + "/readlect" + lect.getLecturerID();
        System.out.println("URL for read: " + url);
        ResponseEntity<Lecturer> response = restTemplate.getForEntity(url, Lecturer.class);
        assertEquals(response.getBody().getLecturerID(), response.getBody().getLecturerID());
    }

    @Test
    @Order(3)
    void update_Lect() {
        Lecturer updated = new Lecturer.LecturerBuilder().copy(lect).setage(30).build();
        String url = BASE_URL + "/updatelect";
        System.out.println("URL for update: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Lecturer> response = restTemplate.postForEntity(url, updated, Lecturer.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void delete_Lect() {
        String url = BASE_URL + "/deletelect" + lect.getLecturerID();
        System.out.println("URL: " + url);;
        restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void getAll_Lect() {
        String url = BASE_URL + "/getalllect";
        HttpHeaders head = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, head);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(url);
        System.out.println("Show All Lecturers:");
        System.out.println(response);
        System.out.println(response.getBody());

    }




}