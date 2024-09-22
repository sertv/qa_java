import com.example.Feline;
import com.example.Cat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void checkSoundTest() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }
    @Test
    public void checkFoodTest() throws Exception {
        Cat catt = new Cat(feline);
        catt.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}