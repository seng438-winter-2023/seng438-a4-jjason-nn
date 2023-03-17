package org.jfree.data;

import org.junit.*;

import static org.junit.Assert.*;

import org.jfree.chart.util.ParamChecks;

/**
 * this suite of tests is used for the methods in the Range class
 */
public class RangeTest {
    /**
     * a default range of -1 to +1
     */
    private Range defaultRange;
    /**
     * a range that has a negative lower bound and positive upper bound
     */
    private Range mixedRange;
    /**
     * a range that has 0 as its lower and upper bound
     */
    private Range zeroRange;
    /**
     * a range that has positive integers as its bounds
     */
    private Range positiveRange;
    /**
     * a range that has negative integers as its bounds
     */
    private Range negativeRange;
    /**
     * a range that has negative decimals as its bounds
     */
    private Range negativeDecimalRange;
    /**
     * a range that has positive decimals as its bounds
     */
    private Range positiveDecimalRange;

    /**
     * a range that has a NaN lower bound and a positive upper bound
     */
    private Range lowerNaNRange;

    /**
     * a range that has a negative lower bound and a NaN upper bound
     */
    private Range upperNaNRange;

    /**
     * a range that has a NaN lower bound and a NaN upper bound
     */
    private Range NaNRange;
    private Range upperZeroLowerNegativeRange;
    private Range badRange;


    /**
     * setup for the entire suite
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * tear down for the entire suite
     *
     * @throws Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }



    /**
     * this tests and validates that the range is bad
     */
    @Test
    public void rangeCreateWithBadRange() {
        try {
        	new Range(2, -5);
        } catch (IllegalArgumentException e) {
        	assertEquals("Incorrect message for bad ranges", "Range(double, double): require lower (2.0) <= upper (-5.0).", e.getMessage());
        }
    }
    
    
    /**
     * setup for the "contains" method tests
     *
     * @throws Exception
     */
    @Before
    public void setUpContains() throws Exception {
        defaultRange = new Range(-1, 1);
    }

    /**
     * this tests and validates that the lower bound is included in the range
     */
    @Test
    public void containsLowerBoundSpecifiedValue() {
        assertTrue("The specified value of -1, which is the lower bound, should be contained in the range", defaultRange.contains(-1));
    }

    /**
     * this tests and validates that the upper bound is included in the range
     */
    @Test
    public void containsUpperBoundSpecifiedValue() {
        assertTrue("The specified value of 1, which is the upper bound, should be contained in the range", defaultRange.contains(1));
    }

    /**
     * this tests and validates that a positive value is contained in the range
     * as long as within the range's bounds
     */
    @Test
    public void containsPositiveSpecifiedValueInBetweenRange() {
        assertTrue("The specified value of 0.5 should be contained in the range", defaultRange.contains(0.5));
    }

    /**
     * this tests and validates that a negative value is contained in the range
     * as long as within the range's bounds
     */
    @Test
    public void containsNegativeSpecifiedValueInBetweenRange() {
        assertTrue("The specified value of -0.5 should be contained in the range", defaultRange.contains(-0.5));
    }

    /**
     * this tests and validates that a value is not contained in the range
     * if it is greater than the upper bound
     */
    @Test
    public void doesNotContainSpecificValueGreaterThanUpperBound() {
        assertFalse("The specified value of 1.1, which is greater than the upper bound of 1, should not be contained in the range", defaultRange.contains(1.1));
    }

    /**
     * this tests and validates that a value is not contained in the range
     * if it is less than the lower bound
     */
    @Test
    public void doesNotContainSpecificValueLessThanLowerBound() {
        assertFalse("The specified value of -1.1, which is less than the lower bound of -1, should not be contained in the range", defaultRange.contains(-1.1));
    }

    /**
     * tear down for the "contains" method tests
     *
     * @throws Exception
     */
    @After
    public void tearDownContains() throws Exception {
        defaultRange = null;
    }

