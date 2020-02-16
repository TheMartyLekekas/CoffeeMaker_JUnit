package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import junit.framework.TestCase;

public class RecipeTest extends TestCase {
    private Recipe rec1;
    private Recipe rec2;

    protected void setUp() throws Exception {
        rec1 = new Recipe();
        rec2 = new Recipe();
        super.setUp();
    }

    public void testSetChocolate() {
        try {
            rec1.setAmtChocolate("11");
            assertEquals(11, rec1.getAmtChocolate());
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown");
        }
    }
    public void testSetChocolateException() {
        try {
            rec2.setAmtChocolate("-1");
            fail("RecipeException should be thrown");
        } catch (RecipeException e) {
            //success if thrown
        }
    }


    public void testSetCoffee() {
        try {
            rec1.setAmtCoffee("000");
            assertEquals(0, rec1.getAmtCoffee());
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown");
        }
    }
    public void testSetCoffeeException() {
        try {
            rec2.setAmtCoffee("");
            fail("InventoryException should be thrown");
        } catch (RecipeException e) {
            //success if thrown
        }
    }


    public void testSetMilk() {
        try {
            rec1.setAmtMilk("13");
            assertEquals(13, rec1.getAmtMilk());
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown");
        }
    }
    public void testSetMilkException() {
        try {
            rec2.setAmtMilk(null);
            fail("InventoryException should be thrown");
        } catch (RecipeException e) {
            //success if thrown
        }
    }


    public void testSetSugar() {
        try {
            rec1.setAmtSugar("14");
            assertEquals(14, rec1.getAmtSugar());
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown");
        }
    }
    public void testSetSugarException() {
        try {
            rec2.setAmtSugar("k");
            fail("InventoryException should be thrown");
        } catch (RecipeException e) {
            //success if thrown
        }
    }


    public void testSetName() {
            rec1.setName("MockCoffee");
            assertEquals("MockCoffee", rec1.getName());
    }
    public void testSetNameNull() {
        try {
            rec2.setName(null);
            assertEquals("", rec2.getName());
        } catch (NullPointerException e) {
            fail("RecipeException should not be thrown");
        }
    }


    public void testSetPrice() {
        try{
            rec1.setPrice("0");
        } catch (RecipeException e) {
            fail("RecipeException should not be thrown");
        }
    }
    public void testSetNegativePriceException() {
        try{
            rec1.setPrice("-6");
            fail("RecipeException should be thrown");
        } catch (RecipeException e) {
            // success if thrown
        }
    }
    public void testSetInvalidPriceException() {
        try{
            rec1.setPrice("x");
            fail("RecipeException should be thrown");
        } catch (RecipeException e) {
            // success if thrown
        }
    }
    public void testSetNullPriceException() {
        try{
            rec1.setPrice(null);
            fail("RecipeException should be thrown");
        } catch (RecipeException e) {
            // success if thrown
        }
    }

    public void testRecipeToString() throws Exception {
        rec1.setName("Cof");
        rec1.setAmtChocolate("0");
        rec1.setAmtCoffee("1");
        rec1.setAmtMilk("2");
        rec1.setAmtSugar("3");
        rec1.setPrice("10");
        assertEquals("Recipe name: Cof\nPrice: 10\nChocolate: 0\nCoffee: 1\nMilk: 2\nSugar: 3\n", rec1.toString());
    }


    public void testHashCode() {
        assertEquals(31, rec1.hashCode());
    }

    public void testEquals() throws Exception {
        rec1.setName("Cof");
        rec1.setAmtChocolate("0");
        rec1.setAmtCoffee("1");
        rec1.setAmtMilk("2");
        rec1.setAmtSugar("3");
        rec1.setPrice("10");

        rec2.setName("Cof");
        rec2.setAmtChocolate("0");
        rec2.setAmtCoffee("1");
        rec2.setAmtMilk("2");
        rec2.setAmtSugar("3");
        rec2.setPrice("10");
        assertTrue("Recipes are identical", rec1.equals(rec1));
    }
}
