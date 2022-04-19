package square;

public class BasicPhone implements Phone {
  private final Person person;

  public BasicPhone() {
    this.person = new Person.PersonBuilder().setPhoneNumber(103435041).setMessage("").build();
  }

  @Override
  public void text(String message, Person receiver) {
    person.setContactList(receiver);
    person.setMessage("To: " + message);
    receiver.setMessage("From: " + message);
    System.out.println(person.getPhoneNumber() + "texted: "
            + message + " to " + receiver.getPhoneNumber());
  }

}
