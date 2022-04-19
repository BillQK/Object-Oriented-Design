package cs3500.band;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

  public class EnsembleImpl implements Ensemble {
    private final List<Musician> musicians;
    private final List<InstrumentType> instrumentTypes;
    private final EnsembleType type;

    private final List<InstrumentType> ROCK_REQUIREMENT =
            List.of(InstrumentType.BASS,
                    InstrumentType.CHORD,
                    InstrumentType.MELODY,
                    InstrumentType.PERCUSSION);

    private final List<InstrumentType> CLASSICAL_REQUIREMENT =
            List.of(InstrumentType.BASS,
                    InstrumentType.MELODY);

    public EnsembleImpl(EnsembleType type) {
      this.type = type;
      this.musicians = new ArrayList<>();
      this.instrumentTypes = new ArrayList<>();
    }

    /**
     * Add a musician to the ensemble.
     *
     * @param m the musician to add.
     * @throws IllegalArgumentException if a musician with the same name already exists in the
     *                                  ensemble, or the musician is otherwise invalid.
     */
    @Override
    public void addMusician(Musician m) {
      if (m == null) {
        throw new IllegalArgumentException("Musician is invalid");
      }
      boolean match = musicians.stream().anyMatch(o -> o.getName().equals(m.getName()));
      if (match) {
        throw new IllegalArgumentException("Musical already exists in the ensemble");
      }
      instrumentTypes.addAll(m.getInstrument().getTypes());
      musicians.add(m);
    }

    /**
     * Remove a musician from the ensemble.
     *
     * @param name the name of the musician to remove
     */
    @Override
    public void removeMusician(String name) {
      for (int i = 0; i < musicians.size(); i++) {
        if (musicians.get(i).getName().equals(name)) {
          musicians.get(i).getInstrument().getTypes().forEach(instrumentTypes::remove);
          musicians.set(i, null);
        }
      }
    }

    /**
     * Determine if the ensemble is complete according to the rules for its type.
     *
     * @return true if the ensemble is complete, false otherwise
     */
    @Override
    public boolean isComplete() {
      if (type == EnsembleType.ROCK) {
       return instrumentTypes.containsAll(ROCK_REQUIREMENT)
               && musicians.stream().anyMatch(o -> o.canSing());
      }
      if (type == EnsembleType.CLASSICAL) {
        int size = 0;
        for (int i = 0; i < musicians.size(); i++) {
          if (musicians.get(i) != null) {
            size++;
          }
        }
        return instrumentTypes.containsAll(CLASSICAL_REQUIREMENT)
                && size >= 4;
      }
      return false;

    }

    /**
     * Determine if the ensemble can play a given piece, namely, if ALL members of the group have it
     * in their repertoire.
     *
     * @param piece the title of the piece
     * @return true if the ensemble can play the piece, false otherwise
     */
    @Override
    public boolean canPlay(Piece piece) {
      if (piece == null) {
        throw new IllegalArgumentException("Piece is not valid");
      }
      return musicians.stream().allMatch(o -> o.canPlay(piece));
    }

    /**
     * Get a Musician from the group by name.
     *
     * @param name the musician's name
     * @return the Musician with the given name
     * @throws IllegalArgumentException if there is no such musician in the ensemble
     */
    @Override
    public Musician getMusician(String name) {
      boolean match = musicians.stream().anyMatch(o -> o.getName().equals(name));
      if (!match) {
        throw new IllegalArgumentException("No such musician in the ensemble");
      }
      Musician ret = null;
      for (Musician musician : musicians) {
        if (musician.getName().equals(name)) {
          ret = musician;
        }
      }
      return ret;
    }

    /**
     * Get the EnsembleType of the ensemble.
     *
     * @return the EnsembleType of the ensemble.
     */
    @Override
    public EnsembleType getType() {
      return this.type;
    }
  }
