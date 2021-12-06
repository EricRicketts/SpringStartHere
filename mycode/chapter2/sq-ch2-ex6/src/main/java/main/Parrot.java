package main;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name;

    public Parrot() {
        this.name = "Polly";
    }

    public Parrot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
