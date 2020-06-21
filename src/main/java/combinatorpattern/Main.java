package combinatorpattern;

import java.time.LocalDate;
import static combinatorpattern.CustomerRegistrationValidator.*;
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "0423425232",
                LocalDate.of(2000,1,1)
        );
        //System.out.println(new CustomerValidatorService().isValid(customer));
        //if valid we can store customer in db

        //using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);
        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
