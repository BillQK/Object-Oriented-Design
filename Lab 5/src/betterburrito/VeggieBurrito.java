package betterburrito;

import burrito.PortionSize;
import burrito.Protein;
import burrito.Topping;

/**
 * A representation of a veggie burrito.
 */
public class VeggieBurrito extends CustomBurrito<VeggieBurrito.VeggieBurritoBuilder> {

  /**
   * A constructor of the veggie burrito.
   * @param builder a BurritoBuilder type VeggieBurritoBuilder
   */
  private VeggieBurrito(BurritoBuilder<VeggieBurritoBuilder> builder) {
    super(builder);
  }

  /**
   * A representation of a veggie burrito builder.
   */
  public static class VeggieBurritoBuilder extends BurritoBuilder<VeggieBurritoBuilder> {
    /**
     * A contractor for VeggieBurritoBuilder.
     */
    public VeggieBurritoBuilder() {
      super();

      this.addProtein(Protein.BlackBeans, PortionSize.Normal);
      this.addTopping(Topping.MediumSalsa, PortionSize.Normal);
      this.addTopping(Topping.Cheese, PortionSize.Normal);
      this.addTopping(Topping.Lettuce, PortionSize.Normal);
      this.addTopping(Topping.Guacamole, PortionSize.Normal);
    }

    public VeggieBurritoBuilder noCheese() {
      this.toppings.remove(Topping.Cheese);
      return returnBuilder();
    }

    public VeggieBurritoBuilder noBlackBeans() {
      this.proteins.remove(Protein.BlackBeans);
      return returnBuilder();
    }

    public VeggieBurritoBuilder noMediumSalsa() {
      this.toppings.remove(Topping.MediumSalsa);
      return returnBuilder();
    }

    public VeggieBurritoBuilder noLettuce() {
      this.toppings.remove(Topping.Lettuce);
      return returnBuilder();
    }

    public VeggieBurritoBuilder noGuacamole() {
      this.toppings.remove(Topping.Guacamole);
      return returnBuilder();
    }

    @Override
    public ObservableBurrito build() {
      if (size == null) {
        throw new IllegalStateException("Size cannot be null");
      }
      return new VeggieBurrito(this);
    }

    protected VeggieBurritoBuilder returnBuilder() {
      return this;
    }


  }

}
