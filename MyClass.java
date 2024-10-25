import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//shows how we can call Callables using lambda

public class MyClass {
    static int getValue() {
        return 5;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        Future f = executorService.submit(()-> {
            return "Got the value";
        });
        System.out.println(f.get());

        Future ff = executorService.submit(        () -> {
            TimeUnit.MILLISECONDS.sleep(77);
            return MyClass.getValue();
        });
        executorService.shutdown();

    }
}
