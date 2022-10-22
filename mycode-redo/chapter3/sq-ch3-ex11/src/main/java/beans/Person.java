package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
  private final String name;

  private final Parrot parrot;

  @Autowired
  public Person(@Qualifier("parrot2") Parrot parrot) {
    this.name = "Ellie";
    this.parrot = parrot;
  }
  public String getName() {
    return name;
  }

  public Parrot getParrot() {
    return parrot;
  }
}
