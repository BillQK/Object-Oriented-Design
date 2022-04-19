package cs3500.band;

/**
 * Represents a single musician, uniquely identified by name.
 */
public interface Musician {

  /**
   * Get the name of the musician.
   * @return the musician's name
   */
  String getName();

  /**
   * Indicate whether the musician can sing.
   * @return true if the musician can sing, false otherwise
   */
  boolean canSing();

  /**
   * Get the musician's Instrument.
   * @return the musician's Instrument
   */
  Instrument getInstrument();

  /**
   * Add a piece of music to the musician's repertoire*.
   * *repertoire: pieces the musician is able to play
   * @param piece the piece of music
   */
  void addToRepertoire(Piece piece);

  /**
   * Determine if the musician can play a given piece of music, i.e., if the piece is in their
   * repertoire.
   *
   * @param piece the piece of music
   * @return true if the musician can play it, false otherwise
   */
  boolean canPlay(Piece piece);
}
