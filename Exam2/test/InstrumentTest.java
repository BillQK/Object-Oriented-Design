import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import cs3500.band.Instrument;
import cs3500.band.InstrumentType;

import static org.junit.Assert.assertEquals;

public class InstrumentTest {
  @Test
  public void testInstrument() {
    Set<Instrument> bandCloset = new HashSet<>();
    Instrument tuba = new Instrument("Tuba", InstrumentType.BASS);
    bandCloset.add(tuba);
    Instrument sousaphone = new Instrument("Tuba", InstrumentType.BASS);
    bandCloset.add(sousaphone);
    Instrument guitar = new Instrument("Guitar",
            InstrumentType.CHORD, InstrumentType.MELODY);
    assertEquals(Arrays.asList(InstrumentType.CHORD, InstrumentType.MELODY), guitar.getTypes());
    bandCloset.add(guitar);
    Instrument bassGuitar = new Instrument("Bass Guitar", InstrumentType.BASS);
    bandCloset.add(bassGuitar);
    Instrument piano = new Instrument("Piano", InstrumentType.CHORD);
    bandCloset.add(piano);
    assertEquals(4, bandCloset.size());
  }


}
