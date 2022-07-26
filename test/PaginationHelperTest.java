import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class PaginationHelperTest {

    Object[] values = new Object[]{'a', 'b', 'c', 'd', 'e', 'f'};

//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        values = null;
//    }




    @Test
    public void testItemsFitToOnePageWhenItemsOnPageCountEqualToNumberOfItems() {
        Object[] values = new Object[]{};
        PaginationHelper helper = new PaginationHelper(values, 1);
    }

    @Test
    public void testItemsFitToOnePageWhenItemsOnPageCountLessThenNumberOfItems() {
        Object[] values = new Object[]{};
        PaginationHelper helper = new PaginationHelper(values, 1);
    }

    @Test
    public void testItemsFitToOnePageWhenItemsOnPageCountLessThenNumberOfItems1() {
        Object[] values = new Object[]{};
        PaginationHelper helper = new PaginationHelper(values, 1);
    }


    // NEGATIVE TESTING
    @Test
    public void testEmptyItemsShouldNotBeAccepted() {
        Object[] values = new Object[]{};
        PaginationHelper helper = new PaginationHelper(values, 1);
    }

    @Test
    public void testCountPerPageCantBeLessThenZero() {
        PaginationHelper helper = new PaginationHelper(values, -1);
    }

    @Test
    public void testCountPerPageCantBeZero() {
        PaginationHelper helper = new PaginationHelper(values, 0);
    }



    @Test
    public void pageCount() {
        Object[] values = new Object[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'l', 'n', 'o', 'p'};
    }

    @Test
    public void itemCount() {
    }

    @Test
    public void pageItemCount() {
    }

    @Test
    public void pageIndex() {
    }

    @Test
    public void getItemsForPageIndex() {
    }

    @Test
    public void testPageCount() {
    }

    @Test
    public void testItemCount() {
    }

    @Test
    public void testPageItemCount() {
    }

    @Test
    public void testPageIndex() {
    }

    @Test
    public void testGetItemsForPageIndex() {
    }
}