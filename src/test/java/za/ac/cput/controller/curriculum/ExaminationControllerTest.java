package za.ac.cput.controller.curriculum;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.curriculum.Examination;
import za.ac.cput.factory.curriculum.ExaminationFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExaminationControllerTest {
    private static final LocalDate examDate = LocalDate.of(2021, 8, 31);
    private static Examination examination = ExaminationFactory.build(123, "End year exam", examDate);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/examination";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Examination> postResponse = restTemplate.postForEntity(url, examination, Examination.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        examination = postResponse.getBody();
        System.out.println("Saved data: " + examination);
        assertEquals(examination.getExamId(), postResponse.getBody().getExamId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + examination.getExamId();
        System.out.println("URL: " + url);
        ResponseEntity<Examination> response = restTemplate.getForEntity(url, Examination.class);
        assertEquals(examination.getExamId(), response.getBody().getExamId());
    }

    @Test
    void c_update() {
        Examination updated = new Examination.Builder().copy(examination).setSubjectCode(1111).build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Examination> response = restTemplate.postForEntity(url, updated, Examination.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + examination.getExamId();
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