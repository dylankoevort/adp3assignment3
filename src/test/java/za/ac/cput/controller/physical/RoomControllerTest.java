package za.ac.cput.controller.physical;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.physical.Room;
import za.ac.cput.factory.physical.RoomFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class RoomControllerTest {

    private static Room room = RoomFactory.build("Lecture Hall","LH1",100,1,666);
    @Autowired
    private TestRestTemplate restTemplate = null;
    private final String BASE_URL = "http://localhost:8080/room";



    @Test
    @Order(1)
    void create() {
        String url = BASE_URL+ "/createl";
        ResponseEntity<Room> postResponse = restTemplate.withBasicAuth("admin", "pass").postForEntity(url, room, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        room = postResponse.getBody();
        System.out.println("Saved data: " + room);
        assertEquals(room.getRoomCode(), postResponse.getBody().getRoomCode());
    }

    @Test
    @Order(2)
    void read_Room() {
        String url = BASE_URL + "/readlect" + room.getRoomCode();
        System.out.println("URL for read: " + url);
        ResponseEntity<Room> response = restTemplate.withBasicAuth("admin", "pass").getForEntity(url, Room.class);
        assertEquals(response.getBody().getRoomCode(), response.getBody().getRoomCode());
    }

    @Test
    @Order(3)
    void update_Room() {
        Room updated = new Room.RoomBuilder().copy(room).setRoomCode("LH2").build();
        String url = BASE_URL + "/updateroom";
        System.out.println("URL for update: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Room> response = restTemplate.withBasicAuth("admin", "pass").postForEntity(url, updated, Room.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void delete_Room() {
        String url = BASE_URL + "/deleteroom" + room.getRoomCode();
        System.out.println("URL: " + url);;
        restTemplate.withBasicAuth("admin", "pass").delete(url);
    }

    @Test
    @Order(4)
    void getAll_Room() {
        String url = BASE_URL + "/getallroom";
        HttpHeaders head = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, head);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin", "pass").exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(url);
        System.out.println("Show All Rooms:");
        System.out.println(response);
        System.out.println(response.getBody());

    }

}