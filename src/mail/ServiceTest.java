package mail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    private Service service;

    @BeforeEach
    void init() {
        this.service = new Service();
    }

    @Test
    void readFileAndInsertContent() {

        // ARRANGE
        String mail = "";

        // ACT
        try {
            mail = service.getMailFromContent("ThisIsTheTestString");
        } catch(IOException e) {
            e.printStackTrace();
            fail();
        }

        // ASSERT
        assertTrue(mail.contains("ThisIsTheTestString"));
    }
}