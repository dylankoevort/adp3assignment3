package za.ac.cput.controller.tertiaryInstitution;
/**
 * EnrollControllerTest.java
 * TTD for Enr:rollControllerTest
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
import za.ac.cput.entity.person.Student;
import za.ac.cput.entity.tertiaryInstitution.Enroll;
import za.ac.cput.factory.tertiaryInstitution.EnrollFactory;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EnrollControllerTest {
    static Date d1 = new Date(2021,11,25);
    private static Enroll enroll = EnrollFactory.build("20216767","ADP2021",d1,true);
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/enroll";

    @Test
    void a_create(){
        String url = BASE_URL +"/create";
        ResponseEntity<Enroll> postResponse = restTemplate.postForEntity(url, enroll, Enroll.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        enroll = postResponse.getBody();
        System.out.println("Save Success"+enroll);
        assertEquals(enroll.getStudentID(), postResponse.getBody().getStudentID());

    }

    @Test
    void b_read(){
        String url = BASE_URL+"/read";
        System.out.println("URL:"+url);
        ResponseEntity<Enroll> response = restTemplate.getForEntity(url,Enroll.class);
        assertEquals(enroll.getStudentID(),response.getBody().getStudentID());

    }

    @Test
    void c_update(){
        Enroll update = new Enroll.EnrollBuilder().copy(enroll).setCourseCode("ADP3U").build();
        String url = BASE_URL+"/update";
        System.out.println("URL:"+url);
        System.out.println("Update Success:"+update);
        ResponseEntity<Enroll> response = restTemplate.postForEntity(url, update, Enroll.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete(){
        String url = BASE_URL+"/delete"+enroll.getStudentID();
        System.out.println("URL:"+url);
        restTemplate.delete(url);
    }
    @Test
    void e_getAll(){
        String url = BASE_URL+"/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("All Details:");
        System.out.println(response);
        System.out.println(response.getBody());

    }

}