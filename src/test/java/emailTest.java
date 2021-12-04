import com.example.javafxassignment3.emailValidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class emailTest {

    private emailValidate belowTest;

    @BeforeEach
    public void setUp() {

        belowTest = new emailValidate();

    }

    @Test
    void toValidateEmail(){

        String emailFormat = "123genrericEmail@gmail.com";
        boolean isEmailCorrect = belowTest.test(emailFormat);
        Assertions.assertTrue(isEmailCorrect);
    }

}