    /**
     * setup for the "setUpGetLowerBound" method tests
     *
     * @throws Exception
     */
    @Before
    public void setUpGetLowerBound() throws Exception {
        mixedRange = new Range(-1, 1);
        zeroRange = new Range(0, 0);
        positiveRange = new Range(1, 2);
        negativeRange = new Range(-2, -1);
        negativeDecimalRange = new Range(-2.5, -1.5);
        positiveDecimalRange = new Range(3.5, 6.6);
    }

    /**
     * this tests and validates that the correct lower bound is returned of a positive range
     */
    @Test
    public void getLowerBoundOfPositiveRange() {
        assertEquals("The lower bound of 1 should be returned.", 1.0, positiveRange.getLowerBound(), 0);
    }

    /**
     * this tests and validates that the correct lower bound is returned of a negative range
     */
    @Test
    public void getLowerBoundOfNegativeRange() {
        assertEquals("The lower bound of -2 should be returned.", -2.0, negativeRange.getLowerBound(), 0);
    }

    /**
     * this tests and validates that the correct lower bound is returned of a mixed range
     */
    @Test
    public void getLowerBoundOfMixedRange() {
        assertEquals("The lower bound of -1 should be returned.", -1.0, mixedRange.getLowerBound(), 0);
    }

    /**
     * this tests and validates that the lower bound of 0 is returned of a (0, 0) range
     */
    @Test
    public void getLowerBoundOfZero() {
        assertEquals("The lower bound of 0 should be returned.", 0, zeroRange.getLowerBound(), 0);
    }

    /**
     * this tests and validates that the correct lower bound is returned of a negative decimal range
     */
    @Test
    public void getLowerBoundOfNegativeDecimalRange() {
        assertEquals("The lower bound of -2.5 should be returned.", -2.5, negativeDecimalRange.getLowerBound(), 0);
    }

    /**
     * this tests and validates that the correct lower bound is returned of a positive decimal range
     */
    @Test
    public void getLowerBoundOfPositiveDecimalRange() {
        assertEquals("The lower bound of 3.5 should be returned.", 3.5, positiveDecimalRange.getLowerBound(), 0);
    }

    /**
     * tear down for the "getLowerBound" method tests
     *
     * @throws Exception
     */
    @After
    public void tearDownGetLowerBound() throws Exception {
        mixedRange = null;
        zeroRange = null;
        positiveRange = null;
        negativeRange = null;
        negativeDecimalRange = null;
        positiveDecimalRange = null;
    }

    /**
     * setup for the "getUpperBound" method tests
     *
     * @throws Exception
     */
    @Before
    public void setUpGetUpperBound() throws Exception {
        mixedRange = new Range(-1, 1);
        zeroRange = new Range(0, 0);
        positiveRange = new Range(1, 2);
        negativeRange = new Range(-2, -1);
        negativeDecimalRange = new Range(-2.5, -1.5);
        positiveDecimalRange = new Range(3.5, 6.6);
    }

