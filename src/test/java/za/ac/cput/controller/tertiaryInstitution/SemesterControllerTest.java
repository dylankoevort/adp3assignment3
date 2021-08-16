package za.ac.cput.controller.tertiaryInstitution;
/**
 * SemesterControllerTest.java
 * TTD for SemesterControllerTest
 * Autho Tisetso Kotoana
 * Date:15 June 2021
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.tertiaryInstitution.Enroll;
import za.ac.cput.entity.tertiaryInstitution.Semester;
import za.ac.cput.factory.tertiaryInstitution.SemesterFactory;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class SemesterControllerTest {
    static Date d1 = new Date(2021,02,25);
    static Date d2 = new Date(2021,06,25);

    private static Semester semester = SemesterFactory.build("JFMAMJ2021",d1,d2);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/semester";

    @Test
    void a_create(){
        String url =BASE_URL+"/create";
        ResponseEntity<Semester> postResponse = restTemplate.postForEntity(url, semester, Semester.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        semester = postResponse.getBody();
        System.out.println("Save Success"+ semester);
        assertEquals(semester.getSemesterID(), postResponse.getBody().getSemesterID());



    }
    @Test
    void b_read(){
        String url = BASE_URL+"/read";
       System.out.println("URL:"+url);
       ResponseEntity<Semester> response =restTemplate.getForEntity(url,Semester.class);
       assertEquals(semester.getSemesterID(),response.getBody().getSemesterID());


    }

    @Test
    void c_update(){
        Semester update = new Semester.SemesterBuilder().copy(semester).setSemesterID("JASONS2021").setSemesterStart(d1).setSemesterEnd(d2).build();
        String url = BASE_URL+"/update";
        System.out.println("URL: "+url);
        System.out.println("Data Updated:"+update);
        ResponseEntity<Semester> response = restTemplate.postForEntity(url,update, Semester.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete(){
        String url = BASE_URL+"/delete"+semester.getSemesterID();
        System.out.println("URL:");
        System.out.println(url);
        restTemplate.delete(url);

    }

    @Test
    void e_getAll(){
       String url = "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity, String.class);
        System.out.println("All Details:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}