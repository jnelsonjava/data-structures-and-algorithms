package utilities;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MultiBracketValidationTest {
    @Test public void testMultiBracketValidation() {
        assertTrue("should return true when all brackets formatted well", MultiBracketValidation.multiBracketValidation("{[()]()}{}[]"));
        assertFalse("should return false when brackets out of order", MultiBracketValidation.multiBracketValidation("{[}]"));
        assertFalse("should return false when bracket never closed", MultiBracketValidation.multiBracketValidation("({[]}"));
        assertTrue("should return true when bracket format is good with extra letters", MultiBracketValidation.multiBracketValidation("{sdf[sdfd]fsdfs}"));
        assertFalse("should return false when bracket format bad with extra letters", MultiBracketValidation.multiBracketValidation("{sdf[sdfd]fsdfs"));
        assertTrue("should return true when string is empty", MultiBracketValidation.multiBracketValidation(""));
    }

}
