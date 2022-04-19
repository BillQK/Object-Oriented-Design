package cs3500.band;

import java.util.List;

public interface Requirement {
  boolean checkRequirement(EnsembleType type, List<InstrumentType> instrumentTypeList, List<Musician> musicianList);
}
