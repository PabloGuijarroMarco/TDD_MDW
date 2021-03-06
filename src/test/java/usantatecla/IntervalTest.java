package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {
  
  private Point left = new Point(-2.2);
  private Point right = new Point(4.4);
  private IntervalBuilder intervalBuilder;

  @BeforeEach
  public void before(){
    this.left = new Point(-2.2);
    this.right = new Point(4.4);
    this.intervalBuilder = new IntervalBuilder();
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
    Interval firstInterval = new IntervalBuilder().open(left.getEquals()).open(left.getGreater()).build();
    Interval secondInterval = new IntervalBuilder().open(right.getEquals()).open(right.getGreater()).build();
    assertFalse(firstInterval.intersects(secondInterval));
    secondInterval = new IntervalBuilder().open(left.getGreater()).open(right.getGreater()).build();
    assertFalse(firstInterval.intersects(secondInterval));
    secondInterval = new IntervalBuilder().open(left.getLess()).open(left.getEquals()).build();
    assertFalse(firstInterval.intersects(secondInterval));
  }

  @Test
  public void givenTwoIntervalsOpenOpenWhenIntersectionThenTrue() {
    Interval firstInterval = new IntervalBuilder().open(left.getLess()).open(left.getGreater()).build();
    Interval secondInterval = new IntervalBuilder().open(left.getEquals()).open(right.getGreater()).build();
    assertTrue(firstInterval.intersects(secondInterval));
    firstInterval = new IntervalBuilder().open(left.getEquals()).open(left.getGreater()).build();
    secondInterval = new IntervalBuilder().open(left.getEquals()).open(right.getGreater()).build();
    assertTrue(firstInterval.intersects(secondInterval));
    firstInterval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
    secondInterval = new IntervalBuilder().open(right.getLess()).open(right.getGreater()).build();
    assertTrue(firstInterval.intersects(secondInterval));
  }

  @Test
  public void givenTwoIntervalsCloseCloseWhenIntersectionThenFalse() {
    Interval firstInterval = new IntervalBuilder().closed(left.getEquals()).closed(left.getGreater()).build();
    Interval secondInterval = new IntervalBuilder().closed(right.getEquals()).closed(right.getGreater()).build();
    assertFalse(firstInterval.intersects(secondInterval));
    firstInterval = new IntervalBuilder().closed(left.getGreater()).closed(right.getEquals()).build();
    secondInterval = new IntervalBuilder().closed(left.getLess()).closed(left.getEquals()).build();
    assertFalse(firstInterval.intersects(secondInterval));
  }

  @Test
  public void givenTwoIntervalsCloseCloseWhenIntersectionThenTrue() {
    Interval firstInterval = new IntervalBuilder().closed(left.getEquals()).closed(left.getGreater()).build();
    Interval secondInterval = new IntervalBuilder().closed(left.getGreater()).closed(right.getGreater()).build();
    assertTrue(firstInterval.intersects(secondInterval));
    firstInterval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    secondInterval = new IntervalBuilder().closed(left.getGreater()).closed(right.getGreater()).build();
    assertTrue(firstInterval.intersects(secondInterval));
    firstInterval = new IntervalBuilder().closed(left.getEquals()).closed(right.getGreater()).build();
    secondInterval = new IntervalBuilder().closed(left.getLess()).closed(right.getEquals()).build();
    assertTrue(firstInterval.intersects(secondInterval));
    firstInterval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    secondInterval = new IntervalBuilder().closed(left.getLess()).closed(right.getLess()).build();
    assertTrue(firstInterval.intersects(secondInterval));
    firstInterval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
    secondInterval = new IntervalBuilder().closed(left.getLess()).closed(left.getEquals()).build();
    assertTrue(firstInterval.intersects(secondInterval));
  }

  @Test
  public void givenTwoIntervalsOpenOpenCloseCloseWhenIntersectionThenFalse() {
    Interval firstInterval = new IntervalBuilder().open(left.getEquals()).open(left.getGreater()).build();
    Interval secondInterval = new IntervalBuilder().closed(left.getGreater()).closed(right.getGreater()).build();
    assertFalse(firstInterval.intersects(secondInterval));
    secondInterval = new IntervalBuilder().closed(left.getLess()).closed(left.getEquals()).build();
    assertFalse(firstInterval.intersects(secondInterval));
  }

}