package main.najah.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CalculatorTest.class,
        ProductTest.class,
        UserServiceTest.class,
        RecipeBookTest.class
})
public class AllTestsSuite {
    // This class remains empty.
    // It is used only as a holder for the above annotations.
}
