package org.hmis;

import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void testMainSinErrores() {
        new Main();
        Main.main(null);
    }
}
