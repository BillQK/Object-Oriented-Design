package cs3500.citygo;

/**
 * Represents a single shareable electric scooter.
 */
public class Scooter {
  // percentage points of battery charge required per mile traveled
  public static final int MILES_PER_CHARGE_UNIT = 2;
  private final String id;
  private Coord location;
  private Status status;
  private int chargeLevel;

  /**
   * Create the scooter with an ID and location. The ID should uniquely identify the scooter.
   *
   * @param id  the ID
   * @param loc the current location of the scooter
   */
  public Scooter(String id, Coord loc) {
    if (id == null) throw new IllegalArgumentException("Scooter id can't be null");
    this.id = id;
    this.location = loc;
    this.status = Status.AVAILABLE;
    this.chargeLevel = 100;
  }

  /**
   * Copy constructor
   *
   * @param s the scooter to be copied
   */
  public Scooter(Scooter s) {
    this.id = s.id;
    this.location = s.location;
    this.status = s.status;
    this.chargeLevel = s.chargeLevel;
  }

  public String getId() {
    return id;
  }

  Status getStatus() {
    return status;
  }

  void setStatus(Status stat) {
    status = stat;
  }

  public Coord getLocation() {
    return location;
  }

  public int getChargeLevel() {
    return chargeLevel;
  }

  void setChargeLevel(int charge) {
    if (charge < 0 || charge > 100) {
      throw new IllegalArgumentException("Charge must be between 0 and 100");
    }
    chargeLevel = charge;
    if (charge == 0) {
      setStatus(Status.DISABLED);
    }
  }

  void move(Coord newLoc) {
    location = newLoc;
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof Scooter && ((Scooter) o).getId().equals(getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }

  enum Status {
    IN_USE, AVAILABLE, DISABLED
  }
}
