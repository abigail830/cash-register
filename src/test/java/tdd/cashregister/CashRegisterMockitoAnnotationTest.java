package tdd.cashregister;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CashRegisterMockitoAnnotationTest {

    @Mock
    Printer mockPrinter;

    @Mock
    Purchase stubPurchase;

    @Test
    void test_cash_register_should_able_to_trigger_printer_print() {
        //given
        Item[] items = {new Item("item1", 10), new Item("item2", 20)};
        final Purchase purchase = new Purchase(items);

        //when
        final CashRegister cashRegister = new CashRegister(mockPrinter);
        cashRegister.print(purchase);

        //then
        verify(mockPrinter, times(1)).print(purchase.description());
    }


    @Test
    void test_cash_register_should_able_to_trigger_printer_print_with_stub_purchase() {
        final String DESCRIPTION = "This is description";
        //given
        doReturn(DESCRIPTION).when(stubPurchase).description();

        //when
        final CashRegister cashRegister = new CashRegister(mockPrinter);
        cashRegister.print(stubPurchase);

        //then
        verify(mockPrinter, times(1)).print(DESCRIPTION);
    }

}