package streamApiExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<Developer> team = new ArrayList<>();
        Developer polyglot = new Developer("Developer x");
        polyglot.add("Java")
                .add("Groovy")
                .add("Go")
                .add("Scala")
                .add("Kotlin");
        Developer busy = new Developer("Developer Y");
        busy.add("javascript")
                .add("python");
        team.add(polyglot);
        team.add(busy);

        team.stream()
                .map(developer -> developer.getLanguages())
                .flatMap(language -> language.stream())
                .collect(Collectors.toList())
                .forEach(item -> System.out.println(item + ", "));

        // writing it by method reference
        team.stream()
                .map(Developer::getLanguages)
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }
}
