package dev.shermende;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ClassicProxy {

    public static <T> Object build(
            T t
    ) {
        return Proxy.newProxyInstance(
                t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                (o, method, args) -> method.invoke(t, String.format("%s: %s", "proxy", Arrays.toString(args)))
        );
    }

}
