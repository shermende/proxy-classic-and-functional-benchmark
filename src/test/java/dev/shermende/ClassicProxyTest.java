package dev.shermende;

import dev.shermende.model.IOrigin;
import dev.shermende.model.IOriginImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClassicProxyTest {

    @Test
    void test() {
        final IOrigin build = (IOrigin) ClassicProxy.build(new IOriginImpl());
        Assertions.assertEquals("original-action: proxy: [itsme].", build.action("itsme"));
    }

}
