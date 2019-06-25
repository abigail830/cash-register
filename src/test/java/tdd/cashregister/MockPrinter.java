package tdd.cashregister;

import org.junit.jupiter.api.Assertions;

public class MockPrinter extends Printer {

    private String msg;

    @Override
    public void print(String message) {
        msg = message;
    }

    void verify(String message) {
        Assertions.assertEquals(message, msg);
    }
}
