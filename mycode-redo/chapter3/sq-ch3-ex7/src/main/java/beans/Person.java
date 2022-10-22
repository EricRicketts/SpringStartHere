package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
  private String name;

  private final Parrot parrot;

  @Autowired
  public Person(Parrot parrot) {
    this.name = "Ellie";
    this.parrot = parrot;
  }
  public String getName() {
    return name;
  }

  public Parrot getParrot() {
    return parrot;
  }

  public void setName(String name) {
    this.name = name;
  }
}