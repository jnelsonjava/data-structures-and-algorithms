package Practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringifyNumberTest {
    @Test
    public void testZero() {
        assertEquals("Base case should return zero", "zero", StringifyNumber.numberAsSpoken(0));
    }

    @Test
    public void testSingleDigits() {
        assertEquals("one", StringifyNumber.numberAsSpoken(1));
        assertEquals("two", StringifyNumber.numberAsSpoken(2));
        assertEquals("three", StringifyNumber.numberAsSpoken(3));
        assertEquals("four", StringifyNumber.numberAsSpoken(4));
        assertEquals("five", StringifyNumber.numberAsSpoken(5));
        assertEquals("six", StringifyNumber.numberAsSpoken(6));
        assertEquals("seven", StringifyNumber.numberAsSpoken(7));
        assertEquals("eight", StringifyNumber.numberAsSpoken(8));
        assertEquals("nine", StringifyNumber.numberAsSpoken(9));
    }

    @Test
    public void testTeens() {
        assertEquals("eleven", StringifyNumber.numberAsSpoken(11));
        assertEquals("twelve", StringifyNumber.numberAsSpoken(12));
        assertEquals("thirteen", StringifyNumber.numberAsSpoken(13));
        assertEquals("fourteen", StringifyNumber.numberAsSpoken(14));
        assertEquals("fifteen", StringifyNumber.numberAsSpoken(15));
        assertEquals("sixteen", StringifyNumber.numberAsSpoken(16));
        assertEquals("seventeen", StringifyNumber.numberAsSpoken(17));
        assertEquals("eighteen", StringifyNumber.numberAsSpoken(18));
        assertEquals("nineteen", StringifyNumber.numberAsSpoken(19));
    }

    @Test
    public void testDoubleDigits() {
        assertEquals("twenty", StringifyNumber.numberAsSpoken(20));
        assertEquals("twenty one", StringifyNumber.numberAsSpoken(21));
        assertEquals("thirty three", StringifyNumber.numberAsSpoken(33));
        assertEquals("forty eight", StringifyNumber.numberAsSpoken(48));
        assertEquals("fifty six", StringifyNumber.numberAsSpoken(56));
        assertEquals("sixty four", StringifyNumber.numberAsSpoken(64));
        assertEquals("seventy nine", StringifyNumber.numberAsSpoken(79));
        assertEquals("eighty seven", StringifyNumber.numberAsSpoken(87));
        assertEquals("ninety two", StringifyNumber.numberAsSpoken(92));
    }

    @Test
    public void testTripleDigits() {
        assertEquals("one hundred", StringifyNumber.numberAsSpoken(100));
        assertEquals("two hundred", StringifyNumber.numberAsSpoken(200));
        assertEquals("two hundred ten", StringifyNumber.numberAsSpoken(210));
        assertEquals("two hundred thirteen", StringifyNumber.numberAsSpoken(213));
        assertEquals("two hundred fifty six", StringifyNumber.numberAsSpoken(256));
        assertEquals("three hundred sixty four", StringifyNumber.numberAsSpoken(364));
        assertEquals("five hundred seventy nine", StringifyNumber.numberAsSpoken(579));
        assertEquals("nine hundred eighty seven", StringifyNumber.numberAsSpoken(987));
        assertEquals("eight hundred ninety two", StringifyNumber.numberAsSpoken(892));
    }

    @Test
    public void testAboveThreeDigits() {
        assertEquals("one thousand", StringifyNumber.numberAsSpoken(1000));
        assertEquals("twenty one thousand three hundred twenty five", StringifyNumber.numberAsSpoken(21325));
        assertEquals("one million", StringifyNumber.numberAsSpoken(1000000));
        assertEquals("one billion", StringifyNumber.numberAsSpoken(1000000000));
        assertEquals("two thousand two hundred", StringifyNumber.numberAsSpoken(2200));
        assertEquals("one billion fifty six", StringifyNumber.numberAsSpoken(1000000056));
        assertEquals("two billion forty two million six hundred seventy eight thousand one", StringifyNumber.numberAsSpoken(2042678001));
        assertEquals("two billion one hundred forty seven million four hundred eighty three thousand six hundred forty seven", StringifyNumber.numberAsSpoken(2147483647));
    }
}
