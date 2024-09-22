import com.example.Lion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    Feline feline;

    @Test(expected = Exception.class)
    public void checkManeExceptionTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        //lion.doesHaveMane();
        Assert.assertEquals(true, lion.doesHaveMane());
    }
    @Test(expected = Exception.class)
    public void checkKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
    @Test(expected = Exception.class)
    public void checkFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");

    }
}
