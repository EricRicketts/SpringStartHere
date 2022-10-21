package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
  private String name;
  private final Person person;

  @Autowired
  public Parrot(Person person) {
    this.setName("Polly");
    this.person = person;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Parrot: " + this.getName();
  }
}
