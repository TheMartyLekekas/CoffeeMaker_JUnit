package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;

public class RecipeBookTest extends TestCase {

    private RecipeBook book;
    private Recipe br;
    private Recipe r;
    private Recipe newr;

    protected void setUp() throws Exception{
        book = new RecipeBook();
        br = new Recipe();
            br.setName("Mockito");
            br.setAmtChocolate("2");
            br.setAmtCoffee("2");
            br.setAmtMilk("2");
            br.setAmtSugar("2");
            br.setPrice("10");

        r = new Recipe();
            r.setName("Latte");
            r.setAmtChocolate("0");
            r.setAmtCoffee("3");
            r.setAmtMilk("3");
            r.setAmtSugar("1");
            r.setPrice("100");

        newr = new Recipe();
            newr.setName("NewCoffee");
            newr.setAmtChocolate("3");
            newr.setAmtCoffee("3");
            newr.setAmtMilk("3");
            newr.setAmtSugar("3");
            newr.setPrice("30");

        book.addRecipe(br);

        super.setUp();
    }

    public void testAddRecipe() {
        assertTrue("Successfully added new recipe to the book", book.addRecipe(r));
    }

    public void testDeleteRecipe() {
        assertEquals("Mockito", book.deleteRecipe(0));
    }
    public void testDeleteInExistentRecipe() {
        assertEquals(null, book.deleteRecipe(3));
    }

    public void testEditRecipe() {
        assertEquals("Mockito", book.editRecipe(0, newr));
    }
}
