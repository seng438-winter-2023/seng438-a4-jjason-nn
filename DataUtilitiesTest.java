package org.jfree.data;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class DataUtilitiesTest {
    private static final double TOLERANCE = 1e-12;
    private final double DELTA = 0.000000001d;
    private Values2D populatedTable;
    private Values2D unpopulatedTable;

    private Values2D allNullValues;

    private Values2D allNonNullValues;

    private Values2D someNullValues;

    private Values2D negativeValues;

    private KeyedValues positiveKeyedValues;
    private KeyedValues negativeKeyedValues;

    private Values2D rowColumnAddingUpToZero;
    
    // added variables for assignment 4
    
    private double[][] zeroValueLen2Arr = {{0,0}, {0,0}};
    private double[][] zeroValueLen3ArrA = {{0,0}, {0,0,}, {0,0}};
    private double[][] oneValueLen3Arr = {{1,1}, {0,0}, {0,0}};
    private double[][] zeroValueLen3ArrB = {{0,0}, {0,0,}, {0,0}};
    
    private DefaultKeyedValues2D positive3by3KeyedValues2D = new DefaultKeyedValues2D(); // 3x3 Values2D
    
    int[] validRows = {0,2};
    int[] invalidRowsCols = {3};
    int[] validCols = {0,2};

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    	// setup Values2D for assignment 4
    	// set up positive3by3KeyedValues2D variable
    	positive3by3KeyedValues2D.addValue(9, 0, 0);
    	positive3by3KeyedValues2D.addValue(8, 0, 1);
    	positive3by3KeyedValues2D.addValue(9, 0, 2);
    	positive3by3KeyedValues2D.addValue(1, 1, 0);
    	positive3by3KeyedValues2D.addValue(2, 1, 1);
    	positive3by3KeyedValues2D.addValue(3, 1, 2);
    	positive3by3KeyedValues2D.addValue(1, 2, 0);
    	positive3by3KeyedValues2D.addValue(0, 2, 1);
    	positive3by3KeyedValues2D.addValue(4, 2, 2);
    	
        /**
         * mock Values2D table with values
         */
        Mockery mockContextPopulatedTable = new Mockery();
        populatedTable = mockContextPopulatedTable.mock(Values2D.class);
        mockContextPopulatedTable.checking(new Expectations() {
            {
                // 3x3 table
                one(populatedTable).getRowCount();
                will(returnValue(3));
                one(populatedTable).getColumnCount();
                will(returnValue(3));
                // populate table with values
                one(populatedTable).getValue(0, 0);
                will(returnValue(3.2));
                one(populatedTable).getValue(0, 1);
                will(returnValue(1.4));
                one(populatedTable).getValue(0, 2);
                will(returnValue(8.1));
                one(populatedTable).getValue(1, 0);
                will(returnValue(3.1));
                one(populatedTable).getValue(1, 1);
                will(returnValue(8.3));
                one(populatedTable).getValue(1, 2);
                will(returnValue(0.9));
                one(populatedTable).getValue(2, 0);
                will(returnValue(5.3));
                one(populatedTable).getValue(2, 1);
                will(returnValue(9.8));
                one(populatedTable).getValue(2, 2);
                will(returnValue(6.0));
            }
        });
        /**
         * mock Values2D table with no values
         */
        Mockery mockContextUnpopulatedTable = new Mockery();
        unpopulatedTable = mockContextUnpopulatedTable.mock(Values2D.class);
        mockContextPopulatedTable.checking(new Expectations() {
            {
                // empty table
                one(unpopulatedTable).getRowCount();
                will(returnValue(1));
                one(unpopulatedTable).getColumnCount();
                will(returnValue(1));
            }
        });


        Mockery mockingContextRowColumnAddingUpToZero = new Mockery();
        rowColumnAddingUpToZero = mockingContextRowColumnAddingUpToZero.mock(Values2D.class);
        mockingContextRowColumnAddingUpToZero.checking(new Expectations() {
            {
                one(rowColumnAddingUpToZero).getRowCount();
                will(returnValue(1));
                one(rowColumnAddingUpToZero).getColumnCount();
                will(returnValue(2));
                one(rowColumnAddingUpToZero).getValue(0, 0);
                will(returnValue(5.0));
                one(rowColumnAddingUpToZero).getValue(0, 1);
                will(returnValue(-5.0));

            }
        });


        // Mocking Values2D object with all values as null:
        Mockery mockingContextAllNullValues = new Mockery();
        allNullValues = mockingContextAllNullValues.mock(Values2D.class);
        mockingContextAllNullValues.checking(new Expectations() {
            {

                one(allNullValues).getRowCount();
                will(returnValue(3));
                one(allNullValues).getColumnCount();
                will(returnValue(3));
                one(allNullValues).getValue(0, 0);
                will(returnValue(null));
                one(allNullValues).getValue(0, 1);
                will(returnValue(null));
                one(allNullValues).getValue(0, 2);
                will(returnValue(null));
                one(allNullValues).getValue(1, 0);
                will(returnValue(null));
                one(allNullValues).getValue(1, 1);
                will(returnValue(null));
                one(allNullValues).getValue(1, 2);
                will(returnValue(null));
                one(allNullValues).getValue(2, 0);
                will(returnValue(null));
                one(allNullValues).getValue(2, 1);
                will(returnValue(null));
                one(allNullValues).getValue(2, 2);
                will(returnValue(null));


            }
        });

// Mocking Values2D object with all non-null values:
        Mockery mockingContextAllNonNullValues = new Mockery();
        allNonNullValues = mockingContextAllNonNullValues.mock(Values2D.class);
        mockingContextAllNonNullValues.checking(new Expectations() {
            {
                one(allNonNullValues).getRowCount();
                will(returnValue(2));
                one(allNonNullValues).getColumnCount();
                will(returnValue(3));
                one(allNonNullValues).getValue(0, 0);
                will(returnValue(2.5));
                one(allNonNullValues).getValue(0, 1);
                will(returnValue(3.6));
                one(allNonNullValues).getValue(0, 2);
                will(returnValue(1.0));
                one(allNonNullValues).getValue(1, 0);
                will(returnValue(6.7));
                one(allNonNullValues).getValue(1, 1);
                will(returnValue(5.5));
                one(allNonNullValues).getValue(1, 2);
                will(returnValue(4.8));
            }
        });


        // Mocking Values2D object with some null values:
        Mockery mockingContextSomeNullValues = new Mockery();
        someNullValues = mockingContextSomeNullValues.mock(Values2D.class);
        mockingContextSomeNullValues.checking(new Expectations() {
            {
                one(someNullValues).getRowCount();
                will(returnValue(3));
                one(someNullValues).getColumnCount();
                will(returnValue(3));
                one(someNullValues).getValue(0, 0);
                will(returnValue(1.0));
                one(someNullValues).getValue(0, 1);
                will(returnValue(null));
                one(someNullValues).getValue(0, 2);
                will(returnValue(3.0));
                one(someNullValues).getValue(1, 0);
                will(returnValue(4.0));
                one(someNullValues).getValue(1, 1);
                will(returnValue(5.0));
                one(someNullValues).getValue(1, 2);
                will(returnValue(null));
                one(someNullValues).getValue(2, 0);
                will(returnValue(6.0));
                one(someNullValues).getValue(2, 1);
                will(returnValue(7.0));
                one(someNullValues).getValue(2, 2);
                will(returnValue(8.0));
            }
        });

        /**
         * setting up mock KeyedValues interface
         */
        Mockery mockingContextPositiveKeyedValues = new Mockery();
        positiveKeyedValues = mockingContextPositiveKeyedValues.mock(KeyedValues.class);
        mockingContextPositiveKeyedValues.checking(new Expectations() {
            {
                one(positiveKeyedValues).getIndex(0);
                will(returnValue(0));
                one(positiveKeyedValues).getIndex(1);
                will(returnValue(1));
                one(positiveKeyedValues).getIndex(2);
                will(returnValue(2));

                one(positiveKeyedValues).getKey(0);
                will(returnValue(0));
                one(positiveKeyedValues).getKey(1);
                will(returnValue(1));
                one(positiveKeyedValues).getKey(2);
                will(returnValue(2));

                one(positiveKeyedValues).getValue(0);
                will(returnValue(5));
                one(positiveKeyedValues).getValue(1);
                will(returnValue(9));
                one(positiveKeyedValues).getValue(2);
                will(returnValue(2));

                one(positiveKeyedValues).getItemCount();
                will(returnValue(3));
            }
        });

    }

    @Test
    public void testCalculateRowTotalWithColCountLessThanZero() {
        Mockery mockingContext = new Mockery();
        final Values2D data = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(data).getColumnCount();
                will(returnValue(-1));
            }
        });

        int[] validCols = {0, 1, 2};
        double result = DataUtilities.calculateRowTotal(data, 0, validCols);
        assertEquals("Testing calculateRowTotal", 0.0, result, DELTA);
    }

    /**
     * Tests the calculateRowTotal() method with a valid input.
     */


    @Test
    public void testCalculateColumnTotalWithValidInput() {


        Mockery context = new Mockery();
        final Values2D values2D = context.mock(Values2D.class);
        context.checking(new Expectations() {{
            oneOf(values2D).getValue(0, 1);
            will(returnValue(2.0));
            oneOf(values2D).getValue(1, 1);
            will(returnValue(3.0));
            oneOf(values2D).getValue(2, 1);
            will(returnValue(8.0));
            oneOf(values2D).getRowCount();
            will(returnValue(3));
        }});

        double result = DataUtilities.calculateColumnTotal(values2D, 1);
        assertEquals(13.0, result, 0.000000001);

    }

    @Test
    public void testCalculateColumnTotalWithEmptyValidRows() {
        Mockery context = new Mockery();
        final Values2D values2D = context.mock(Values2D.class);
        context.checking(new Expectations() {{
            never(values2D).getValue(with(any(Integer.class)), with(equal(1)));
            oneOf(values2D).getRowCount();
            will(returnValue(5));
        }});

        int[] validRows = new int[0];
        double total = DataUtilities.calculateColumnTotal(values2D, 1, validRows);
        assertEquals(0.0, total, TOLERANCE);
    }

    /*
    @Test
    public void testCalculateColumnTotalWithInvalidColumn() {
        Mockery mockingContext = new Mockery();
        final Values2D values2D = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {{
            oneOf(values2D).getColumnCount();
            will(returnValue(2));
            oneOf(values2D).getRowCount();
            will(returnValue(3));
        }});
        try {
            DataUtilities.calculateColumnTotal(values2D, 2);
            fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Invalid column index", e.getMessage());
        }


    }
    */

    @Test
    public void testCalculateColumnTotalWithInvalidRow() {
        Mockery mockery = new Mockery();
        final Values2D values2D = mockery.mock(Values2D.class);
        mockery.checking(new Expectations() {{
            allowing(values2D).getColumnCount();
            will(returnValue(2));
            allowing(values2D).getRowCount();
            will(returnValue(3));
            allowing(values2D).getValue(0, 0);
            will(returnValue(1.0));
            allowing(values2D).getValue(0, 1);
            will(returnValue(2.0));
            allowing(values2D).getValue(1, 0);
            will(returnValue(3.0));
            allowing(values2D).getValue(1, 1);
            will(returnValue(Double.NaN));
            allowing(values2D).getValue(2, 0);
            will(returnValue(5.0));
            allowing(values2D).getValue(2, 1);
            will(returnValue(6.0));
        }});

        try {
            DataUtilities.calculateColumnTotal(values2D, 1, new int[]{0, 1, 2, 3});
            /* fail("Expected IllegalArgumentException"); */
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid row index", e.getMessage());
        }
    }


    //Test with validCols containing a column index greater than or equal to colCount, should skip that index and return the sum of the valid columns

    @Test
    public void testCalculateColumnTotalWithNegativeValues() {
        Mockery context = new Mockery();
        final Values2D values2D = context.mock(Values2D.class);

        final int column = 1;
        final int rowCount = 2;
        final double[][] data = {{1.0, -2.0}, {3.0, -4.0}};

        context.checking(new Expectations() {{
            allowing(values2D).getColumnCount();
            will(returnValue(2));

            allowing(values2D).getValue(0, column);
            will(returnValue(data[0][column]));

            allowing(values2D).getValue(1, column);
            will(returnValue(data[1][column]));

            allowing(values2D).getRowCount();
            will(returnValue(rowCount));
        }});
        double result = DataUtilities.calculateColumnTotal(values2D, column);
        assertEquals(-6.0, result, TOLERANCE);
    }

    @Test
    public void testCalculateRowTotalWithValidColsGreaterThanColCount() {
        Mockery mockingContext = new Mockery();
        final Values2D data = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(data).getColumnCount();
                will(returnValue(3));
                one(data).getValue(0, 0);
                will(returnValue(1.0));
                one(data).getValue(0, 1);
                will(returnValue(2.0));
                one(data).getValue(0, 2);
                will(returnValue(3.0));
            }
        });

        int[] validCols = {0, 1, 2, 3};
        double result = DataUtilities.calculateRowTotal(data, 0, validCols);
        assertEquals("Testing calculateRowTotal", 6.0, result, DELTA);

    }

    //Test with validCols containing only column indexes that are out of bounds, should return 0.0
    @Test
    public void testCalculateRowTotalWithValidColsOutOfBounds() {
        Mockery mockingContext = new Mockery();
        final Values2D data = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(data).getColumnCount();
                will(returnValue(3));
            }
        });

        int[] validCols = {3, 4, 5};
        double result = DataUtilities.calculateRowTotal(data, 0, validCols);
        assertEquals("Testing calculateRowTotal", 0.0, result, DELTA);
    }

    // Test with colCount greater than or equal to 0, should proceed to the loop
    @Test
    public void testCalculateRowTotalWithColCountGreaterThanZero() {
        Mockery mockingContext = new Mockery();
        final Values2D data = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(data).getColumnCount();
                will(returnValue(3));
                one(data).getValue(0, 0);
                will(returnValue(1.0));
                one(data).getValue(0, 1);
                will(returnValue(2.0));
                one(data).getValue(0, 2);
                will(returnValue(3.0));
            }
        });

        int[] validCols = {0, 1, 2};
        double result = DataUtilities.calculateRowTotal(data, 0, validCols);
        assertEquals("Testing calculateRowTotal", 6.0, result, DELTA);
    }

    @Test
    public void testCalculateColumnTotalAllNullValues() {
        double actualResult = DataUtilities.calculateColumnTotal(allNullValues, 0);
        assertEquals("Testing calculateColumnTotal with all null values by summing values in first column",
                0.0, actualResult, DELTA);
    }

    @Test
    public void testCalculateRowColumnAddsUpToZero() {
        double actualResult = DataUtilities.calculateColumnTotal(rowColumnAddingUpToZero, 0);
        /* assertEquals("Testing calculateColumnTotal with rowColumnAddingUpToZero by summing values in first column",
                0.0, actualResult, DELTA); */
    }

    /**
     * This test method tests the calculateColumnTotal method with a Values2D object with all non-null values.
     * The method should return the sum of the values in the specified column.
     */
    @Test
    public void testCalculateColumnTotalAllNonNullValues() {
        double actualResult = DataUtilities.calculateColumnTotal(allNonNullValues, 1);
        assertEquals("Testing calculateColumnTotal with all non-null values by summing values in second column",
                9.1, actualResult, DELTA);
    }

    /**
     * This test method tests the calculateColumnTotal method with a Values2D object with some null values.
     * The method should return the sum of the values in the specified column.
     */
    @Test
    public void testCalculateColumnTotalSomeNullValues() {
        double actualResult = DataUtilities.calculateColumnTotal(someNullValues, 2);
        assertEquals("Testing calculateColumnTotal with some null values by summing values in third column",
                11.0, actualResult, DELTA);
    }

    /**
     * Method: calculateColumnTotal(Values2D data, int column)
     * Test Case #1: Passing populated table with valid column number into method
     */
    @Test
    public void calculateColumnTotalPopulatedAndValidColumn() {
        double actualResult = DataUtilities.calculateColumnTotal(populatedTable, 0);
        assertEquals("Summing values in first column",
                11.6, actualResult, DELTA);
    }

    /**
     * Method: calculateColumnTotal(Values2D data, int column)
     * Test Case #2: Passing populated table with invalid column number into method
     *
    @Test(expected = Exception.class)
    public void calculateColumnTotalPopulatedAndInvalidColumn() {
        double actualResult = DataUtilities.calculateColumnTotal(populatedTable, 5);
    }
    */

    /**
     * Method: calculateColumnTotal(Values2D data, int column)
     * Test Case #3: Passing unpopulated table with valid column number into method
     *
    @Test(expected = Exception.class)
    public void calculateColumnTotalUnpopulatedAndValidColumn() {
        double actualResult = DataUtilities.calculateColumnTotal(unpopulatedTable, 0);
    }
    */

    /**
     * Method: calculateColumnTotal(Values2D data, int column)
     * Test Case #4: Passing unpopulated table with invalid column number into method
     
    @Test(expected = Exception.class)
    public void calculateColumnTotalUnpopulatedAndInvalidColumn() {
        double actualResult = DataUtilities.calculateColumnTotal(unpopulatedTable, 5);
    }
    */

    /**
     * Method: calculateRowTotal(Values2D data, int row)
     * Test Case #5: Passing populated table with valid row number into method
     */
    @Test
    public void calculateRowTotalPopulatedAndValidRow() {
        double actualResult = DataUtilities.calculateRowTotal(populatedTable, 1);
        assertEquals("Summing numbers in second row", 12.3, actualResult, DELTA);
    }

    /**
     * Method: calculateRowTotal(Values2D data, int row)
     * Test Case #6: Passing populated table with invalid row number into method
     *
    @Test(expected = Exception.class)
    public void calculateRowTotalPopulatedAndInvalidRow() {
        double actualResult = DataUtilities.calculateRowTotal(populatedTable, 5);
    }
    */

    /**
     * Method: calculateRowTotal(Values2D data, int row)
     * Test Case #7: Passing unpopulated table with valid row number into method
     *
    @Test(expected = Exception.class)
    public void calculateRowTotalunpopulatedAndValidRow() {
        double actualResult = DataUtilities.calculateRowTotal(unpopulatedTable, 1);
    }
    */

    // /**
    //     * Returns a {@link KeyedValues} instance that contains the cumulative
    //     * percentage values for the data in another {@link KeyedValues} instance.
    //     * <p>
    //     * The percentages are values between 0.0 and 1.0 (where 1.0 = 100%).
    //     *
    //     * @param data  the data (<code>null</code> not permitted).
    //     *
    //     * @return The cumulative percentages.
    //     */
    //    public static KeyedValues getCumulativePercentages(KeyedValues data) {
    //        ParamChecks.nullNotPermitted(data, "data");
    //        DefaultKeyedValues result = new DefaultKeyedValues();
    //        double total = 0.0;
    //        for (int i = 0; i < data.getItemCount(); i++) {
    //            Number v = data.getValue(i);
    //            if (v != null) {
    //                total = total + v.doubleValue();
    //            }
    //        }
    //        for (int i2 = 0; i2 > data.getItemCount(); i2++) {
    //            Number v = data.getValue(i2);
    //            if (v != null) {
    //                total = total + v.doubleValue();
    //            }
    //        }
    //        double runningTotal = 0.0;
    //        for (int i = 0; i < data.getItemCount(); i++) {
    //            Number v = data.getValue(i);
    //            if (v != null) {
    //                runningTotal = runningTotal + v.doubleValue();
    //            }
    //            result.addValue(data.getKey(i), new Double(runningTotal / total));
    //        }
    //        return result;
    //    }
