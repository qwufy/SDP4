import java.util.Scanner;

interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCard implements PaymentMethod {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " with card number " + cardNumber);
    }
}

class PayPal implements PaymentMethod {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + " with email " + email);
    }
}

interface PaymentMethodFactory {
    PaymentMethod createPaymentMethod();
}

class CreditCardFactory implements PaymentMethodFactory {
    private String cardNumber;

    public CreditCardFactory(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCard(cardNumber);
    }
}

class PayPalFactory implements PaymentMethodFactory{
    private String email;

    public PayPalFactory(String email) {
        this.email = email;
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new PayPal(email);
    }
}

public class Main{
    public static void main(String[] args) {
        // Get credit card number from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Credit Card Number: ");
        String creditCardNumber = scanner.nextLine();

        PaymentMethodFactory creditCardFactory = new CreditCardFactory(creditCardNumber);
        PaymentMethod creditCardPayment = creditCardFactory.createPaymentMethod();
        creditCardPayment.processPayment(100.0);

        System.out.print("Enter PayPal Email: ");
        String payPalEmail = scanner.nextLine();

        PaymentMethodFactory payPalFactory = new PayPalFactory(payPalEmail);
        PaymentMethod payPalPayment = payPalFactory.createPaymentMethod();
        payPalPayment.processPayment(50.0);

        scanner.close();
    }
}
