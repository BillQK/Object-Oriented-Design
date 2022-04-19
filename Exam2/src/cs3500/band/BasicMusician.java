package cs3500.band;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a musician, including their name, instrument, and abilities.
 */
public class BasicMusician implements Musician {
  private final String name;
  private final Instrument instrument;
  private final boolean canSing;
  private final Set<Piece> repertoire;

  public BasicMusician(String name, Instrument instrument, boolean canSing) {
    if (name == null || name.equals("") || instrument == null) {
      throw new IllegalArgumentException("Must supply valid name and instrument");
    }
    this.name = name;
    this.instrument = instrument;
    this.canSing = canSing;
    this.repertoire = new HashSet<>();
  }

  public BasicMusician(BasicMusician m) {
    this.name = m.name;
    this.instrument = m.instrument;
    this.canSing = m.canSing;
    this.repertoire = new HashSet<>(m.repertoire);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean canSing() {
    return canSing;
  }

  @Override
  public Instrument getInstrument() {
    return instrument;
  }

  @Override
  public void addToRepertoire(Piece piece) {
    repertoire.add(piece);
  }

  @Override
  public boolean canPlay(Piece piece) {
    return repertoire.contains(piece);
  }
}
