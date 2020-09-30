package utilities;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalShelterTest {
    @Test public void testNewAnimalShelter() {
        AnimalShelter animalShelter = new AnimalShelter();
        assertNotNull("animal shelter should be instantiated", animalShelter);
        assertNull("fields should start empty", animalShelter.front);
        assertNull("fields should start empty", animalShelter.back);
    }

    @Test public void testEnqueue() {
        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(new Dog("Buster"));
        assertEquals("new dog should be in front",
                "{Buster dog} -> NULL",
                animalShelter.toString());

        animalShelter.enqueue(new Cat("Fritzi"));
        assertEquals("new cat should be in back",
                "{Buster dog} -> {Fritzi cat} -> NULL",
                animalShelter.toString());

        animalShelter.enqueue(new Dog("Bonko"));
        assertEquals("new dog should be in back",
                "{Buster dog} -> {Fritzi cat} -> {Bonko dog} -> NULL",
                animalShelter.toString());

        animalShelter.enqueue(new Cat("Bilibili"));
        assertEquals("new cat should be in back",
                "{Buster dog} -> {Fritzi cat} -> {Bonko dog} -> {Bilibili cat} -> NULL",
                animalShelter.toString());
    }

    @Test public void testDequeue() {
        AnimalShelter animalShelter = new AnimalShelter();
        assertNull("returns null when empty", animalShelter.dequeue("dog"));
        Dog buster = new Dog("Buster");
        animalShelter.enqueue(buster);
        assertNull("should return null for cat", animalShelter.dequeue("cat"));
        assertEquals("should return the dog", buster, animalShelter.dequeue("dog"));
        assertEquals("should be empty", "NULL", animalShelter.toString());

        Cat fritzi = new Cat("Fritzi");
        animalShelter.enqueue(buster);
        animalShelter.enqueue(fritzi);
        assertEquals("should skip dog and return cat", fritzi, animalShelter.dequeue("cat"));
        assertEquals("dog should still be in queue", "{Buster dog} -> NULL", animalShelter.toString());
        assertEquals("should return last dog", buster, animalShelter.dequeue("dog"));

        Dog bonko = new Dog("Bonko");
        Dog bilibili = new Dog("Bilibili");
        animalShelter.enqueue(buster);
        animalShelter.enqueue(fritzi);
        animalShelter.enqueue(bilibili);
        animalShelter.enqueue(bonko);
        assertEquals("first cat", fritzi, animalShelter.dequeue("cat"));
        assertEquals("first dog", buster, animalShelter.dequeue("dog"));
        assertNull("no cats", animalShelter.dequeue("cat"));
        assertEquals("second dog", bilibili, animalShelter.dequeue("dog"));
        assertNull("preference given not cat or dog", animalShelter.dequeue("bob"));
        assertEquals("third dog", bonko, animalShelter.dequeue("dog"));
    }
}
