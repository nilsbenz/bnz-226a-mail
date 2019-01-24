package mail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HTMLBuilderTest {

    @Test
    void getHTMLFromInputTest() {

        // ARRANGE
        HTMLBuilder builder = new HTMLBuilder();

        // ACT
        String element = builder.getHTMLFromInput("h1", "This is a title.");

        // ASSERT
        assertEquals(element, "<h1>This is a title.</h1>");
    }

}