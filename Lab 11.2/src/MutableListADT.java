/**
 * A interface of mutable list.
 * @param <T> a element in list
 */
public interface MutableListADT<T> extends ListADT<T> {
  ImmutableListADT<T> getImmutableList();
}
