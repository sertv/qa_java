import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {

    String sex;
    boolean expectedMane;

    public  ParameterizedLionTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Object[][] eMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    Feline feline = Mockito.mock(Feline.class);

    @Test
    public void checkManeTest() throws Exception {

        Lion lion = new Lion(sex, feline);
        boolean doesHaveMane = lion.doesHaveMane();
        Assert.assertEquals(expectedMane, doesHaveMane);

    }
}