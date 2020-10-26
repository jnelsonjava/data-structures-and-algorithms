package challenges;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class RepeatedWordTest {
    @Test
    public void testSimpleString() {
        String str = "cat dog snake apples dog snake";
        assertEquals("dog is the first repeated word", "dog", RepeatedWord.findFirstRepeatWord(str));
    }

    @Test
    public void testStringWithPunctuation() {
        String str = "Once upon a time, there was a brave princess who...";
        assertEquals("a is the first repeated word", "a", RepeatedWord.findFirstRepeatWord(str));
    }

    @Test
    public void testPunctuationCollision() {
        String str = "It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York...";
        assertEquals("summer should return as duplicate despite punctuation",
                "summer",
                RepeatedWord.findFirstRepeatWord(str));
    }

    @Test
    public void testCapitalization() {
        String str = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only...";
        assertEquals("it should be the first repeated word despite capitalization", "it", RepeatedWord.findFirstRepeatWord(str));
    }

    @Test
    public void testNoDuplicates() {
        String str = "dog cat apples";
        assertThrows("no duplicate words should result in an exception",
                NoSuchElementException.class,
                () -> RepeatedWord.findFirstRepeatWord(str));
    }
}
