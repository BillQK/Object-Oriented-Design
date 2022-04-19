import java.util.function.Function;

/**
 * A representation for immutable list.
 * @param <T> an element in list
 */
public class ImmutableListADTImpl<T> implements ImmutableListADT<T> {
  private final ListADT<T> delegate;

  private ImmutableListADTImpl(ImmutableListBuilder<T> delegate) {
    this.delegate = delegate.listADT;
  }

  /**
   * Return the number of objects currently in this list.
   *
   * @return the size of the list
   */
  @Override
  public int getSize() {
    return delegate.getSize();
  }

  private void addBack(T b) {
    delegate.addBack(b);
  }

  /**
   * Get the (index)th object in this list.
   *
   * @param index the index of the object to be returned
   * @return the object at the given index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  @Override
  public T get(int index) throws IllegalArgumentException {
    return delegate.get(index);
  }

  /**
   * A general purpose map higher order function on this list, that returns
   * the corresponding list of type R.
   *
   * @param converter the function that converts T into R
   * @return the resulting list that is identical in structure to this list,
   *         but has data of type R
   */
  @Override
  public <R> CommonListADT<R> map(Function<T, R> converter) {
    ImmutableListBuilder<R> builder = new ImmutableListBuilder<>();
    for (int i = 0; i < delegate.getSize(); i++) {
      builder.add(converter.apply(delegate.get(i)));
    }
    return builder.build();
  }

  @Override
  public MutableListADT<T> getMutableList() {
    MutableListADT<T> s = new MutableListADTImpl<>();
    for (int i = 0; i < delegate.getSize(); i++) {
      s.addFront(delegate.get(i));
    }
    return s;
  }

  /**
   * A builder class.
   * @param <T> an element in list
   */
  public static class ImmutableListBuilder<T> {
    private final ListADT<T> listADT;

    public ImmutableListBuilder() {
      this.listADT = new ListADTImpl<>();
    }

    public ImmutableListBuilder<T> add(T b) {
      listADT.addBack(b);
      return this;
    }

    public ImmutableListADTImpl<T> build() {
      return new ImmutableListADTImpl<T>(this);
    }

  }
}
