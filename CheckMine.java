import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//java completablefuture allOfExample, wait until all the taks have completed
//Code https://medium.com/@AlexanderObregon/javas-completablefuture-allof-explained-0a032b657541
public class CheckMine {


    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Task 1");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Task 2");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "Task 3");

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);

        // Collect the results into a list
        CompletableFuture<List<String>> allResults = allFutures.thenApply(v -> Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.toList()));

        try {
            List<String> results = allResults.get();
            results.forEach(System.out::println);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