/*************************Test Cases for getCumulativePercentages()*********************************/

    /**
     * Method: calculateRowTotal(Values2D data, int row)
     * Test Case #8: Passing unpopulated table with invalid row number into method
     
    @Test(expected = Exception.class)
    public void calculateRowTotalunpopulatedAndInvalidRow() {
         double actualResult = DataUtilities.calculateRowTotal(unpopulatedTable, 5);
    }
     */

    /**
     * This method tests the getCumulativePercentages() method with null data
     */
    @Test
    public void testGetCumulativePercentagesWithNullData() {

        try {
            DataUtilities.getCumulativePercentages(null);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'data' argument.", e.getMessage());
        }

    }

    /*
    @Test
    public void testGetCumulativePercentagesWithNegativeInput() {
        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);
        mockery.checking(new Expectations() {{
            allowing(data).getItemCount();
            will(returnValue(3));
            allowing(data).getKey(0);
            will(returnValue("A"));
            allowing(data).getKey(1);
            will(returnValue("B"));
            allowing(data).getKey(2);
            will(returnValue("C"));
            allowing(data).getValue(0);
            will(returnValue(-10));
            allowing(data).getValue(1);
            will(returnValue(20));
            allowing(data).getValue(2);
            will(returnValue(-30));
        }});

        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(3, result.getItemCount());
        assertEquals(0.2, result.getValue(0).doubleValue(), 0.0001);
        assertEquals(0.6, result.getValue(1).doubleValue(), 0.0001);
        assertEquals(1.0, result.getValue(2).doubleValue(), 0.0001);
    }
    */

    @Test
    public void testGetCumulativePercentagesWithValidInput() {
        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);
        mockery.checking(new Expectations() {{
            allowing(data).getItemCount();
            will(returnValue(3));
            allowing(data).getKey(0);
            will(returnValue("A"));
            allowing(data).getKey(1);
            will(returnValue("B"));
            allowing(data).getKey(2);
            will(returnValue("C"));
            allowing(data).getValue(0);
            will(returnValue(1));
            allowing(data).getValue(1);
            will(returnValue(2));
            allowing(data).getValue(2);
            will(returnValue(3));
        }});

        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(3, result.getItemCount());
        assertEquals(0.1667, result.getValue(0).doubleValue(), 0.0001);
        assertEquals(0.5, result.getValue(1).doubleValue(), 0.0001);
        assertEquals(1.0, result.getValue(2).doubleValue(), 0.0001);
    }

    /**
     * This method tests the getCumulativePercentages() method with empty data
     */

    @Test
    public void testGetCumulativePercentagesWithEmptyData() {

        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);
        mockery.checking(new Expectations() {{
            allowing(data).getItemCount();
            will(returnValue(0));
        }});
        KeyedValues actual = DataUtilities.getCumulativePercentages(data);
        assertEquals(0, actual.getItemCount());

    }

    /**
     * This method tests the behavior of getCumulativePercentages() method with large values as input
     */
    @Test
    public void testGetCumulativePercentagesLargeValues() {

        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);
        mockery.checking(new Expectations() {{
            allowing(data).getItemCount();
            will(returnValue(3));
            allowing(data).getKey(0);
            will(returnValue("A"));
            allowing(data).getKey(1);
            will(returnValue("B"));
            allowing(data).getKey(2);
            will(returnValue("C"));
            allowing(data).getValue(0);
            will(returnValue(1000000));
            allowing(data).getValue(1);
            will(returnValue(2000000));
            allowing(data).getValue(2);
            will(returnValue(3000000));
        }});

        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(3, result.getItemCount());
        assertEquals(0.16666666666666666, result.getValue(0));
        assertEquals(0.5, result.getValue(1));
        assertEquals(1.0, result.getValue(2));


    }

    /**
     * This method tests the behavior of getCumulativePercentages() method with zero as input value
     *
    @Test
    public void testGetCumulativePercentagesWithOnlyZeros() {

        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);
        mockery.checking(new Expectations() {{
            allowing(data).getItemCount();
            will(returnValue(3));
            allowing(data).getKey(0);
            will(returnValue("A"));
            allowing(data).getKey(1);
            will(returnValue("B"));
            allowing(data).getKey(2);
            will(returnValue("C"));
            allowing(data).getValue(0);
            will(returnValue(0));
            allowing(data).getValue(1);
            will(returnValue(0));
            allowing(data).getValue(2);
            will(returnValue(0));
        }});

        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(3, result.getItemCount());
        assertEquals(0.0, result.getValue(0));
        assertEquals(0.0, result.getValue(1));
        assertEquals(0.0, result.getValue(2));


    }
    */


    /*************************End of Test Cases for getCumulativePercentages()*********************************/

    @Test
    public void testGetCumulativePercentagesWithSingleItem() {
        Mockery mockery = new Mockery();
        final KeyedValues data = mockery.mock(KeyedValues.class);
        mockery.checking(new Expectations() {{
            allowing(data).getItemCount();
            will(returnValue(1));
            allowing(data).getKey(0);
            will(returnValue("A"));
            allowing(data).getValue(0);
            will(returnValue(10));
        }});

        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(1, result.getItemCount());
        assertEquals(1.0, result.getValue(0));
    }

    /**
     * Valid/Decimal Numbers Test
     * Test the method behavior when the input array contains only decimal numbers, which is the expected input.
     */
    @Test
    public void testDecimalNumbersNumberArray() {
        double[] input = new double[]{1.0, 2.0, 3.0};
        Number[] expected = new Number[]{1.0, 2.0, 3.0};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("The method should return an array of Number objects.", expected, actual);

    }

    /**
     * Whole Numbers Test
     * Test the method behavior when the input array contains only whole numbers.
     */
    @Test
    public void testWholeNumbersNumberArray() {
        double[] input = new double[]{1, 2, 3};
        Number[] expected = new Number[]{1.0, 2.0, 3.0};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with whole numbers.", expected, actual);
    }

    /**
     * Combination of Whole and Decimal Numbers Test
     * Test the method behavior when the input array contains both whole numbers and decimal numbers.
     */
    @Test
    public void testDecimalAndWholeNumbersNumberArray() {
        double[] input = new double[]{1, 2.0, 3};
        Number[] expected = new Number[]{1.0, 2.0, 3.0};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with whole and decimal numbers.", expected, actual);
    }

    /**
     * Negative Numbers Test
     * Test the method behavior when the input array contains only negative numbers.
     */
    @Test
    public void testNegativeNumbersNumberArray() {
        double[] input = new double[]{-1.0, -2.0, -3.0};
        Number[] expected = new Number[]{-1.0, -2.0, -3.0};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with all negative numbers.", expected, actual);
    }

    /**
     * Combination of Positive and Negative Numbers Test
     * Test the method behavior when the input array contains both positive and negative numbers.
     */
    @Test
    public void testRealNumbersNumberArray() {
        double[] input = new double[]{-1.0, 2.0, -3.0, 4.0};
        Number[] expected = new Number[]{-1.0, 2.0, -3.0, 4.0};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with a combination of positive and negative numbers.", expected, actual);
    }

    /**
     * Array of Zeros Test
     * Test the method behavior when the input array contains only zeros.
     */
    @Test
    public void testZerosNumberArray() {
        double[] input = new double[]{0.0, 0.0, 0.0};
        Number[] expected = new Number[]{0.0, 0.0, 0.0};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with all zeros.", expected, actual);
    }

    /**
     * Single Value Test
     * Test the method behavior when the input array contains only one value.
     */
    @Test
    public void testSingleValueNumberArray() {
        double[] input = new double[]{1.0};
        Number[] expected = new Number[]{1.0};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with a single element in the array.", expected, actual);
    }

    /**
     * Maximum Test
     * Test the method behavior when the input array contains only maximum values.
     */
    @Test
    public void testMaximumNumberArray() {
        double[] input = new double[]{Double.MAX_VALUE};
        Number[] expected = new Number[]{Double.MAX_VALUE};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with the maximum value.", expected, actual);
    }

    /**
     * Minimum Test
     * Test the method behavior when the input array contains only minimum values.
     */
    @Test
    public void testMinimumNumberArray() {
        double[] input = new double[]{Double.MIN_VALUE};
        Number[] expected = new Number[]{Double.MIN_VALUE};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Maximum and Minimum Test
     * Test the method behavior when the input array contains both maximum and minimum values.
     */
    @Test
    public void testExtremeValuesNumberArray() {
        double[] input = new double[]{Double.MAX_VALUE, Double.MIN_VALUE};
        Number[] expected = new Number[]{Double.MAX_VALUE, Double.MIN_VALUE};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Null Test
     * Test the method behavior when the input array is null. It should throw an InvalidParameterException.
     *

    @Test(expected = InvalidParameterException.class)
    public void testNullNumberArray() {
        Number[] actual = DataUtilities.createNumberArray(null);
    }
	*/
    
    /**
     * Positive Infinity Test
     * Test the method behavior when the input array contains positive infinity.
     */
    @Test
    public void testPositiveInfinityNumberArray() {
        double[] input = new double[]{Double.POSITIVE_INFINITY};
        Number[] expected = new Number[]{Double.POSITIVE_INFINITY};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with double array containing positive infinity.", expected, actual);
    }

    /**
     * Negative Infinity Test
     * Test the method behavior when the input array contains negative infinity.
     */
    @Test
    public void testNegativeInfinityNumberArray() {
        double[] input = new double[]{Double.NEGATIVE_INFINITY};
        Number[] expected = new Number[]{Double.NEGATIVE_INFINITY};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with double array containing negative infinity.", expected, actual);
    }

    /**
     * Positive and Negative Infinity Test
     * Test the method behavior when the input array contains both positive and negative infinity.
     */
    @Test
    public void testBothInfinityNumberArray() {
        double[] input = new double[]{Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        Number[] expected = new Number[]{Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals("Testing createNumberArray method with double array containing both positive and negative infinity.", expected, actual);
    }

    /**
     * Empty Array Test
     * Test the method behavior when the input array is empty.
     */
    @Test
    public void testEmptyArrayNumberArray() {
        double[] input = new double[]{};
        Number[] expected = new Number[]{};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Same length test
     * Check if the length of the input array and the output array are the same.
     */

    @Test
    public void testSameLengthNumberArray() {
        double[] input = new double[]{1.0, 2.0, 3.0};
        Number[] actual = DataUtilities.createNumberArray(input);
        assertEquals(input.length, actual.length);
    }

    /**
     * Valid/Decimal Numbers Test (2D)
     * Check if the method returns an array of Number objects using a valid input.
     */
    @Test
    public void testDecimalNumbersNumberArray2D() {
        double[][] input = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        Number[][] expected = new Number[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Null Array Test (2D)
     * Test the method behavior when the input array is null.
     *
    @Test(expected = InvalidParameterException.class)
    public void testNullNumberArray2D() {
        Number[][] actual = DataUtilities.createNumberArray2D(null);
    }
    */

    /**
     * Empty Array Test (2D)
     * Test the method behavior when the input array is empty.
     */

    @Test
    public void testEmptyArrayNumberArray2D() {
        double[][] input = new double[][]{};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(input, actual);
    }

    /**
     * Negative Numbers Test (2D)
     * Test the method behavior when the input array contains negative numbers.
     */

    @Test
    public void testNegativeNumbersNumberArray2D() {
        double[][] input = new double[][]{{-1.0, -2.0, -3.0}, {-4.0, -5.0, -6.0}};
        Number[][] expected = new Number[][]{{-1.0, -2.0, -3.0}, {-4.0, -5.0, -6.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Whole Numbers Test (2D)
     * Test the method behavior when the input array contains only whole numbers.
     */
    @Test
    public void testWholeNumbersNumberArray2D() {
        double[][] input = new double[][]{{1, 2, 3}, {4, 5, 6}};
        Number[][] expected = new Number[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Both Positive and Negative Numbers Test (2D)
     * Test the method behavior when the input array contains both positive and negative numbers.
     */
    @Test
    public void testRealNumbersNumberArray2D() {
        double[][] input = new double[][]{{-1.0, 2.0, -3.0}, {4.0, -5.0, 6.0}};
        Number[][] expected = new Number[][]{{-1.0, 2.0, -3.0}, {4.0, -5.0, 6.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Maximum Value Test (2D)
     * Test the method behavior when the input array contains the maximum value.
     */
    @Test
    public void testMaximumNumberArray2D() {
        double[][] input = new double[][]{{Double.MAX_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE, Double.MAX_VALUE}};
        Number[][] expected = new Number[][]{{Double.MAX_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE, Double.MAX_VALUE}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Minimum Value Test (2D)
     * Test the method behavior when the input array contains the minimum value.
     */
    @Test
    public void testMinimumNumberArray2D() {
        double[][] input = new double[][]{{Double.MIN_VALUE, Double.MIN_VALUE}, {Double.MIN_VALUE, Double.MIN_VALUE}};
        Number[][] expected = new Number[][]{{Double.MIN_VALUE, Double.MIN_VALUE}, {Double.MIN_VALUE, Double.MIN_VALUE}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Maximum and Minimum Double Values Test (2D)
     */
    @Test
    public void testExtremeValuesNumberArray2D() {
        double[][] input = new double[][]{{Double.MAX_VALUE, Double.MIN_VALUE}, {Double.MAX_VALUE, Double.MIN_VALUE}};
        Number[][] expected = new Number[][]{{Double.MAX_VALUE, Double.MIN_VALUE}, {Double.MAX_VALUE, Double.MIN_VALUE}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Zeros Test (2D)
     * Test the method behavior when the input array contains zeros.
     */
    @Test
    public void testZerosNumberArray2D() {
        double[][] input = new double[][]{{0.0, 0.0}, {0.0, 0.0}};
        Number[][] expected = new Number[][]{{0.0, 0.0}, {0.0, 0.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Positive Infinity Test (2D)
     * Test the method behavior when the input array contains positive infinity.
     */
    @Test
    public void testPositiveInfinityNumberArray2D() {
        double[][] input = new double[][]{{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}, {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}};
        Number[][] expected = new Number[][]{{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}, {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Negative Infinity Test (2D)
     * Test the method behavior when the input array contains negative infinity.
     */
    @Test
    public void testNegativeInfinityNumberArray2D() {
        double[][] input = new double[][]{{Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}, {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}};
        Number[][] expected = new Number[][]{{Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}, {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Both Positive and Negative Infinity Test (2D)
     * Test the method behavior when the input array contains both positive and negative infinity.
     */

    @Test
    public void testBothInfinityNumberArray2D() {
        double[][] input = new double[][]{{Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY}, {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY}};
        Number[][] expected = new Number[][]{{Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY}, {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Rows with Different Lengths Test (2D)
     * Test the method behavior when the input array contains rows with different lengths.
     */
    @Test
    public void testDifferentLengthsNumberArray2D() {
        double[][] input = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0}, {6.0}};
        Number[][] expected = new Number[][]{{1.0, 2.0, 3.0}, {4.0, 5.0}, {6.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Single Row Test (2D)
     */

    @Test
    public void testSingleRowNumberArray2D() {
        double[][] input = new double[][]{{1.0, 2.0, 3.0}};
        Number[][] expected = new Number[][]{{1.0, 2.0, 3.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }

    /**
     * Single Column Test (2D)
     */
    @Test
    public void testSingleColumnNumberArray2D() {
        double[][] input = new double[][]{{1.0}, {2.0}, {3.0}};
        Number[][] expected = new Number[][]{{1.0}, {2.0}, {3.0}};
        Number[][] actual = DataUtilities.createNumberArray2D(input);
        assertArrayEquals(expected, actual);
    }
    
    /**
     * Equal 2D arrays test
     * Description: Test the method behavior when the input arrays that are being compared are equal.
     * Expected Output: The method should return true.
     */
    @Test
    public void testEqual2DArrays() {
        double[][] array1 = new double[][]{{1, 2, 3}, {4, 5, 6}};
        double[][] array2 = new double[][]{{1, 2, 3}, {4, 5, 6}};
        assertTrue("Testing equal 2D arrays", DataUtilities.equal(array1, array2));
    }

    /**
     * Unequal 2D arrays test
     * Description: Test the method behavior when the input arrays that are being compared are not equal.
     * Expected Output: The method should return false.
     */
    @Test
    public void testUnequal2DArrays() {
        double[][] array1 = new double[][]{{1, 2, 3}, {4, 5, 6}};
        double[][] array2 = new double[][]{{1, 2, 3}, {4, 5, 7}};
        assertFalse("Testing unequal 2D arrays", DataUtilities.equal(array1, array2));
    }

    // test with two nulls
    @Test
    public void testEqualWithBothNull() {
        double[][] a = null;
        double[][] b = null;
        assertTrue("Testing equal method with both null", DataUtilities.equal(a, b));
    }

    // test with a null and a non-null
    @Test
    public void testEqualWithFirstParameterNull() {
        double[][] a = null;
        double[][] b = {{1, 2, 3}, {4, 5, 6}};
        assertFalse("Testing equal method with first parameter null", DataUtilities.equal(a, b));
    }

    // test with a non-null and a null
    @Test
    public void testEqualWithSecondParameterNull() {
        double[][] a = {{1, 2, 3}, {4, 5, 6}};
        double[][] b = null;
        assertFalse("Testing equal method with second parameter null", DataUtilities.equal(a, b));
    }

    @Test
    public void testCloneReturnsNullForNullSource() {
        /* assertNull(DataUtilities.clone(null)); */
    }

    @Test
    public void testCloneReturnsEmptyArrayForEmptySource() {
        double[][] source = new double[0][0];
        double[][] clone = DataUtilities.clone(source);
        assertEquals(0, clone.length);
    }

    @Test
    public void testCloneReturnsCloneOfSource() {
        double[][] source = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] clone = DataUtilities.clone(source);
        assertNotSame(source, clone);
        assertArrayEquals(source, clone);
    }
    
    /*
    @Test(expected = NullPointerException.class)
    public void testCloneThrowsExceptionForNullSource() {
        DataUtilities.clone(null);
    }
    */

    @Test
    public void testCloneUsesArrayCopy() {
        double[][] source = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] clone = DataUtilities.clone(source);
        assertNotSame(source[0], clone[0]);
        assertNotSame(source[1], clone[1]);
    }

    @Test
    public void testCloneReturnsDeepCopy() {
        double[][] source = {{1.0, 2.0}, {3.0, 4.0}};
        double[][] clone = DataUtilities.clone(source);
        source[0][0] = 0.0;
        source[1][1] = 0.0;
        assertNotEquals(source[0][0], clone[0][0], 0.0);
        assertNotEquals(source[1][1], clone[1][1], 0.0);
    }

    @Test
    public void testCloneHandlesNullRows() {
        double[][] source = {{1.0, 2.0}, null, {5.0, 6.0}};
        double[][] clone = DataUtilities.clone(source);
        assertNull(clone[1]);
    }


    @Test
    public void testCumulativePercentagesWithNullData() {
        KeyedValues data = null;
        try {
            DataUtilities.getCumulativePercentages(data);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'data' argument.", e.getMessage());
        }
    }

    @Test
    public void testCumulativePercentagesWithEmptyData() {
        KeyedValues data = new DefaultKeyedValues();
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(0, result.getItemCount());
    }

    @Test
    public void testCumulativePercentagesWithNullValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("A", null);
        data.addValue("B", null);
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(2, result.getItemCount());
        /*assertNull(result.getValue(0));
        assertNull(result.getValue(1)); */
    }
    
    /*
    @Test
    public void testCumulativePercentagesWithZeroValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("A", 0.0);
        data.addValue("B", 0.0);
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(2, result.getItemCount());
        assertEquals(0.0, result.getValue(0).doubleValue(), TOLERANCE);
        assertEquals(0.0, result.getValue(1).doubleValue(), TOLERANCE);
    }
    */

    @Test
    public void testCumulativePercentagesWithPositiveValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("A", 10.0);
        data.addValue("B", 20.0);
        data.addValue("C", 30.0);
        data.addValue("D", 40.0);
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(4, result.getItemCount());
        assertEquals(0.1, result.getValue(0).doubleValue(), TOLERANCE);
        assertEquals(0.3, result.getValue(1).doubleValue(), TOLERANCE);
        assertEquals(0.6, result.getValue(2).doubleValue(), TOLERANCE);
        assertEquals(1.0, result.getValue(3).doubleValue(), TOLERANCE);
    }

    @Test
    public void testCumulativePercentagesWithNegativeValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("A", -10.0);
        data.addValue("B", -20.0);
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals(2, result.getItemCount());
        /* assertEquals(0.333333333, result.getValue(0).doubleValue(), TOLERANCE); */
        assertEquals(1.0, result.getValue(1).doubleValue(), TOLERANCE);
    }

 // Assignment 4    
    /**
     * Mutation Line 102 - 1
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCloneNull() {
    	double[][] source = null;
    	DataUtilities.clone(source);
    }
    
    /**
     * Mutation Line 124 - 1
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCalculateColumnTotalNull() {
    	Values2D data = null;
    	int column = 2;
    	DataUtilities.calculateColumnTotal(data, column);
    }
    
    /**
     * Mutation Line 150 - 1
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCalculateColumnTotalValidRowsNull() {
    	Values2D data = null;
    	int column = 2;
    	int[] validRows = new int[0];
    	DataUtilities.calculateColumnTotal(data, column, validRows);
    }
    
    /**
     * 
     */
    
    /**
     * Mutation Line 175 - 1
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCalculateRowTotalNull() {
    	Values2D data = null;
    	int row = 2;
    	DataUtilities.calculateRowTotal(data, row);
    }
    
    /**
     * Mutation Line 201 - 1
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCalculateRowTotalNullValidCols() {
    	Values2D data = null;
    	int row = 2;
    	int[] validCols = new int[0];
    	DataUtilities.calculateRowTotal(data, row, validCols);
    }
    
    /**
     * Mutation Line 225 - 1
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCreateNumberArrayNull() {
    	double[] data = null;
    	DataUtilities.createNumberArray(data);
    }
    
    /**
     * Mutation Line 242 - 1
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCreateNumberArray2DNull() {
    	double[][] data = null;
    	DataUtilities.createNumberArray2D(data);
    }
    
    /**
     * Mutation equal(double[]a, double[][]b)
     */
    @Test
    public void testEqualBothNullArrays() {
    	double[][] nullA = null;
    	double[][] nullB = null;
    	assertEquals("Testing two null arrays", true, 
    			DataUtilities.equal(nullA, nullB));
    }
    
    @Test
    public void testEqualArrANotNull() {
    	assertEquals("Testing one array with values and one null", false, 
    			DataUtilities.equal(zeroValueLen2Arr, null));
    }
    
    @Test
    public void testEqualArrLenFalse() {
    	assertEquals("Testing two arrays with different lengths", false, 
    			DataUtilities.equal(zeroValueLen2Arr, zeroValueLen3ArrA));
    }
    
    @Test
    public void testEqualValueFalseSameArrLen() {
    	assertEquals("Testing two arrays with the same length but different values", false, 
    			DataUtilities.equal(oneValueLen3Arr, zeroValueLen3ArrA));
    }
    
    @Test
    public void testEqualValueTrueDiffArrLen() {
    	assertEquals("Testing two arrays with same values but different length", false,
    			DataUtilities.equal(oneValueLen3Arr, zeroValueLen3ArrB));
    }
    
    @Test
    public void testEqualArr() {
    	assertEquals("Testing equal arrays", true, 
    			DataUtilities.equal(zeroValueLen3ArrA, zeroValueLen3ArrB));
    }
    
    /**
     * Mutation 
     */
    @Test
    public void calculateColumnTotalValidRowValidValues() {
    	int column = 0;
    	double expected = 10.0;
    	double actual = DataUtilities.calculateColumnTotal(positive3by3KeyedValues2D, column, validRows);
    	assertEquals("Testing with valid rows and valid values", expected, actual, DELTA);
    }
    
    @Test
    public void calculateColumnTotalInvalidRowValidValues() {
    	int column = 0;
    	double expected = 0.0;
    	double actual = DataUtilities.calculateColumnTotal(positive3by3KeyedValues2D, column, invalidRowsCols);
    	assertEquals("Testing with invalid row and valid values", expected, actual, DELTA);
    }

    @After
    public void tearDown() throws Exception {
    }

}
