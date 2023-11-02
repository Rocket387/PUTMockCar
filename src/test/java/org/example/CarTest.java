package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class CarTest

{
    @Mock
    private Car myFerrari;
    //private Car myFerrari = mock(Car.class); is the same as the above

   @Test
    public void testIfCarIsCar() {

       assertTrue(myFerrari instanceof Car);
   }

   @Test
   public void testBehaviourOfGetEngineTemp() {
       assertFalse("should be false as method is a boolean", myFerrari.needsFuel());
       assertEquals(0.0, 0.0, myFerrari.getEngineTemp());
   }

   @Test
   public void testFuelStubbing() {
       when(myFerrari.needsFuel()).thenReturn(true);
       assertTrue("above stubbing has changed the fuel requirement", myFerrari.needsFuel());
   }

   @Test(expected = RuntimeException.class)
    public void throwException() {
       when(myFerrari.needsFuel()).thenThrow(new RuntimeException());
       myFerrari.needsFuel();
   }

   @Test
   public void testVerify() {
       myFerrari.driveTo("neverland");
       myFerrari.needsFuel();

       verify(myFerrari).driveTo("neverland");
       verify(myFerrari).needsFuel();
   }

    @Test
    public void testVerifyFailure() {

        myFerrari.getEngineTemp();
        verify(myFerrari).getEngineTemp();

    }
}
