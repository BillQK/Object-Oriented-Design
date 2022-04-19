/**
 * A representation of the mutable list.
 * @param <T> a element inside the list.
 */
public class MutableListADTImpl<T> extends ListADTImpl<T> implements MutableListADT<T> {
  @Override
  public ImmutableListADT<T> getImmutableList() {
    ImmutableListADTImpl.ImmutableListBuilder<T> b =
            new ImmutableListADTImpl.ImmutableListBuilder<T>();
    for (int i = 0; i < super.getSize(); i++) {
      b.add(super.get(i));
    }
    return b.build();
  }
}
