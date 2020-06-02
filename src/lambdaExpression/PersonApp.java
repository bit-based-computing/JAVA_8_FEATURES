package lambdaExpression;

import java.util.List;

public class PersonApp {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("name1", 10L),
                new Person("name2", 11L),
                new Person("name3", 12L),
                new Person("name4", 13L),
                new Person("name5", 14L),
                new Person("name6", 21L),
                new Person("name7", 22L),
                new Person("name8", 23L),
                new Person("name9", 24L),
                new Person("name10", 25L)
        );
        // Get all person under 20 year age
        PersonService personService = new PersonService();
        List<Person> personUnder20YearAge = personService.findPersons(personList,(Person person)->{
           return  person.getAge() < 20;
        });
        System.out.println(personUnder20YearAge);
        // Get all person upper 20 age
        List<Person> personUpper20YearAge = personService.findPersons(personList,(Person person)->{
            return  person.getAge() > 20;
        });
        System.out.println(personUnder20YearAge);

        // assigned in variable
        Properties properties =  (Person person)-> {return person.getName();};

        // Get all person name
        List<String> getAllName = personService.findPersonsProperties(personList,properties);
        System.out.println(getAllName);

        // Get all person name by method reference
        List<String> getAllNames = personService.findPersonsProperties(personList,Person::getName);
        System.out.println(getAllNames);
    }
}
