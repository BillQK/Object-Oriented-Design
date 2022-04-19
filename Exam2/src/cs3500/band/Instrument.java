package cs3500.band;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents a musical instrument. A "value object" suitable for use in collections.
 */
public class Instrument {
  private final String name;
  private final List<InstrumentType> types;

  /**
   * Create the instrument with the given name and one or more instrument types.
   *
   * @param name the name of the instrument
   * @param type the type(s) of the instrument
   * @throws IllegalArgumentException if the name is null or no type supplied
   */
  public Instrument(String name, InstrumentType... type) {
    if (name == null || type == null || type.length == 0) {
      throw new IllegalArgumentException("Must specify valid name and type");
    }
    this.name = name;
    this.types = Arrays.asList(type);
  }

  /**
   * Get the name of the instrument
   *
   * @return the name of the instrument
   */
  public String getName() {
    return name;
  }

  /**
   * Get the types of the instrument
   *
   * @return the types of the instrument
   */
  public List<InstrumentType> getTypes() {
    return new ArrayList<>(this.types);
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Instrument) &&
            ((Instrument) o).name.equals(name) && ((Instrument) o).types.equals(types);

  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name, this.types);
  }
}
