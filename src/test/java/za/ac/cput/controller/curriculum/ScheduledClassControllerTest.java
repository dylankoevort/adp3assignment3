//package za.ac.cput.controller.curriculum;
//
///*
//Dinelle Kotze
//219089302
//ScheduledClassControllerTest.java
//This is the test class for the ScheduledClass controller.
//16 August 2021
// */
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import za.ac.cput.entity.curriculum.ScheduledClass;
//import za.ac.cput.factory.curriculum.ScheduledClassFactory;
//
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ScheduledClassControllerTest {
//    private static ScheduledClass scheduledClass = ScheduledClassFactory.build("AAB", 123, 123, "10:00");
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private final String BASE_URL = "http://localhost:8080/scheduledClass";
//
//    @Test
//    void a_create() {
//        String url = BASE_URL + "/create";
//        ResponseEntity<ScheduledClass> postResponse = restTemplate.postForEntity(url, scheduledClass, ScheduledClass.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
//        scheduledClass = postResponse.getBody();
//        System.out.println("Saved data: " + scheduledClass);
//        assertEquals(scheduledClass.getScheduledClassId(), postResponse.getBody().getScheduledClassId());
//    }
//
//    @Test
//    void b_read() {
//        String url = BASE_URL + "/read/" + scheduledClass.getScheduledClassId();
//        System.out.println("URL: " + url);
//        ResponseEntity<ScheduledClass> response = restTemplate.getForEntity(url, ScheduledClass.class);
//        assertEquals(scheduledClass.getScheduledClassId(), Objects.requireNonNull(response.getBody()).getScheduledClassId());
//    }
//
//    @Test
//    void c_update() {
//        ScheduledClass updated = new ScheduledClass.Builder().copy(scheduledClass).setRoomCode(123).build();
//        String url = BASE_URL + "/update";
//        System.out.println("URL: " + url);
//        System.out.println("Post data: " + updated);
//        ResponseEntity<ScheduledClass> response = restTemplate.postForEntity(url, updated, ScheduledClass.class);
//        assertNotNull(response.getBody());
//    }
//
//    @Test
//    void e_delete() {
//        String url = BASE_URL + "/delete/" + scheduledClass.getScheduledClassId();
//        System.out.println("URL: " + url);
//        restTemplate.delete(url);
//    }
//
//    @Test
//    void d_getAll() {
//        String url = BASE_URL + "/getAll";
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//        System.out.println("Show All:");
//        System.out.println(response);
//        System.out.println(response.getBody());
//    }
//}