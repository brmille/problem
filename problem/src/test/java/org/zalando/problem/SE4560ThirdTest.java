package org.zalando.problem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SE4560ThirdTest {
    // Class partition test with different status inputs
    @Test
    void Status504Test() {
        Status status = Status.valueOf(504);
        assertEquals(504, status.getStatusCode());
        assertEquals("Gateway Timeout", status.getReasonPhrase());
    }
    @Test
    void Status400Test() {
        Status status = Status.valueOf(400);
        assertEquals(400, status.getStatusCode());
        assertEquals("Bad Request", status.getReasonPhrase());
    }
    @Test
    void StatusStringTest() {
        Status status = Status.valueOf(504);
        assertEquals("504 Gateway Timeout", status.toString());
    }

    @Test
    void StatusErrorTest() {
        assertThrows(IllegalArgumentException.class, () -> {Status.valueOf(999);});
    }
}
