package dev.shermende.benchmark;

import dev.shermende.ClassicProxy;
import dev.shermende.model.IOrigin;
import dev.shermende.model.IOriginImpl;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@Fork(1)
@Threads(10)
@Warmup(iterations = 3)
@Measurement(iterations = 3)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class AbstractFactoryTestBenchmark {

    private IOrigin proxy;

    @Setup(Level.Trial)
    public synchronized void benchmarkSetup() {
        System.out.println("benchmarkSetup");
        proxy = (IOrigin) ClassicProxy.build(new IOriginImpl());
    }

    @Benchmark
    public void benchmark() {
        System.out.println("benchmark");
        proxy.action("itsme");
    }

}
