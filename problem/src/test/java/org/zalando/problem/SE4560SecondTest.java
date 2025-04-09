package org.zalando.problem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class SE4560SecondTest {
    // Class partition test with different types of problems
    @Test
    void BuildTypeTest() {
        try {
            URI probURI = new URI("https://www.example.com/path?query=value#fragment");
            Problem prob = Problem.builder().withType(probURI).build();
            assertEquals(probURI, prob.getType());
        }
        catch(URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());
        }
    }
    @Test
    void BuildTitleTest() {
        Problem prob = Problem.builder().withTitle("Title").build();
        assertEquals("Title", prob.getTitle());
    }
    @Test
    void BuildStatusTest() {
        Status status = Status.valueOf(504);
        Problem prob = Problem.builder().withStatus(status).build();
        assertEquals(status, prob.getStatus()); 
    }
    @Test
    void BuildDetailTest() {
        Problem prob = Problem.builder().withDetail("detail").build();
        assertEquals("detail", prob.getDetail());
    }
    @Test
    void BuildInstanceTest() {
        try {
            URI probURI = new URI("https://www.example.com/path?query=value#fragment");
            Problem prob = Problem.builder().withInstance(probURI).build();
            assertEquals(probURI, prob.getInstance());
        }
        catch(URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());
        }
    }
}
