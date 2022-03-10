package betterburrito;

import java.util.HashMap;
import java.util.Map;

import burrito.PortionSize;
import burrito.Protein;
import burrito.Size;
import burrito.Topping;

/**
 * an abstract class for Burrito Builder.
 *
 * @param <T> extends of BurritoBuilder
 */
public abstract class BurritoBuilder<T extends BurritoBuilder<T>> {
  protected Map<Protein, PortionSize> proteins;
  protected Map<Topping, PortionSize> toppings;
  protected Size size;

  public BurritoBuilder() {
    this.proteins = new HashMap<>();
    this.toppings = new HashMap<>();
  }

  public T size(Size size) {
    this.size = size;
    return returnBuilder();
  }

  public T addProtein(Protein protein, PortionSize portionSize) {
    this.proteins.put(protein, portionSize);
    return returnBuilder();
  }

  public T addTopping(Topping topping, PortionSize portionSize) {
    this.toppings.put(topping, portionSize);
    return returnBuilder();
  }


  public abstract ObservableBurrito build();

  protected abstract T returnBuilder();
}
