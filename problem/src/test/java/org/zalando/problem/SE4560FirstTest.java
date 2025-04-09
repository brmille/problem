package org.zalando.problem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

public class SE4560FirstTest {
    // Bottom up test with status and problem
    @Test
    void StatusTest() {
        Status status = Status.valueOf(404);
        assertEquals(404, status.getStatusCode());
        assertEquals("Not Found", status.getReasonPhrase());
    }
    @Test
    void ProblemTest() {
        Status status = Status.valueOf(404);
        Problem problem = Problem.valueOf(status);
        assertEquals(status, problem.getStatus());
    }
    @Test
    void ProblemDetailTest() {
        Status status = Status.valueOf(404);
        Problem problem = Problem.valueOf(status, "detail");
        assertEquals("detail", problem.getDetail());
    }
    @Test
    void ProblemInstanceTest() {
        Status status = Status.valueOf(404);
        try {
            URI uri = new URI("https://www.example.com/path?query=value#fragment");
            Problem problem = Problem.valueOf(status, uri);
            assertEquals(uri, problem.getInstance());
        } 
        catch (URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());
        }
    }
    @Test
    void ProblemDetailInstanceTest() {
        Status status = Status.valueOf(404);
        try {
            URI uri = new URI("https://www.example.com/path?query=value#fragment");
            Problem problem = Problem.valueOf(status, "detail", uri);
            assertEquals("detail", problem.getDetail());
            assertEquals(uri, problem.getInstance());
        } 
        catch (URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());
        }
    }
}
