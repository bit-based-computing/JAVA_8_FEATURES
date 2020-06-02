package lambdaExpression;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    public List<Person> findPersons(List<Person> persons, Filter criteria){
        List<Person> matchPerson = new ArrayList<>();
        for(Person person : persons){
            if(criteria.match(person)){
                matchPerson.add(person);
            }
        }
        return  matchPerson;
    }

    public List<String> findPersonsProperties(List<Person> persons,Properties properties){
        List<String> propertiesValue = new ArrayList<>();
        for(Person person: persons){
            propertiesValue.add(properties.getProperties(person));
        }
        return propertiesValue;
    }


}
