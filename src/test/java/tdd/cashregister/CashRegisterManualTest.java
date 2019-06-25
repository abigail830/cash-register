package tdd.cashregister;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CashRegisterManualTest {

    MockPrinter mockPrinter;

    @BeforeEach
    void setUp() {
        mockPrinter = new MockPrinter();
    }

    @Test
    void test_cash_register_should_able_to_trigger_printer_print() {
        //given
        Item[] items = {new Item("item1", 10), new Item("item2", 20)};
        final Purchase purchase = new Purchase(items);

        //when
        final CashRegister cashRegister = new CashRegister(mockPrinter);
        cashRegister.print(purchase);

        //then
        mockPrinter.verify("item1\t10.0\nitem2\t20.0\n");

    }

}