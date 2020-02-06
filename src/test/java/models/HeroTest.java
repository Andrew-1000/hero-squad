package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeroTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void NewHeroObjectGetsCreatedCorrectly_true() {
        Hero hero = setupNewHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void HeroInstatiatesWithName_true() {
        Hero hero = setupNewHero();
        assertEquals("Spiderman", hero.getName());
    }

    private Hero setupNewHero() {
        return new Hero("Spiderman", 12, "Genius-level intellect", "death");
    }
}
