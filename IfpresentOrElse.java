package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IfpresentOrElse {

    public static List<String> filterLisst(List<String> list) {
        return list.stream().filter(s->s.startsWith("k"))
                .collect(Collectors.toList());



    }

    public static void main(String[] args) {
        List<String> mn = new ArrayList<>();
        mn.add("a");
        mn.add("b");
        mn.add("c");
        mn.add("d");
        mn.add("ab");
        Optional<String> maybeK = mn.stream()
                .filter(s -> s != null && s.startsWith("a"))
                .findFirst();



        // Use ifPresentOrElse to act on the result.
        maybeK.ifPresentOrElse(
                // Consumer – element found
                found -> {
                    // You can place any logic you need here.
                    // For demonstration we just print it.
                   // System.out.println("Found element starting with 'k': " + found);
                },
                // Runnable – no element found
                () -> {
                    // Handle the empty case (e.g., log, throw, etc.).
                   // System.out.println("No element starting with 'k' was found.");
                }
        );

        // Return the found element (or null if none)
        String rs = maybeK.orElse("VVVVVV");
        System.out.println(rs);









    }
}
