package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  private Point left = new Point(-2.2);
  private Point right = new Point(4.4);
  private IntervalBuilder intervalBuilder;
  private IntervalBuilder intervalBuilder2;

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
    this.intervalBuilder = new IntervalBuilder();
    this.intervalBuilder2 = new IntervalBuilder();
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));
    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenInc3ludeWithIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).open(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertFalse(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWit3hIncludedValueThenTrue() {
    Interval interval = this.intervalBuilder.open(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertFalse(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenIntervaOpenOpenlwhenIncludeWithInclude5dValueThenTrue() {
    Interval interval = this.intervalBuilder.closed(left.getEquals()).closed(right.getEquals()).build();
    assertFalse(interval.include(left.getLess()));
    assertTrue(interval.include(left.getEquals()));
    assertTrue(interval.include(left.getGreater()));

    assertTrue(interval.include(right.getLess()));
    assertTrue(interval.include(right.getEquals()));
    assertFalse(interval.include(right.getGreater()));
  }

  @Test
  public void givenTwoIntervalsOpenOpenWhenIntersectionThenFalse() {
    Interval firstInterval = this.intervalBuilder.open(left.getEquals()).open(left.getGreater()).build();
    Interval secondInterval = this.intervalBuilder2.open(right.getEquals()).open(right.getGreater()).build();
    assertFalse(firstInterval.intersects(secondInterval));
    secondInterval = this.intervalBuilder2.open(left.getGreater()).open(right.getGreater()).build();
    assertFalse(firstInterval.intersects(secondInterval));
  }

  @Test
  public void givenTwoIntervalsOpenOpenWhenIntersectionThenTrue() {
    Interval firstInterval = this.intervalBuilder.open(left.getEquals()).open(left.getGreater()).build();
    Interval secondInterval = this.intervalBuilder2.open(left.getEquals()).open(right.getGreater()).build();
    assertTrue(firstInterval.intersects(secondInterval));
  }

}