import org.junit.Test;

import cs3500.band.BasicMusician;
import cs3500.band.Ensemble;
import cs3500.band.EnsembleImpl;
import cs3500.band.EnsembleType;
import cs3500.band.Instrument;
import cs3500.band.InstrumentType;
import cs3500.band.Musician;
import cs3500.band.Piece;

import static org.junit.Assert.assertEquals;

public class EnsembleImplTest {
  Instrument piano = new Instrument("Piano", InstrumentType.CHORD);
  Instrument bassGuitar = new Instrument("Bass Guitar", InstrumentType.BASS);
  Instrument guitar = new Instrument("Guitar",
          InstrumentType.CHORD, InstrumentType.MELODY);
  Instrument tuba = new Instrument("Tuba", InstrumentType.PERCUSSION);

  Musician m = new BasicMusician("Khanh", bassGuitar, true);
  Musician m1 = new BasicMusician("Kane", piano, true);
  Musician m2 = new BasicMusician("Sea Salt", guitar, true);
  Musician m3 = new BasicMusician("Michael", tuba, true);

  Ensemble ensemble = new EnsembleImpl(EnsembleType.ROCK);

  @Test
  public void testAddMusician() {
    ensemble.addMusician(m);
    ensemble.addMusician(m1);
    ensemble.addMusician(m2);
    ensemble.addMusician(m3);

    assertEquals(ensemble.getMusician("Khanh"), m);
    assertEquals(ensemble.getMusician("Kane"), m1);
    assertEquals(ensemble.getMusician("Sea Salt"), m2);
    assertEquals(ensemble.getMusician("Michael"), m3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveMusician() {
    ensemble.removeMusician("Khanh");
    // throw exception
    ensemble.getMusician("Khanh");
  }

  @Test
  public void testIsCompleteRock() {
    ensemble.addMusician(m);
    ensemble.addMusician(m1);
    ensemble.addMusician(m2);
    ensemble.addMusician(m3);

    assertEquals(ensemble.isComplete(), true);
  }

  @Test
  public void testCanPlay() {
    Piece p = new Piece("Hello - Adele");
    m.addToRepertoire(p);
    m1.addToRepertoire(p);
    m2.addToRepertoire(p);
    m3.addToRepertoire(p);

    ensemble.addMusician(m);
    ensemble.addMusician(m1);
    ensemble.addMusician(m2);
    ensemble.addMusician(m3);

    assertEquals(ensemble.canPlay(p), true);
  }
}