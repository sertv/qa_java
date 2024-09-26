import com.example.Feline;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

public class FelineTest {

    @Test
    public void checkKittensCountTest() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        Assert.assertEquals(1, actualKittens);
    }
    @Test
    public void checkFamilyTest() {
        Feline feline = new Feline();
        String felineFamily = feline.getFamily();
        Assert.assertEquals("Кошачьи", felineFamily);
    }
    @Test
    public void checkEatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> felineEatMeat = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), felineEatMeat);
    }
}
