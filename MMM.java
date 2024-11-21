import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//demo of ExecutorCompletionService
//code inspired from == https://medium.com/@madhucynixit/executorservice-vs-executorcompletionservice-in-java-ec49f7830de7

class A implements Callable {
    String s1;
    public A(String s) {
        this.s1 = s;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(45);
            if (s1.equals("b"))
                Thread.sleep(3000);

        } catch (Exception e) {

        }
        return s1;
    }
}

public class MMM {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletionService executorCompletionService= new ExecutorCompletionService<>(executorService );

        List<Future> futures = new ArrayList<Future>();
        futures.add(executorCompletionService.submit(new A("dwewe")));
        futures.add(executorCompletionService.submit(new A("b")));
        futures.add(executorCompletionService.submit(new A("dwewcwdcwe")));
        futures.add(executorCompletionService.submit(new A("bb")));
        for (int i=0; i<futures.size(); i++) {
            String result = (String) executorCompletionService.take().get();
           System.out.println(result);
        }
        executorService.shutdown();



    }
}
