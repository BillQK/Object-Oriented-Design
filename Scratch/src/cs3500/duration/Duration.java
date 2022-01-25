// can duration be negative ? Np
// what is the resolution of duration? 1 second


// what do want to do ?
// add / subtract
// represent as string
// compare one duration to another
// check one duration for equality with another?
// get in hours or minutes?
package cs3500.duration;

/**
 *   Represent a Duration
 */
public interface Duration extends Comparable<Duration> {
  /**
   *
   * @param b
   * @return
   */
  Duration add(Duration b);

  /**
   *
   * @return
   */
  String asHms();



  /**
   *
   * @param b
   * @return
   */
  // int compareTo(Duration b);
  // a.compareTo(b) : negative --> a < b
  //                : zero --> a == b
  //                : positive --> a > b
}
