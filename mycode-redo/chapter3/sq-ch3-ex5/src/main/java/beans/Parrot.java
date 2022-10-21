package beans;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
  private String name;

  public Parrot() {
    this.setName("Polly");
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
