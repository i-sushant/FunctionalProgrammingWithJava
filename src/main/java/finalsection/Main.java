package finalsection;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        hello("john",null, value -> {
            System.out.println("lastname not provided for " + value);
        });
        hello2("john",null, () -> {
            System.out.println("lastname not provided");
        });
    }
    static void hello(String firstName, String lastName, Consumer<String> callback){
        if(lastName != null){
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }
    static void hello2(String firstName, String lastName, Runnable callback){
        if(lastName != null){
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
