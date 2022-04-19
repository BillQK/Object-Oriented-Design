package cs3500.band;

import java.util.List;

public class HipHop implements Requirement {
  @Override
  public boolean checkRequirement(EnsembleType type, List<InstrumentType> instrumentTypeList, List<Musician> musicianList) {
    return false;
  }
}
