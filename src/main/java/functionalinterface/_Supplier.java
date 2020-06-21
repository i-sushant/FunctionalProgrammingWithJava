package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getConnectionUrl());
        System.out.println(getConnectionUrlSupplier.get());
        System.out.println(getConnectionUrlsSupplier.get());
    }
    static String getConnectionUrl () {
        return "jdbc://localhost:5342/users";
    }
    static Supplier<String> getConnectionUrlSupplier = () -> "jdbc://localhost:5342/users";
    static Supplier<List<String>> getConnectionUrlsSupplier = () -> List.of(
            "jdbc://localhost:5342/users",
            "jdbc://localhost:5342/customers"

    );
}
