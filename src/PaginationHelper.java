/**
 * PaginationHelper class used to implement UI-like pagination functionality on java API level
 */
public class PaginationHelper {


    private final Object[] values;
    private final int countPerPage;

    /**
     * @param values       An array of values that contain objects of any type, should be non-empty
     * @param countPerPage Defines how many items per page should be shown, should be > 0
     * @throws IllegalArgumentException when initial parameters don't meet the outlined requirements
     */
    public PaginationHelper(Object[] values, int countPerPage) throws IllegalArgumentException {
        if (countPerPage <= 0) {
            throw new IllegalArgumentException("Count per page is invalid, should be greater then 0");
        }
        if (values.length == 0) {
            throw new IllegalArgumentException("Empty array, please add some items");
        }
        this.values = values;
        this.countPerPage = countPerPage;
    }

    /**
     * @return total number of pages
     */
    public int pageCount() {
        if (isLastPageIncomplete()) {
            return values.length / countPerPage + 1;
        } else {
            return values.length / countPerPage;
        }
    }

    /**
     * @return total number of items
     */
    public int itemCount() {
        return values.length;
    }

    /**
     * @param pageIndex page index
     * @return number of items on the page
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex > lastPageIndex()) {
            return -1;
        } else if (isLastPageIncomplete() && lastPageIndex() == pageIndex) {
            return values.length % countPerPage;
        } else {
            return countPerPage;
        }
    }


    /**
     * @param itemIndex item index in the initial array passed as a parameter to the class constructor
     * @return a page index of the page where the item should be located
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= values.length) {
            return -1;
        } else {
            return itemIndex / countPerPage;
        }
    }


    /**
     * @param pageIndex index of the page to get items that this page contains
     * @return Object[] an array of items that the page contains
     * @throws IllegalArgumentException thrown when provided page index is out of range
     */
    public Object[] getItemsForPageIndex(int pageIndex) throws IllegalArgumentException {
        if (pageIndex < 0 || pageIndex > lastPageIndex()) {
            throw new IllegalArgumentException("Page doesn't exist");
        } else {
            int pageFirstItemIndex = pageIndex * countPerPage;
            int pageItemCount = pageItemCount(pageIndex);
            Object[] pageItems = new Object[pageItemCount];
            for (int i = 0; i < pageItemCount; i++) {
                pageItems[i] = values[pageFirstItemIndex + i];
            }
            return pageItems;
        }
    }

    // Helper methods

    /**
     * @return return last page index
     */
    private int lastPageIndex() {
        return pageCount() - 1;
    }

    /**
     * @return true if last page doesn't have the amount of items that all other pages, false otherwise
     */
    private boolean isLastPageIncomplete() {
        return values.length % countPerPage != 0;
    }
}
