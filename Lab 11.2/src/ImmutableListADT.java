/**
 * A interface for immutable list.
 * @param <T> a element of the list.
 */
public interface ImmutableListADT<T> extends CommonListADT<T> {
  MutableListADT<T> getMutableList();
}
