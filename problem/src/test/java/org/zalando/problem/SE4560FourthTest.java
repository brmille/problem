package org.zalando.problem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SE4560FourthTest {
    // Class partition test with ThrowableProblem's getMessage() method
    @Test
    void ThrowableEmptyTest() {
        ThrowableProblem prob = Problem.builder().build();
        assertEquals("", prob.getMessage());
    }
    @Test
    void ThrowableTitleTest() {
        ThrowableProblem prob = Problem.builder().withTitle("Title").build();
        assertEquals("Title", prob.getMessage());
    }
    @Test
    void ThrowableDetailTest() {
        ThrowableProblem prob = Problem.builder().withDetail("Detail").build();
        assertEquals("Detail", prob.getMessage());
    }
    @Test
    void ThrowableMessageTest() {
        ThrowableProblem prob = Problem.builder().withDetail("Detail").withTitle("Title").build();
        assertEquals("Title: Detail", prob.getMessage());
    }
}
