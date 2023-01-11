package com.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureExample2 {
    public static class MyAsyncExecutor implements Supplier<Integer> {
        @Override
        public Integer get() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //Suppress: do nothing
            }
            return 1;
        }
    }

    public static class PlusOne implements Function<Integer, Integer> {
        @Override
        public Integer apply(Integer x) {
            return x + 1;
        }
    }
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        CompletableFuture<Integer> f = CompletableFuture.supplyAsync(new MyAsyncExecutor(), exec);
        System.out.println(f.isDone());
        CompletableFuture<Integer> f2 = f.thenApply(new PlusOne());
        System.out.println(f2.get());
    }
}
