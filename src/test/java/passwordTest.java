import com.example.javafxassignment3.passwordValidate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class passwordTest {

    private passwordValidate belowTest;

    @BeforeEach
    public void setUp() {

        belowTest = new passwordValidate();

    }

    @Test
    void toValidatePassword(){

        String emailFormat = "badpassword!";
        boolean isEmailCorrect = belowTest.test(emailFormat);
        Assertions.assertTrue(isEmailCorrect);
    }

}
