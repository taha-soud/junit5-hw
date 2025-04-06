package main.najah.test;

import main.najah.test.CalculatorTest;
import main.najah.test.ProductTest;
import main.najah.test.RecipeBookTest;
import main.najah.test.UserServiceTest;
import org.junit.jupiter.api.Test;
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
    // Empty on purpose
}
