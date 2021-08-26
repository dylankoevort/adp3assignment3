package za.ac.cput.controller.tertiaryInstitution;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.tertiaryInstitution.Department;
import za.ac.cput.factory.tertiaryInstitution.DepartmentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentControllerTest {
    private static Department department = DepartmentFactory.build("021","Information Technology"," ");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/department";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Department> postResponse = restTemplate.postForEntity(url, department, Department.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        department = postResponse.getBody();
        System.out.println("Saved data: " + department);
        assertEquals(department.getDepartmentId(), postResponse.getBody().getDepartmentId());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + department.getDepartmentId();
        System.out.println("URL: " + url);
        ResponseEntity<Department> response = restTemplate.getForEntity(url, Department.class);
        assertEquals(department.getDepartmentId(), response.getBody().getDepartmentId());
    }

    @Test
    void c_update() {
        Department updated = new Department.DepartmentBuilder().copy(department).setDepartmentDesc("Test").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + updated);
        ResponseEntity<Department> response = restTemplate.postForEntity(url, updated, Department.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = BASE_URL + "/delete/" + department.getDepartmentId();
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