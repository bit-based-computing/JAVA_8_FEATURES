package streamApiExample;

import lambdaExpression.Person;

import java.util.Comparator;
import java.util.Comparator.*;
import java.util.List;

public class SortedExample {
    public static int compaeByAgeAndThenName(Person p1, Person p2){
        if(p1.getAge() < p2.getAge())return -1;
        else if(p1.getAge() > p2.getAge()){
            return 1;
        }else{
            return p1.getName().compareTo(p2.getName());
        }
    }
    public static void printPerson(Person p){
        System.out.println(p.getName());
    }
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Foysal", 24L),
                new Person("Suvo" , 20L),
                new Person("Asif", 15L),
                new Person("Wahid", 18L),
                new Person("Noman", 30L)
        );

        personList.stream()
                .sorted((p1,p2)->{
                    if(p1.getAge() < p2.getAge())return -1;
                    else if(p1.getAge() > p2.getAge()){
                        return 1;
                    }else{
                       return p1.getName().compareTo(p2.getName());
                    }
                })
                .forEach(person ->System.out.println(person.getName()));
        System.out.println();
        // writing this by calling function
        personList.stream()
                .sorted((p1,p2)->compaeByAgeAndThenName(p1,p2))
                .forEach(peson -> printPerson(peson));
        System.out.println();

        // writing this by method reference
        personList.stream()
                .sorted(SortedExample::compaeByAgeAndThenName)
                .forEach(SortedExample::printPerson);
        System.out.println();

        // writing by comparator
        personList.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                .forEach(SortedExample::printPerson);
        System.out.println();

        // there can be null any filed age or name then it will throw an nullPoint Exception
        // we can handle it by using nullsFirst or nullsLast

        personList.stream()
                .sorted(Comparator
                        .nullsFirst(Comparator.comparing(Person::getAge))
                        .thenComparing(Comparator
                        .nullsFirst(Comparator.comparing(Person::getName))))
                        .forEach(SortedExample::printPerson);



    }
}
