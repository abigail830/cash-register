package tdd.cashregister;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CashRegisterMockitoTest {

    @Test
    void test_cash_register_should_able_to_trigger_printer_print() {
        //given
        Item[] items = {new Item("item1", 10), new Item("item2", 20)};
        final Purchase purchase = new Purchase(items);

        Printer printer = mock(Printer.class);

        //when
        final CashRegister cashRegister = new CashRegister(printer);
        cashRegister.print(purchase);

        //then
        verify(printer, times(1)).print(purchase.description());
    }

}