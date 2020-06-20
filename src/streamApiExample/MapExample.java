package streamApiExample;

import lambdaExpression.Person;

import java.util.Comparator;
import java.util.List;

public class MapExample {
    public static void main(String[] args) {
        // map use to convert data from one type to another type
        // here we convert Person type to String type
        List<Person> personList = List.of(
                new Person("foysal",24L),
                new Person("name1",10L),
                new Person("name2",12L),
                new Person("name3",13L),
                new Person("name4",15L),
                new Person("name5",18L),
                new Person("name6",20L),
                new Person("name7",50L),
                new Person("name8",30L)
        );

        personList.stream()
                .filter(person -> person.getAge() <= 15)
                .map(person -> person.getName())
                .forEach(name -> System.out.print(name + ", "));
        System.out.println();

        //Writing by method reference
        // to get all age by sorted way
         personList.stream()
                 .sorted(Comparator.comparing(Person::getAge))
                 .map(Person::getAge)
                 .forEach(System.out::println);

    }
}
