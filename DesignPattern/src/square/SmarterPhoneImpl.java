package square;

public class SmarterPhoneImpl extends BasicPhone implements SmarterPhone {

  private Person person;
  public SmarterPhoneImpl(float phoneNumber) {
    super();
    this.person = new Person.PersonBuilder().setPhoneNumber(phoneNumber).build();
  }

  @Override
  public void call(Person receiver) {
    person.setMessage("Calling " + receiver.getPhoneNumber());
    receiver.setMessage("Ringing from " + person.getPhoneNumber());
  }
}
