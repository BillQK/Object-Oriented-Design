package square;

import java.util.ArrayList;
import java.util.List;

public class Person {
  private final float phoneNumber;
  private String message;
  private final List<Person> contactList;

  public Person(PersonBuilder p) {
    this.phoneNumber = p.phoneNumber;
    this.message = p.message;
    this.contactList = p.contactList;
  }

  public void setMessage(String message) {
    this.message += message;
  }

  public float getPhoneNumber() {
    return phoneNumber;
  }

  public String getMessage() {
    return message;
  }

  public List<Person> getContactList() {
    return contactList;
  }

  public void setContactList(Person... people) {
    for (Person p : people) {
      contactList.add(p);
    }
  }

  public static class PersonBuilder {
    private float phoneNumber;
    private String message;
    private final List<Person> contactList;


    public PersonBuilder() {
      contactList = new ArrayList<>();
    }

    public PersonBuilder setPhoneNumber(float n) {
      phoneNumber = n;
      return this;
    }

    public PersonBuilder setMessage(String message) {
      this.message = message;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }
}
