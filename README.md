# pagination-handler

Initial requirements <br /><br />
The class is designed to take in an array of values and an integer
indicating how many items will be allowed per each page.
- The types of values contained within the collection/array are not
  relevant.
- The following are some examples of how this class is used: <br /><br />
  
  PaginationHelper helper = new PaginationHelper(new Object[]{'a','b','c','d','e','f'}, 4);
  <br /><br />
  helper.pageCount() # should == 2 <br />
  helper.itemCount() # should == 6 <br />
  helper.pageItemCount(0) # should == 4 <br />
  helper.pageItemCount(1) # last page - should == 2 <br />
  helper.pageItemCount(2) # should == -1 since the page is invalid <br />

// page_index takes an item index and returns the page that it
  belongs on <br />

  helper.pageIndex(5) # should == 1 (zero based index) <br />
  helper.pageIndex(2) # should == 0 <br />
  helper.pageIndex(20) # should == -1 <br />
  helper.pageIndex(-10) # should == -1 because negative indexes are
  invalid <br />
  
  Added requirements <br />

  There is a method to return all items for a specified by index page:  <br />
  Object[] getItemsForPageIndex(int pageIndex) <br />
  helper.getItemsForPageIndex(1); should return an array for objects containing 'e' and 'f' <br />
  Arrays.toString(helper.getItemsForPageIndex(1)) => ('e', 'f') <br />
  <br />
  Initial parameters requirements: <br />
  An exception is thrown when an empty array of items is passed to the helper class;<br />
  An exception is thrown when an integer parameter
  indicating how many items will be allowed per each page is less than 0.
   