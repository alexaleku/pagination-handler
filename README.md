Documentation

The class is designed to take in an array of values and an integer
indicating how many items will be allowed per each page.

PaginationHelper Constructor details

    PaginationHelper Constructor details
    public PaginationHelper(java.lang.Object[] values,
    int countPerPage) throws java.lang.IllegalArgumentException
      Parameters:
        values - An array of values that contain objects of any type, should be non-empty
        countPerPage - Defines how many items per page should be shown, should be > 0
        Throws: java.lang.IllegalArgumentException - when initial parameters don't meet the outlined requirements

PaginationHelper API method details

    public int pageCount()
      Returns: total number of pages

    public int itemCount()
      Returns: total number of items

    public int pageItemCount(int pageIndex)
       Parameters: pageIndex page index
      Returns: number of items on the page

    public int pageIndex(int itemIndex)
      Parameters: itemIndex - item index in the initial array passed as a parameter to the class constructor
      Returns: page index of the page where the item should be located

    public java.lang.Object[] getItemsForPageIndex(int pageIndex) throws java.lang.IllegalArgumentException
      Parameters: pageIndex - index of the page to get items that this page contains
      Returns: Object[] an array of items that the page contains
      Throws: java.lang.IllegalArgumentException - thrown when provided page index is out of range

<h4>Initial requirements</h4>
- The types of values contained within the collection/array are not
  relevant.
- The following are some examples of how this class is used: <br /><br />

  PaginationHelper helper = new PaginationHelper(new Object[]{'a','b','c','d','e','f'}, 4);
  <br /><br />
  helper.pageCount() # should == 2 <br />
  helper.itemCount() # should == 6 <br />
  <br />
  helper.pageItemCount(0) # should == 4 <br />
  helper.pageItemCount(1) # last page - should == 2 <br />
  helper.pageItemCount(2) # should == -1 since the page is invalid <br />
  helper.pageIndex(5) # should == 1 (zero based index) <br />
  helper.pageIndex(2) # should == 0 <br />
  helper.pageIndex(20) # should == -1 <br />
  helper.pageIndex(-10) # should == -1 because negative indexes are invalid <br />

<h4> Added requirements </h4>

Constructor arguments validation requirements: <br />
An exception is thrown when an empty array of items is passed to the helper class;<br />
An exception is thrown when an integer parameter indicating how many items will be allowed per each page is less or equals to 0.

Added Functional requirements
A method to return all items for a specified by index page:  <br /><br />
Object[] getItemsForPageIndex(int pageIndex) <br />

Usage Example: <br />
helper.getItemsForPageIndex(1);  => should return an array for objects containing elements for the page of given index <br />
e.g. Arrays.toString(helper.getItemsForPageIndex(1)) => [e, f] <br />
<br />
