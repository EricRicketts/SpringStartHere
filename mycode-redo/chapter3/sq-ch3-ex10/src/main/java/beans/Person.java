package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
  private final String name;

  private final Parrot parrot;

  @Autowired
  public Person(Parrot parrot2) {
    this.name = "Ellie";
    this.parrot = parrot2;
  }
  public String getName() {
    return name;
  }

  public Parrot getParrot() {
    return parrot;
  }
}
