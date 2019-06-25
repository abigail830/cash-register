package tdd.cashregister;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CashRegisterMockitoTest {

    @Disabled
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


    @Disabled
    void test_cash_register_should_able_to_trigger_printer_print_with_stub_purchase() {
        final String DESCRIPTION = "This is description";
        //given
        Purchase purchase = mock(Purchase.class);
        doReturn(DESCRIPTION).when(purchase).description();

        Printer printer = mock(Printer.class);

        //when
        final CashRegister cashRegister = new CashRegister(printer);
        cashRegister.print(purchase);

        //then
        verify(printer, times(1)).print(DESCRIPTION);
    }

    @Test
    void test_cash_register_should_able_to_print_purchase_info_and_discount() {
        final String DESCRIPTION = "This is description";
        //given
        Purchase purchase = mock(Purchase.class);
        doReturn(DESCRIPTION).when(purchase).description();

        Printer printer = mock(Printer.class);

        //when
        final CashRegister spyCashRegister = spy(new CashRegister(printer));
        doReturn(10).when(spyCashRegister).calculateDiscount(purchase);

        spyCashRegister.print(purchase);

        //then
        verify(printer, times(1)).print(DESCRIPTION + "Discount\t10");
    }

}