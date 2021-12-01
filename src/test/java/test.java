import com.example.javafxassignment3.RegistrationFormApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class test {
    private RegistrationFormApplication register;

    @BeforeEach
    public void setUp() {
        register = new RegistrationFormApplication();
        Assertions.assertNotNull(register);
    }

    @Test
    public void test1() {

    }
}