    /**
     * this tests and validates that the correct upper bound is returned of a positive range
     */
    @Test
    public void getUpperBoundOfPositiveRange() {
        double ote = positiveRange.getUpperBound();
        System.out.print(ote);

        assertEquals("The upper bound of 2.0 should be returned.", 2.0, positiveRange.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct upper bound is returned of a negative range
     */
    @Test
    public void getUpperBoundOfNegativeRange() {
        assertEquals("The upper bound of -1.0 should be returned.", -1.0, negativeRange.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct upper bound is returned of a mixed range
     */
    @Test
    public void getUpperBoundOfMixedRange() {
        assertEquals("The upper bound of 1 should be returned.", 1.0, mixedRange.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the upper bound of 0 is returned of a (0, 0) range
     */
    @Test
    public void getUpperBoundOfZero() {
        assertEquals("The upper bound of 0 should be returned.", 0, zeroRange.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct upper bound is returned of a negative decimal range
     */
    @Test
    public void getUpperBoundOfNegativeDecimalRange() {
        assertEquals("The upper bound of -1.5 should be returned.", -1.5, negativeDecimalRange.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct upper bound is returned of a positive decimal range
     */
    @Test
    public void getUpperBoundOfPositiveDecimalRange() {
        assertEquals("The upper bound of 6.6 should be returned.", 6.6, positiveDecimalRange.getUpperBound(), 0);
    }

    /**
     * tear down for the "getUpperBound" method tests
     *
     * @throws Exception
     */
    @After
    public void tearDownGetUpperBound() throws Exception {
        mixedRange = null;
        zeroRange = null;
        positiveRange = null;
        negativeRange = null;
        negativeDecimalRange = null;
        positiveDecimalRange = null;
    }

    /**
     * setup for the "getLength" method tests
     *
     * @throws Exception
     */
    @Before
    public void setUpGetLength() throws Exception {
        mixedRange = new Range(-1, 1);
        zeroRange = new Range(0, 0);
        negativeDecimalRange = new Range(-2.5, -1.5);
        positiveDecimalRange = new Range(3.5, 6.6);
        upperZeroLowerNegativeRange = new Range(-10, 0);
    }
    
    @Test
    public void getLengthOfUpperZeroLowerNegative() {
    	double expectedLength = upperZeroLowerNegativeRange.getUpperBound() - upperZeroLowerNegativeRange.getLowerBound();

        assertEquals("The length of 10.0 should be returned", expectedLength, upperZeroLowerNegativeRange.getLength(), 0);
    }
    
    @Test
    public void getLengthOfPredefined() {
    	int lower = 10;
    	int upper = 20;
    	Range newRange = new Range(lower, upper);
    	double length = newRange.getLength();
    	double expectedLength = newRange.getUpperBound() - newRange.getLowerBound();
    	assertEquals("The length of 10.0 should be returned", expectedLength, length, 0);
    }

    /**
     * this tests and validates that the correct length is returned of a range with two positive bounds
     */
//    @Test
//    public void getLengthOfTwoPositiveBounds() {
//        assertEquals("The length of 3.1 should be returned", 3.1, negativeDecimalRange.getLength(), 0);
//    }

    /**
     * this tests and validates that the correct length is returned of a range with two negative bounds
     */
    @Test
    public void getLengthOfTwoNegativeBounds() {
        assertEquals("The length of 1.0 should be returned", 1.0, negativeDecimalRange.getLength(), 0);
    }

    /**
     * this tests and validates that the correct length is returned of a range with negative lower and positive upper bounds
     */
    @Test
    public void getLengthOfMixedBounds() {
        assertEquals("The length of 2.0 should be returned", 2.0, mixedRange.getLength(), 0);
    }

    /**
     * this tests and validates that the length of 0 is returned for a range with equal bounds
     */
    @Test
    public void getLengthOfEqualBounds() {
        assertEquals("The length of 0.0 should be returned.", 0, zeroRange.getLength(), 0);
    }

    /**
     * tear down for the "getUpperBound" method tests
     *
     * @throws Exception
     */
    @After
    public void tearDownGetLength() throws Exception {
        mixedRange = null;
        zeroRange = null;
        negativeDecimalRange = null;
        positiveDecimalRange = null;
    }

    /**
     * setup for the "getCentralValue" method tests
     *
     * @throws Exception
     */
    @Before
    public void setUpGetCentralValue() throws Exception {
        mixedRange = new Range(-1, 1);
        zeroRange = new Range(0, 0);
        negativeDecimalRange = new Range(-2.5, -1.5);
        positiveDecimalRange = new Range(3.5, 6.6);
    }
    


    /**
     * this tests and validates that the correct central value is returned of a range with positive bounds
     */
    @Test
    public void getCentralValueOfPositiveRange() {
        assertEquals("The central value of 5.05 should be returned", 5.05, positiveDecimalRange.getCentralValue(), 0);
    }

    /**
     * this tests and validates that the correct central value is returned of a range with negative bounds
     */
    @Test
    public void getCentralValueOfNegativeRange() {
        assertEquals("The length of -2.0 should be returned.", -2.0, negativeDecimalRange.getCentralValue(), 0);
    }

    /**
     * this tests and validates that the correct central value is returned of a range with mixed bounds
     */
    @Test
    public void getCentralValueOfMixedRange() {
        assertEquals("The length of 0.0 should be returned.", 0.0, mixedRange.getCentralValue(), 0);
    }

    /**
     * this tests and validates that the correct central value of 0 returned for the range (0,0)
     */
    @Test
    public void getCentralValueOfZeroRange() {
        assertEquals("The length of 0.0 should be returned.", 0.0, zeroRange.getCentralValue(), 0);
    }

    /*
     * setup for the "getIntersect" method tests
     */

    /**
     * tear down for the "getUpperBound" method tests
     *
     * @throws Exception
     */
    @After
    public void tearDownGetCentralValue() throws Exception {
        mixedRange = null;
        zeroRange = null;
        negativeDecimalRange = null;
        positiveDecimalRange = null;
    }

    @Before
    public void setUpIntersect() throws Exception {
        mixedRange = new Range(-1, 1);
    }

    @Test
    public void validateBeforeIntersection() {
    	Range intersection = new Range(-1.5, 0);
    	double intersectionUpper = intersection.getUpperBound();
    	double intersectionLower = intersection.getLowerBound();
        assertTrue("The value of true should be returned", mixedRange.intersects(intersectionLower, intersectionUpper));
    }
    
    /**
     * this tests and validates that the correct intersect range is returned for lower intersections
     */
    @Test
    public void getIntersectRangeLowerIntersection() {
        assertTrue("The value of true should be returned", mixedRange.intersects(-1.5, 0));
    }

    /**
     * this tests and validates that the correct intersect range is returned for upper intersections
     */
    @Test
    public void getIntersectRangeUpperIntersection() {
        assertTrue("The value of true should be returned", mixedRange.intersects(0, 1.5));
    }

    /**
     * this tests and validates that invalid ranges are not intersected
     */
    @Test
    public void getIntersectRangeUpperIntersectionFailure() {
        assertFalse("The value of false should be returned", mixedRange.intersects(0.5, 0.3));
    }

    /**
     * this tests and validates that ranges that are not intersected are not intersected
     */
    @Test
    public void getIntersectRangeLowerIntersectionFailure() {
        assertFalse("The value of false should be returned", mixedRange.intersects(-1.5, -1.1));
    }

    /*
     * tear down for the "getIntersect" method tests
     */
    @After
    public void tearDownIntersect() throws Exception {
        mixedRange = null;
    }

    /*
     * setup for the "getConstrain" method tests
     */
    @Before
    public void setUpConstrain() throws Exception {
        mixedRange = new Range(-1, 1);
    }

    /**
     * this tests and validates that the correct constrained value is returned for values above the upper bound
     */
    @Test
    public void getConstrainedValueUpper() {
        assertEquals("The value of 1.0 should be returned", 1.0, mixedRange.constrain(1.5), 0);
    }

    /**
     * this tests and validates that the correct constrained value is returned for values in between the bounds
     */
    @Test
    public void getConstrainedValueBetween() {
        assertEquals("The value of 0 should be returned", 0, mixedRange.constrain(0), 0);
    }

    /**
     * this tests and validates that the correct constrained value is returned for values below the lower bound
     */
    @Test
    public void getConstrainedValueBelow() {
        assertEquals("The value of -1 should be returned", -1.0, mixedRange.constrain(-1.5), 0);
    }

    /*
     * tear down for the "getConstrain" method tests
     */
    @After
    public void tearDownConstrain() throws Exception {
        mixedRange = null;
    }

    /*
     * setup for the "getCombine" method tests
     */
    @Before
    public void setUpCombine() throws Exception {
        mixedRange = new Range(-1, 1);
        positiveRange = new Range(5, 10);
    }

    /**
     * this tests and validates that the correct combined range is returned for null ranges
     */
    @Test
    public void getCombinedRangeFirstNull() {
        Range answer = Range.combine(mixedRange, null);
        assertEquals("The first range should be returned", -1, answer.getLowerBound(), 0);
        assertEquals("The first range should be returned", 1, answer.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct combined range is returned for null ranges
     */
    @Test
    public void getCombinedRangeSecondNull() {
        Range answer = Range.combine(null, mixedRange);
        assertEquals("The first range should be returned", -1, answer.getLowerBound(), 0);
        assertEquals("The first range should be returned", 1, answer.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct combined range is returned for non null ranges
     */
//    @Test
//    public void getCombinedRange() {
//        Range answer = Range.combine(mixedRange, positiveRange);
//        assertEquals("The first range lower bound should be returned", -1, answer.getLowerBound(), 0);
//        assertEquals("The second range upper bound should be returned", 10, answer.getUpperBound(), 0);
//    }

    /*
     * tear down for the "getCombine" method tests
     */
    @After
    public void tearDownCombinedRange() throws Exception {
        mixedRange = null;
        positiveRange = null;
    }

    /*
     * setup for the "getCombineIgnoringNaN" method tests
     */
    @Before
    public void setUpComingeIgnoringNaN() throws Exception {
        mixedRange = new Range(-1, 1);
        positiveRange = new Range(5, 10);
        lowerNaNRange = new Range(Double.NaN, 10);
        upperNaNRange = new Range(-5, Double.NaN);
    }

    /**
     * this tests and validates that the correct combined range is returned for both NaN ranges
     */
    @Test
    public void getCombineIgnoringNaNBothNaN() {
        assertNull(Range.combineIgnoringNaN(NaNRange, NaNRange));
    }

    /**
     * this tests and validates that the correct combined range is returned for a null range and a NaN range
     */
    @Test
    public void getCombineIgnoringNaNLowerNull() {
        assertNull(Range.combineIgnoringNaN(null, NaNRange));
    }

    /**
     * this tests and validates that the correct combined range is returned for a NaN range and a null range
     */
    @Test
    public void getCombineIgnoringNaNUpperNull() {
        assertNull(Range.combineIgnoringNaN(NaNRange, null));
    }

    /**
     * this tests and validates that the correct combined range is returned for a NaN range and a non null range
     */
    @After
    public void tearDownCombineRangeIgnoringNaN() throws Exception {
        mixedRange = null;
        positiveRange = null;
        lowerNaNRange = null;
        upperNaNRange = null;
    }

    /*
     * setup for the "rangeToInclude" method tests
     */
    @Before
    public void setupRangeToInclude() throws Exception {
        mixedRange = new Range(-1, 1);
    }

    /**
     * this tests and validates that the correct range is returned for a null value
     */
    @Test
    public void getRangeToIncludeNullValue() {
        Range answer = Range.expandToInclude(null, 10);
        assertEquals("The lower bound should be 10", 10, answer.getLowerBound(), 0);
        assertEquals("The upper bound should be 10", 10, answer.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct range is returned to include a value below the bounds
     */
    @Test
    public void getRangeToIncludeLowerValue() {
        Range answer = Range.expandToInclude(mixedRange, -10);
        assertEquals("The lower bound should be -10", -10, answer.getLowerBound(), 0);
        assertEquals("The upper bound should be 1", 1, answer.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct range is returned to include a value above the bounds
     */
    @Test
    public void getRangeToIncludeUpperValue() {
        Range answer = Range.expandToInclude(mixedRange, 10);
        assertEquals("The lower bound should be -1", -1, answer.getLowerBound(), 0);
        assertEquals("The upper bound should be 10", 10, answer.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct range is returned to include a value within the bounds
     */
    @Test
    public void getRangeToIncludeInnerValue() {
        Range answer = Range.expandToInclude(mixedRange, 0);
        assertEquals("The lower bound should be -1", -1, answer.getLowerBound(), 0);
        assertEquals("The upper bound should be 1", 1, answer.getUpperBound(), 0);
    }

    /*
     * tear down for the "rangeToInclude" method tests
     */
    @After
    public void tearDownRangeToInclude() throws Exception {
        mixedRange = null;
    }

    /*
     * setup for the "equals" method tests
     */
    @Before
    public void setupEquals() throws Exception {
        mixedRange = new Range(-1, 1);
    }

    /**
     * this tests and validates that the correct boolean is returned for a parameter with the wrong type
     */
    @Test
    public void getEqualsWrongType() {
        assertNotEquals("Hello", mixedRange);
    }

    /**
     * this tests and validates that the correct boolean is returned for normal ranges
     */
    @Test
    public void getEqualsRightRange() {
        assertEquals(mixedRange, mixedRange);
    }

    /**
     * this tests and validates that false is returned when lower bounds don't match
     */
    @Test
    public void getEqualWrongRangeLower() {
        assertNotEquals(mixedRange, new Range(-5, 1));
    }

    /**
     * this tests and validates that false is returned when upper bounds don't match
     */
    @Test
    public void getEqualWrongRangeUpper() {
        assertNotEquals(mixedRange, new Range(-1, 5));
    }

    /*
     * tear down for the "equals" method tests
     */
    @After
    public void tearDownEquals() throws Exception {
        mixedRange = null;
    }

    /*
     * setup for the NaN tests
     */
    @Before
    public void setupNaN() throws Exception {
        mixedRange = new Range(-1, 1);
        NaNRange = new Range(Double.NaN, Double.NaN);
        lowerNaNRange = new Range(Double.NaN, 1);
        upperNaNRange = new Range(-1, Double.NaN);
    }

    /**
     * this tests and validates that true is returned for a NaN range
     */
    @Test
    public void getIsNaNForNaNRange() {
        assertTrue(NaNRange.isNaNRange());
    }

    /**
     * this tests and validates that false is returned range with only one NaN value
     */
    @Test
    public void getIsNaNForLowerNaNRange() {
        assertFalse(lowerNaNRange.isNaNRange());
    }

    /**
     * this tests and validates that false is returned range with only one NaN value
     */
    @Test
    public void getIsNaNForUpperNaNRange() {
        assertFalse(upperNaNRange.isNaNRange());
    }

    /**
     * this tests and validates that false is returned for a non NaN range
     */
    @Test
    public void getIsNaNForMixedRange() {
        assertFalse(mixedRange.isNaNRange());
    }

    /*
     * tear down for the NaN tests
     */
    @After
    public void tearDownIsNaN() throws Exception {
        mixedRange = null;
        NaNRange = null;
        lowerNaNRange = null;
        upperNaNRange = null;
    }

    /*
     * setup for the "shift" method tests
     */
    @Before
    public void setupShift() throws Exception {
        mixedRange = new Range(-1, 1);
    }

    /**
     * this tests and validates that the correct range is returned for zero crossing shifts
     */
    @Test
    public void testShiftWithZeroCrossing() {
        Range answer = Range.shift(mixedRange, 3, true);
        assertEquals("The Lower Bound should be 2", 2, answer.getLowerBound(), 0);
        assertEquals("The Upper Bound should be 4", 4, answer.getUpperBound(), 0);
    }

    /**
     * this tests and validates that the correct range is returned for non zero crossing shifts
     */
    @Test
    public void testShiftWithoutZeroCrossing() {
        Range answer = Range.shift(mixedRange, 3, false);
        assertEquals("The Lower Bound should be 2", 0, answer.getLowerBound(), 0);
        assertEquals("The Upper Bound should be 4", 4, answer.getUpperBound(), 0);
    }

    /*
     * tear down for the "shift" method tests
     */
    @After
    public void tearDownShift() throws Exception {
        mixedRange = null;
    }
    
    
    /*
     * setup for the "scale" method tests
     */
    @Before
    public void setupScale() throws Exception {
        defaultRange = new Range(0, 10);
    }
    
    @Test
    public void testScaleZeroFactor() {
        defaultRange = new Range(0, 10);
        Range scaled = Range.scale(defaultRange, 0);
        Assert.assertEquals(0, scaled.getLowerBound(), 0.001);
        Assert.assertEquals(0, scaled.getUpperBound(), 0.001);
    }

    @Test
    public void testScaleFactorOne() {
        defaultRange = new Range(0, 10);
        Range scaled = Range.scale(defaultRange, 1.0);
        Assert.assertEquals(defaultRange.getLowerBound(), scaled.getLowerBound(), 0.001);
        Assert.assertEquals(defaultRange.getUpperBound(), scaled.getUpperBound(), 0.001);
    }

    @Test
    public void testScaleFactorGreaterThanOne() {
        defaultRange = new Range(0, 10);
        Range scaled = Range.scale(this.defaultRange, 1.5);
        Assert.assertEquals(0, scaled.getLowerBound(), 0.001);
        Assert.assertEquals(15, scaled.getUpperBound(), 0.001);
    }

    @Test
    public void testScaleFactorLessThanOne() {
        defaultRange = new Range(0, 10);
        Range scaled = Range.scale(defaultRange, 0.5);
        Assert.assertEquals(0, scaled.getLowerBound(), 0.001);
        Assert.assertEquals(5, scaled.getUpperBound(), 0.001);
    }
    
    /*
     * tear down for the "scale" method tests
     */
    @After
    public void tearDownScale() throws Exception {
        defaultRange = null;
    }
    
    /*
     * setup for the "Combine" method tests
     */
    @Before
    public void setupCombine() throws Exception {
        defaultRange = new Range(0, 10);
    }
    
    @Test
    public void testCombineBothNull() {
        Range range = Range.combine(null, null);
        Assert.assertNull(range);
    }

    @Test
    public void testCombineFirstNull() {
        Range range1 = null;
        Range range2 = new Range(0, 10);
        Range range = Range.combine(range1, range2);
        Assert.assertEquals(range2, range);
    }

    @Test
    public void testCombineSecondNull() {
        Range range1 = new Range(0, 10);
        Range range2 = null;
        Range range = Range.combine(range1, range2);
        Assert.assertEquals(range1, range);
    }

    @Test
    public void testCombineOverlap() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(5, 15);
        Range range = Range.combine(range1, range2);
        Assert.assertEquals(new Range(0, 15), range);
    }
    
    /*
     * tear down for the "Combine" method tests
     */
    @After
    public void tearDownCombine() throws Exception {
        mixedRange = null;
    }
    
    @Test
    public void testExpandBothMarginsZero() {
        Range range = new Range(0, 10);
        Range expandedRange = Range.expand(range, 0, 0);
        Assert.assertEquals(range, expandedRange);
    }

    @Test
    public void testExpandLowerMarginOnly() {
        Range range = new Range(0, 10);
        Range expandedRange = Range.expand(range, 0.5, 0);
        Assert.assertEquals(new Range(-5, 10), expandedRange);
    }

    @Test
    /**
     * this tests and validates that expanding a 0,10 range with upper margin parameters will expand only the upper
     */
    public void testExpandUpperMarginOnly() {
        Range range = new Range(0, 10);
        Range expandedRange = Range.expand(range, 0, 0.5);
        Assert.assertEquals(new Range(0, 15), expandedRange);
    }

    @Test
    /**
     * this tests and validates that expanding a 0,10 range with upper and lower margins will expand both ends
     */
    public void testExpandBothMargins() {
        Range range = new Range(0, 10);
        Range expandedRange = Range.expand(range, 0.25, 0.5);
        Assert.assertEquals(new Range(-2.5, 15), expandedRange);
    }

    @Test
    /**
     * this tests and validates that expanding a 0,0 range leaves it unchanged
     */
    public void testExpandZeroRange() {
        Range range = new Range(0, 0);
        Range expandedRange = Range.expand(range, 0.25, 0.5);
        Assert.assertEquals(new Range(0, 0), expandedRange);
    }
    
}
