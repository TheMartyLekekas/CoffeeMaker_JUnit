package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import junit.framework.TestCase;

public class InventoryTest extends TestCase {
    private Inventory inv;
    private Recipe rec1;
    private Recipe rec2;

    protected void setUp() throws Exception {
        inv = new Inventory();

        inv.setChocolate(20);
        inv.setCoffee(20);
        inv.setMilk(20);
        inv.setSugar(20);

        rec1 = new Recipe();
        rec1.setName("TestCoffee");
        rec1.setAmtChocolate("6");
        rec1.setAmtCoffee("5");
        rec1.setAmtMilk("4");
        rec1.setAmtSugar("3");
        rec1.setPrice("50");

        rec2 = new Recipe();
        rec2.setName("TooMuchCoffee");
        rec2.setAmtChocolate("1");
        rec2.setAmtCoffee("33");
        rec2.setAmtMilk("1");
        rec2.setAmtSugar("1");
        rec2.setPrice("50");

        super.setUp();
    }


    public void testAddChocolate() {
        try {
            inv.addChocolate("11");
            assertEquals(31, inv.getChocolate());
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
    }
    public void testAddChocolateException() {
        try {
            inv.addChocolate("-1");
            fail("InventoryException should be thrown");
        } catch (InventoryException e) {
            //success if thrown
        }
    }


    public void testAddCoffee() {
        try {
            inv.addCoffee("0");
            assertEquals(20, inv.getCoffee());
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
    }
    public void testAddCoffeeException() {
        try {
            inv.addCoffee("x");
            fail("InventoryException should be thrown");
        } catch (InventoryException e) {
            //success if thrown
        }
    }


    public void testAddMilk() {
        try {
            inv.addMilk("5");
            assertEquals(25, inv.getMilk());
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
    }
    public void testAddMilkException() {
        try {
            inv.addMilk("");
            fail("InventoryException should be thrown");
        } catch (InventoryException e) {
            //success if thrown
        }
    }


    public void testAddSugar() {
        try{
            inv.addSugar("5");
            assertEquals(25, inv.getSugar());
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
    }
    public void testAddSugarException() {
        try {
            inv.addSugar(null);
            fail("InventoryException should be thrown");
        } catch (InventoryException e) {
            //success if thrown
        }
    }

    public void testEnoughIngredients() {
            assertTrue(inv.enoughIngredients(rec1));
    }
    public void testUseIngredients() {
        inv.useIngredients(rec1);
        assertEquals(14, inv.getChocolate());
        assertEquals(15, inv.getCoffee());
        assertEquals(16, inv.getMilk());
        assertEquals(17, inv.getSugar());
    }

    public void testUseIngredientsFail() {
        assertFalse(inv.useIngredients(rec2));
    }

    public void testInventoryToString() {
        assertEquals("Chocolate: 20\nCoffee: 20\nMilk: 20\nSugar: 20\n", inv.toString());
    }
}
