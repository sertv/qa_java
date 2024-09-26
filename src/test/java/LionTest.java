import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    // Тестирование конструктора
    @Test
    public void testLionConstructorWithMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());  // Убедимся, что у самца есть грива
    }

    @Test
    public void testLionConstructorWithFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane()); // Убедимся, что у самки нет гривы
    }

    @Test(expected = Exception.class)
    public void testLionConstructorWithInvalidSex() throws Exception {
        // Проверка выброса исключения при неправильном поле
        new Lion("НеправильныйПол", feline);
    }

    // Тестирование метода getKittens()
    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);

        // Настроим мок, чтобы возвращал 3 котёнка
        when(feline.getKittens()).thenReturn(3);

        int kittensCount = lion.getKittens();
        assertEquals(3, kittensCount);  // Проверяем, что метод возвращает правильное количество
        verify(feline, times(1)).getKittens(); // Проверяем, что метод getKittens был вызван ровно один раз
    }

    // Тестирование метода getFood()
    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);

        // Настроим мок для метода getFood
        List<String> foodList = Arrays.asList("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(foodList);

        List<String> food = lion.getFood();
        assertEquals(foodList, food);  // Проверяем, что метод возвращает корректные данные
        verify(feline, times(1)).getFood("Хищник"); // Проверяем, что метод getFood был вызван один раз с правильным аргументом
    }

    // Тестирование метода doesHaveMane()
    @Test
    public void testDoesHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());  // У самца должна быть грива
    }

    @Test
    public void testDoesHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane()); // У самки не должно быть гривы
    }
}