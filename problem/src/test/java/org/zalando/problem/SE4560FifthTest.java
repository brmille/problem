package org.zalando.problem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;

public class SE4560FifthTest {
    // Bottom up test with status, uri, and Problem's toString() method
    @Test
    void StatusStringTest() {
        Status status = Status.valueOf(404);
        assertEquals("404 Not Found", status.toString());
    }
    @Test
    void ProblemURITest() {
        try {
            URI uri = new URI("https://www.example.com/path?query=value#fragment");
            Problem prob = Problem.builder().withType(uri).build();
            assertEquals(uri, prob.getType());
        } 
        catch (URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());
        }
    }
    @Test
    void ProblemStringStatusTest() {
        Status status = Status.valueOf(404);
        Problem prob = Problem.builder().withStatus(status).withTitle(status.getReasonPhrase()).build();
        assertEquals("about:blank{404, Not Found}", Problem.toString(prob));
    }
    @Test
    void ProblemTypeStringTest() {
        try {
            URI uri = new URI("https://www.example.com/path?query=value#fragment");
            Problem prob = Problem.builder().withType(uri).build();
            assertEquals("https://www.example.com/path?query=value#fragment{}", Problem.toString(prob));
        } 
        catch (URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());
        }
    }
    @Test
    void ProblemTypeStatusStringTest() {
        try {
            URI uri = new URI("https://www.example.com/path?query=value#fragment");
            Status status = Status.valueOf(404);
            Problem prob = Problem.builder().withType(uri).withStatus(status).withTitle(status.getReasonPhrase()).build();
            assertEquals("https://www.example.com/path?query=value#fragment{404, Not Found}", Problem.toString(prob));
        } 
        catch (URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());
        }
    }
}
