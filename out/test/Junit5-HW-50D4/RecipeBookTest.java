package main.najah.test;

import main.najah.code.Recipe;
import main.najah.code.RecipeBook;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RecipeBook Tests")
public class RecipeBookTest {

    RecipeBook recipeBook;
    Recipe recipe;

    @BeforeEach
    void setUp() {
        recipeBook = new RecipeBook();
        recipe = new Recipe();
        recipe.setName("Espresso");
    }

    @Test
    @DisplayName("Add a new recipe successfully")
    void testAddRecipe() {
        boolean added = recipeBook.addRecipe(recipe);
        assertTrue(added);
    }

    @Test
    @DisplayName("Add the same recipe twice should fail")
    void testAddDuplicateRecipe() {
        assertTrue(recipeBook.addRecipe(recipe));
        assertFalse(recipeBook.addRecipe(recipe));
    }

    @Test
    @DisplayName("Delete existing recipe should return its name")
    void testDeleteExistingRecipe() {
        recipeBook.addRecipe(recipe);
        String deletedName = recipeBook.deleteRecipe(0);
        assertEquals("Espresso", deletedName);
    }

    @Test
    @DisplayName("Delete nonexistent recipe should return null")
    void testDeleteNullRecipe() {
        assertNull(recipeBook.deleteRecipe(1));
    }

    @Test
    @DisplayName("Edit an existing recipe")
    void testEditRecipe() {
        recipeBook.addRecipe(recipe);

        Recipe newRecipe = new Recipe();
        newRecipe.setName("Latte");

        String oldName = recipeBook.editRecipe(0, newRecipe);
        assertEquals("Espresso", oldName);
    }

    @Test
    @DisplayName("Edit nonexistent recipe should return null")
    void testEditNonexistentRecipe() {
        Recipe another = new Recipe();
        another.setName("Mocha");
        assertNull(recipeBook.editRecipe(2, another));
    }

    @Test
    @DisplayName("Timeout test for getting recipes")
    @Timeout(1)
    void testGetRecipesTimeout() {
        assertNotNull(recipeBook.getRecipes());
    }

    @Test
    @DisplayName("Test multiple assertions for recipe array state")
    void testRecipeArrayAssertions() {
        recipeBook.addRecipe(recipe);
        Recipe[] recipes = recipeBook.getRecipes();

        assertAll(
                () -> assertNotNull(recipes),
                () -> assertEquals(4, recipes.length),
                () -> assertEquals("Espresso", recipes[0].getName())
        );
    }
}
