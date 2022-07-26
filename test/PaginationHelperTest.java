import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Test class that have test methods to verify PaginationHelper class functionality
 */
public class PaginationHelperTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    Object[] testValues = new Object[]{'a', 'b', 'c', 'd', 'e', 'f'};
    Object[] testValuesOneItem = new Object[]{'a'};

    // TESTS FOR ACCEPTED VALUE REQUIREMENTS
    @Test
    public void testEmptyItemsShouldNotBeAccepted() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Empty array, please add some items");
        Object[] values = new Object[]{};
        new PaginationHelper(values, 1);
    }

    @Test
    public void testCountPerPageCantBeLessThenZero() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Count per page is invalid, should be greater then 0");
        new PaginationHelper(testValues, -1);
    }

    @Test
    public void testCountPerPageCantBeZero() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Count per page is invalid, should be greater then 0");
        new PaginationHelper(testValues, 0);
    }

    // TESTS FOR THE CLASS API METHODS

    // Tests for int pageCount() API

    @Test
    public void testPageCount_SeveralPages() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("There should be 2 pages in 6-item array broken on pages with 4 items count",
                2, helper.pageCount());
    }

    @Test
    public void testPageCount_OnePage() {
        PaginationHelper helper = new PaginationHelper(testValuesOneItem, 4);
        Assert.assertEquals("There should be 1 page in 1 item array broken on pages with 4 items count",
                1, helper.pageCount());
    }

    // Tests for int itemCount() API

    @Test
    public void testItemCount_OneItem() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("There should be 6 items as an array that was used for class setup have 6 item",
                6, helper.itemCount());
    }

    @Test
    public void testItemCount_MoreThenOneItem() {
        PaginationHelper helper = new PaginationHelper(testValuesOneItem, 4);
        Assert.assertEquals("There should be 1 item as an array that was used for class setup have 1 item",
                1, helper.itemCount());
    }

    // Tests for int pageItemCount(int pageIndex) API

    @Test
    public void testPageItemCount_FirstPage() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("There should be 4 items on page 0 for 6-item array broken into pages with 4 items",
                4, helper.pageItemCount(0));
    }

    @Test
    public void testPageItemCount_LastPageWithIncompleteNumberOfItems() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("There should be 2 items on page 1 for 6-item array broken into pages with 4 items",
                2, helper.pageItemCount(1));
    }

    @Test
    public void testPageItemCount_LastPageWithCompleteNumberOfItems() {
        PaginationHelper helper = new PaginationHelper(testValues, 3);
        Assert.assertEquals("There should be 3 items on page 1 for 6-item array broken into pages with 3 items",
                3, helper.pageItemCount(1));
    }

    @Test
    public void testPageItemCount_PageIndexOutOfRange() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("There should be no page with index 2 for 6-item array broken into pages with 4 items",
                -1, helper.pageItemCount(2));
    }

    // Tests for int pageIndex(int itemIndex) API

    @Test
    public void testPageIndex_FirstPageFirstItem() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("Item with index 0 should be on page with idx 0",
                0, helper.pageIndex(0));
    }

    @Test
    public void testPageIndex_FirstPageLastItem() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("Item with index 3 should be on page with idx 0 for 6 item array broken to 4 items per page",
                0, helper.pageIndex(3));
    }

    @Test
    public void testPageIndex_SecondPageFirstItem() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("Item with index 4 should be on page with idx 1 for 6 item array broken to 4 items per page",
                1, helper.pageIndex(4));
    }

    @Test
    public void testPageIndex_LastPageLastItemForIncompleteLastPage() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("Item with index 5 should be on page with idx 1 for 6 item array broken to 4 items per page",
                1, helper.pageIndex(5));
    }

    @Test
    public void testPageIndex_LastPageLastItemForCompleteLastPage() {
        PaginationHelper helper = new PaginationHelper(testValues, 3);
        Assert.assertEquals("Item with index 5 should be on page with idx 1 for 6 item array broken to 3 items per page",
                1, helper.pageIndex(5));
    }

    @Test
    public void testPageIndex_IndexOutOfRange() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("There should be no page for item with index 6 for 6-item array broken into pages with 4 items",
                -1, helper.pageIndex(6));
    }

    @Test
    public void testPageIndex_NegativeValueIndex() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertEquals("There should be no page for negative index argument and -1 should be returned",
                -1, helper.pageIndex(-2));
    }

    // Tests for Object[] getItemsForPageIndex(int pageIndex) API

    @Test
    public void testGetItemsForPageIndex_FirstPage() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertArrayEquals("Items {'a', 'b', 'c', 'd'} should be on the first page for defined array of 6 items broken into pages with 4 items count",
                new Object[]{'a', 'b', 'c', 'd'}, helper.getItemsForPageIndex(0));
    }

    @Test
    public void testGetItemsForPageIndex_LastPageForIncompleteLastPage() {
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        Assert.assertArrayEquals("Items {'e', 'f'} should be on the second page for defined array of 6 items broken into pages with 4 items count",
                new Object[]{'e', 'f'}, helper.getItemsForPageIndex(1));
    }

    @Test
    public void testGetItemsForPageIndex_LastPageForCompleteLastPage() {
        PaginationHelper helper = new PaginationHelper(testValues, 3);
        Assert.assertArrayEquals("Items {'d', 'e', 'f'} should be on the second page for defined array of 6 items broken into pages with 3 items count",
                new Object[]{'d', 'e', 'f'}, helper.getItemsForPageIndex(1));
    }

    @Test
    public void testGetItemsForPageIndex_IndexOutOfRange() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Page doesn't exist");
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        helper.getItemsForPageIndex(2);
    }

    @Test
    public void testGetItemsForPageIndex_NegativeValueIndex() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("Page doesn't exist");
        PaginationHelper helper = new PaginationHelper(testValues, 4);
        helper.getItemsForPageIndex(2);
    }

}