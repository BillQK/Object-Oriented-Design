package betterburrito;

import java.util.Map;

import burrito.PortionSize;
import burrito.Protein;
import burrito.Size;
import burrito.Topping;

/**
 * This class represents a custom burrito that can have an arbitrary number
 * of proteins and toppings, both of arbitrary portion sizes.
 */
public class CustomBurrito<T extends BurritoBuilder<T>> implements ObservableBurrito {
  protected final Map<Protein, PortionSize> proteins;
  protected final Map<Topping, PortionSize> toppings;
  protected Size size;

  /**
   * Create a custom burrito of the specified size.
   *
   * @param builder a CustomBurritoBuilder
   */
  protected CustomBurrito(BurritoBuilder<T> builder) {
    this.size = builder.size;
    this.proteins = builder.proteins;
    this.toppings = builder.toppings;

  }

  @Override
  public double cost() {
    double cost = 0.0;
    for (Map.Entry<Protein, PortionSize> item : this.proteins.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultipler();
    }

    for (Map.Entry<Topping, PortionSize> item : this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultipler();
    }
    return cost + this.size.getBaseCost();
  }

  @Override
  public PortionSize hasTopping(Topping name) {
    return this.toppings.getOrDefault(name, null);
  }

  @Override
  public PortionSize hasProtein(Protein name) {
    return this.proteins.getOrDefault(name, null);
  }


  /**
   * a representation of a custom BurritoBuilder.
   */
  public static class CustomBurritoBuilder extends BurritoBuilder<CustomBurritoBuilder> {

    public CustomBurritoBuilder() {
      super();
    }

    @Override
    public CustomBurrito<CustomBurritoBuilder> build() {
      if (size == null) {
        throw new IllegalStateException("Size cannot be null");
      }
      return new CustomBurrito<>(this);
    }

    protected CustomBurritoBuilder returnBuilder() {
      return this;
    }

  }

}


/**
 * Coffee.CoffeeBuilder().dairy("milk").sugar().build()
 *
 *
 * coffee {
 *
 *  private Coffee(CoffeeBuilder s) {
 *    this.dairy = s.dairy;
 *    this.sugar = s.sugar;
 *  }
 *
 *  public static CoffeeBuilder() {
 *    String dairyType
 *    boolean sugar;
 *
 *    CoffeeBuilder(String s, boolean sugar) {
 *      this.dairyType = s;
 *      this.sugar = sugar;
 *    }
 *
 *    CoffeeBuilder setDairy(Str s) {
 *      this.dairyType = s;
 *      return CoffeeBuilder
 *    }
 *
 *    Coffee build() {
 *      return new Coffee(this);
 *    }
 *  }
 *
 * }
 */