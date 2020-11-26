package usantatecla;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MaxTest {
   
  @Test
  public void givenMaxOpenedwhenGreaterWithLessValueThenTrue(){
    assertTrue(new Max(4, true).greaterOrEquals(0.0));
  }

  @Test
  public void givenMaxOpenedwhenGreaterWithGreaterValueThenFalse(){
    assertFalse(new Max(4, true).greaterOrEquals(5.0));
  }

  @Test
  public void givenMaxOpenedwhenGreaterWithEqualValueThenFalse(){
    assertFalse(new Max(4, true).greaterOrEquals(4));
  }
 
}