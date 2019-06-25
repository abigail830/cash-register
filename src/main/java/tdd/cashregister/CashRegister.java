package tdd.cashregister;

public class CashRegister {

    private Printer printer;

    public CashRegister(Printer printer) {
        this.printer = printer;
    }

    public void print(Purchase purchase) {
        printer.print(purchase.description() + "Discount\t" + calculateDiscount(purchase));
    }

    int calculateDiscount(Purchase purchase) {
        throw new UnsupportedOperationException("Not Implemented");
    }
}
