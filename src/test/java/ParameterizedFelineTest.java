import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedFelineTest {

    public int kittenCount;
    public int expectedKittenCount;

    public ParameterizedFelineTest(int kittenCount, int expectedKittenCount) {
        this.kittenCount = kittenCount;
        this.expectedKittenCount = expectedKittenCount;

    }

    @Parameterized.Parameters
    public static Object[][] countKitten() {
        return new Object[][]{
                {1, 1},
                {10, 10},
                {0, 0},
                {5, 5},
        };
    }

    @Test
    public void checkKittenCountTest() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens(kittenCount);
        Assert.assertEquals(expectedKittenCount, actualKittens);
    }
}
