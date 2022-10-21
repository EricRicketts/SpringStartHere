package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
  private String name;

  private Parrot parrot;

  @Autowired
  public Person() {
    this.name = "Ellie";
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

  @Autowired
  public void setParrot(Parrot parrot) {
    this.parrot = parrot;
  }
}
