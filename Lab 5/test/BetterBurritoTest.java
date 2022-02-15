import org.junit.Before;
import org.junit.Test;

import betterburrito.BurritoBuilder;
import betterburrito.CustomBurrito;
import betterburrito.ObservableBurrito;
import betterburrito.VeggieBurrito;
import burrito.PortionSize;
import burrito.Protein;
import burrito.Size;
import burrito.Topping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * A test class for better burrito test.
 */
public class BetterBurritoTest {
  // initialize the builder
  private BurritoBuilder<CustomBurrito.CustomBurritoBuilder> builder;


  @Before
  public void setUp() {
    builder = new CustomBurrito.CustomBurritoBuilder();
  }

  @Test
  public void testCustomBuilder() {
    ObservableBurrito observableBurrito =
            builder.size(Size.Normal).
                    addProtein(Protein.Tofu, PortionSize.Normal).
                    addTopping(Topping.Cheese, PortionSize.Normal).
                    addTopping(Topping.MediumSalsa, PortionSize.Less).
                    addTopping(Topping.SourCream, PortionSize.Extra).
                    build();


    assertEquals(observableBurrito.hasProtein(Protein.Tofu), PortionSize.Normal);
    assertEquals(observableBurrito.hasTopping(Topping.Cheese), PortionSize.Normal);
    assertEquals(observableBurrito.hasTopping(Topping.MediumSalsa), PortionSize.Less);
    assertEquals(observableBurrito.hasTopping(Topping.SourCream), PortionSize.Extra);
    assertEquals(observableBurrito.cost(), 5.9, 0.01);


  }

  @Test
  public void testVeggiesBuilder() {
    ObservableBurrito veggieBurritoJumboSize =
            new VeggieBurrito.VeggieBurritoBuilder()
                    .size(Size.Jumbo)
                    .build();

    assertEquals(veggieBurritoJumboSize.hasProtein(Protein.BlackBeans), PortionSize.Normal);
    assertEquals(veggieBurritoJumboSize.hasTopping(Topping.MediumSalsa), PortionSize.Normal);
    assertEquals(veggieBurritoJumboSize.hasTopping(Topping.Cheese), PortionSize.Normal);
    assertEquals(veggieBurritoJumboSize.hasTopping(Topping.Lettuce), PortionSize.Normal);
    assertEquals(veggieBurritoJumboSize.hasTopping(Topping.Guacamole), PortionSize.Normal);


    ObservableBurrito veggieBurrito =
            new VeggieBurrito.VeggieBurritoBuilder()
                    .noCheese().noGuacamole()
                    .size(Size.Normal).build();

    assertEquals(veggieBurrito.hasProtein(Protein.BlackBeans), PortionSize.Normal);
    assertEquals(veggieBurrito.hasTopping(Topping.MediumSalsa), PortionSize.Normal);
    assertNull(veggieBurrito.hasTopping(Topping.Cheese));
    assertEquals(veggieBurrito.hasTopping(Topping.Lettuce), PortionSize.Normal);
    assertNull(veggieBurrito.hasTopping(Topping.Guacamole));


  }

  @Test(expected = IllegalStateException.class)
  public void testNoSize() {
    ObservableBurrito customburrito = new CustomBurrito.CustomBurritoBuilder()
            .addTopping(Topping.Cheese, PortionSize.Normal)
            .addProtein(Protein.Tofu, PortionSize.Normal)
            .build();
  }

}
