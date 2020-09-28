import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ApplicationTest {
    List<String> wordsToTest;
    private Application application;

    @BeforeEach
    void setUp() {
        application = new Application();

        wordsToTest = Arrays.asList("one", "twothree", "four", "fivee", "sixsix", "sevensevenseven", "ni", "i");
    }

    @Test
    void application_sortingAscending() {
        List<String> expectedResults = Arrays.asList("i", "ni", "one", "four", "fivee", "sixsix");
        List<String> resultOne = application.sortingAndFiltering("asc", wordsToTest, 1, 6);

        Assertions.assertEquals(expectedResults, resultOne);


    }

    @Test
    void application_sortingDescending() {
        List<String> expectedResults = Arrays.asList("sixsix", "fivee", "four", "one", "ni", "i");
        List<String> resultOne = application.sortingAndFiltering("desc", wordsToTest, 1, 6);

        Assertions.assertEquals(expectedResults, resultOne);


    }

    @Test
    void application_sortingAscendingWithNoRequiredMinLength() {
        List<String> expectedResults = Arrays.asList("i", "ni", "one", "four");
        List<String> resultOne = application.sortingAndFiltering("asc", wordsToTest, 0, 4);

        Assertions.assertEquals(expectedResults, resultOne);


    }

    @Test
    void application_sortingAscendingWithNoRequiredMaxLength() {
        List<String> expectedResults = Arrays.asList("ni", "one", "four", "fivee", "sixsix", "twothree", "sevensevenseven");
        List<String> resultOne = application.sortingAndFiltering("asc", wordsToTest, 2, 0);

        Assertions.assertEquals(expectedResults, resultOne);


    }

    @Test
    void application_sortingAscendingWithNoRequiredLength() {
        List<String> expectedResults = Arrays.asList("i", "ni", "one", "four", "fivee", "sixsix", "twothree", "sevensevenseven");
        List<String> resultOne = application.sortingAndFiltering("asc", wordsToTest, 0, 0);

        Assertions.assertEquals(expectedResults, resultOne);


    }

    @Test
    void application_sortingDescendingWithNoRequiredMinLength() {
        List<String> expectedResults = Arrays.asList("four", "one", "ni", "i");
        List<String> resultOne = application.sortingAndFiltering("desc", wordsToTest, 0, 4);

        Assertions.assertEquals(expectedResults, resultOne);


    }

    @Test
    void application_sortingDescendingWithNoRequiredMaxLength() {
        List<String> expectedResults = Arrays.asList("sevensevenseven", "twothree", "sixsix", "fivee", "four", "one", "ni");
        List<String> resultOne = application.sortingAndFiltering("desc", wordsToTest, 2, 0);

        Assertions.assertEquals(expectedResults, resultOne);


    }

    @Test
    void application_sortingDescendingWithNoRequiredLength() {
        List<String> expectedResults = Arrays.asList("sevensevenseven", "twothree", "sixsix", "fivee", "four", "one", "ni", "i");
        List<String> resultOne = application.sortingAndFiltering("desc", wordsToTest, 0, 0);

        Assertions.assertEquals(expectedResults, resultOne);


    }

    @Test
    void application_sortingInvalidInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> application.sortingAndFiltering("sorting", wordsToTest, 0, 0), "Illegal argument,type asc or desc");


    }


}
