package dev.shermende.benchmark;

import dev.shermende.FunctionalProxy;
import dev.shermende.model.IOrigin;
import dev.shermende.model.IOriginImpl;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

import java.util.function.Function;

@Fork(1)
@Threads(10)
@Warmup(iterations = 3)
@Measurement(iterations = 3)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
public class FunctionalProxyBenchmark {

    private final IOrigin origin = new IOriginImpl();
    private Function<String, String> proxy;

    @Setup(Level.Trial)
    public synchronized void benchmarkSetup() {
        proxy = FunctionalProxy.build(origin::action);
    }

    @Benchmark
    public void benchmark() {
        proxy.apply("itsme");
    }

}
