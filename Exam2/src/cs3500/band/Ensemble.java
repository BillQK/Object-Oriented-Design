package cs3500.band;

/**
 * Represents a group of musicians.
 */
public interface Ensemble {

  /**
   * Add a musician to the ensemble.
   * @param m the musician to add.
   * @throws IllegalArgumentException if a musician with the same name already exists in the
   * ensemble, or the musician is otherwise invalid.
   */
  void addMusician(Musician m);

  /**
   * Remove a musician from the ensemble.
   * @param name the name of the musician to remove
   */
  void removeMusician(String name);

  /**
   * Determine if the ensemble is complete according to the rules for its type.
   * @return true if the ensemble is complete, false otherwise
   */
  boolean isComplete();

  /**
   * Determine if the ensemble can play a given piece, namely, if ALL members of the group have it
   * in their repertoire.
   * @param piece the title of the piece
   * @return true if the ensemble can play the piece, false otherwise
   */
  boolean canPlay(Piece piece);

  /**
   * Get a Musician from the group by name.
   * @param name the musician's name
   * @return the Musician with the given name
   * @throws IllegalArgumentException if there is no such musician in the ensemble
   */
  Musician getMusician(String name);

  /**
   * Get the EnsembleType of the ensemble.
   * @return the EnsembleType of the ensemble.
   */
  EnsembleType getType();
}
