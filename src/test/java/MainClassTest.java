import org.junit.*;

public class MainClassTest {

    // Порядок прохождения теста: beforeClassMethod - setUp - method1 - tearDown - setUp - method13 - tearDown - afterClassMethod

    @BeforeClass //анотация выполняется первой
    public void beforeClassMethod(){

    }

    @Before //запускается перед каждым тестовым методом
    public void setUp(){

    }

    @Test //Главноая анотация которая вказывает на тестовые методы
    public void metod1(){

    }

    @Test //Главноая анотация которая вказывает на тестовые методы
    @Ignore //Данный тест не будет запускаться
    public void metod2(){

    }

    @Test //Главноая анотация которая вказывает на тестовые методы
    public void metod3(){

    }

    @After //Выполняется после каждого тестового метода
    public void tearDown(){

    }

    @AfterClass //выполняется после выполнения всех методо/тестов
    public void afterClassMetod(){

    }
}
