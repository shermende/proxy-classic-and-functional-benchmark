package dev.shermende;

import java.util.function.Function;

public class FunctionalProxy {

    public static Function<String, String> build(
            Function<String, String> function
    ) {
        return t -> function.apply(String.format("%s: %s", "proxy", t));
    }

}
