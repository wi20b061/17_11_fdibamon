import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class FdibamonTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void test_fdibamon_is_created_with_null_name(){
        exception.expect(InvalidParameterException.class);
        Fdibamon fdibamon = new Fdibamon(null, 10, 20);
    }

    @Test
    public void test_fdibamon_is_created_with_invaild_name(){
        exception.expect(InvalidParameterException.class);
        Fdibamon fdibamon = new Fdibamon("", 10, 20);
    }

    @Test
    public void test_fdibamon_is_created_with_negative_hitpoints(){
        exception.expect(InvalidParameterException.class);
        Fdibamon fdibamon = new Fdibamon("Hans", -10, 20);
    }

    @Test
    public void test_fdibamon_is_created_with_negative_attackpoints(){
        exception.expect(InvalidParameterException.class);
        Fdibamon fdibamon = new Fdibamon("Hans", 10, -20);
    }

    @Test
    public void test_get_name_function_works_properly() {
        //Arrange
        Fdibamon fdibamon = new Fdibamon("Hans", 10, 20);
        //Act
        String name = fdibamon.getName();
        //Assert
        assertEquals("Hans", fdibamon.getName());
    }

    @Test
    public void test_get_hitpoints_function_works_properly(){
        //Arrange
        Fdibamon fdibamon = new Fdibamon("Hans", 10, 20);
        //Act
        int hitpoints = fdibamon.getHitPoints();
        //Assert
        assertEquals(10, hitpoints);
    }
    @Test
    public void test_get_attackpower_function_works_properly(){
        //Arrange
        Fdibamon fdibamon = new Fdibamon("Hans", 10, 20);
        //Act
        int attackpower = fdibamon.getAttackPower();
        //Assert
        assertEquals(20, attackpower);
    }

}