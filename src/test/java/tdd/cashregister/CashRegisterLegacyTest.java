package tdd.cashregister;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CashRegisterLegacyTest {

    @Mock
    private Printer mockPrinter;

    @Mock
    private Purchase stubPurchase;

    @Spy
    private CashRegisterLegacy spyCashRegister;

    @Test
    void should_print_purchase_info_and_discount() {
        //Given
        final String DESCRIPTION = "Purchase description";
        doReturn(DESCRIPTION).when(stubPurchase).description();

        doReturn(10).when(spyCashRegister).calculateDiscount(stubPurchase);
        doReturn(mockPrinter).when(spyCashRegister).buildPrinter();

        //When
        spyCashRegister.process(stubPurchase);

        //Then
        verify(mockPrinter).print(DESCRIPTION + "\ndiscount: " + 10);
        verify(spyCashRegister).calculateDiscount(stubPurchase);
    }
}