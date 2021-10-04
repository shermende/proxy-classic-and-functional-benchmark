package dev.shermende;

import dev.shermende.model.IOriginImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FunctionalProxyTest {

    @Test
    void test() {
        var origin = new IOriginImpl();
        var proxy = FunctionalProxy.build(origin::action);
        Assertions.assertEquals("original-action: proxy: itsme.", proxy.apply("itsme"));
    }

}
