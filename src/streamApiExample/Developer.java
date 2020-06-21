package streamApiExample;

import java.util.HashSet;
import java.util.Set;

public class Developer {
    private String name;
    private Set<String> languages = new HashSet<>();
    public Developer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Developer setName(String name) {
        this.name = name;
        return this;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public Developer add(String language) {
        this.languages.add(language);
        return this;
    }
}
