package org.zalando.problem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.net.URISyntaxException;


public class SE4560SixthTest {
    // Class partition test using ThrowableProblem for Problem's toString() method
    @Test
    void ThrowableEmptyStringTest() {
        ThrowableProblem prob = Problem.builder().build();
        assertEquals("about:blank{}", prob.toString());
    }
    @Test
    void ThrowableStatusStringTest() {
        Status status = Status.valueOf(404);
        ThrowableProblem prob = Problem.builder().withStatus(status).build();
        assertEquals("about:blank{404}", prob.toString());
    }
    @Test
    void ThrowableTitleStringTest() {
        Status status = Status.valueOf(404);
        ThrowableProblem prob = Problem.builder().withTitle(status.getReasonPhrase()).build();
        assertEquals("about:blank{Not Found}", prob.toString());
    }
    @Test
    void ThrowableDetailStringTest() {
        ThrowableProblem prob = Problem.builder().withDetail("Detail").build();
        assertEquals("about:blank{Detail}", prob.toString());
    }
    @Test
    void ThrowableInstanceStringTest() {
        try {
            URI instance = new URI("https://www.example.com/path?query=value#fragment");
            ThrowableProblem prob = Problem.builder().withInstance(instance).build();
            assertEquals("about:blank{instance=https://www.example.com/path?query=value#fragment}", prob.toString());
        }
        catch(URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());

        }
    }
    @Test
    void ThrowableParameterStringTest() {
        ThrowableProblem prob = Problem.builder().with("key", "value").build();
        assertEquals("about:blank{key=value}", prob.toString());
    }
    @Test
    void ThrowableTypeStringTest() {
        try {
            URI type = new URI("https://www.example.com/path?query=value#fragment");
            ThrowableProblem prob = Problem.builder().withType(type).build();
            assertEquals("https://www.example.com/path?query=value#fragment{}", prob.toString());
        }
        catch(URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());

        }
    }
    @Test
    void ThrowableAllStringTest() {
        try {
            URI type = new URI("https://www.example.com/path?query=value#fragment");
            URI instance = new URI("https://www.example.com/path?query=value#fragment");
            Status status = Status.valueOf(404);
            ThrowableProblem prob = Problem.builder()
                .withStatus(status).withTitle(status.getReasonPhrase()).withDetail("Detail").withInstance(instance).with("key", "value").withType(type)
                .build();
            assertEquals(    
                "https://www.example.com/path?query=value#fragment{404, Not Found, Detail, instance=https://www.example.com/path?query=value#fragment, key=value}",
                prob.toString());
        }
        catch(URISyntaxException error) {
            System.err.println("Invalid URI syntax: " + error.getMessage());

        }
    }
}
