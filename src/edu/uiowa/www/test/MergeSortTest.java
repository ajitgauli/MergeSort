package edu.uiowa.www.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import edu.uiowa.www.MergeSort;
import edu.uiowa.www.NaturalOrderComparator;

public class MergeSortTest {

  private String[] codes; 
  private String[] ans;

  @Before
  public void setUp() throws Exception {
	  codes = new String[] { "F10", "F1", "F9", "F7", "F11", "F12","F15","T3","T6","T5","F3","T1","F5","T2","F2","F8","T8","T9","T7","F14","F17","I1","F16","F13","F6","F4" };
	  ans = new String[]{"F1", "F2", "F3", "F4" , "F5", "F6", "F7", "F8", "F9", "F10", "F11", "F12", "F13", "F14", "F15", "F16", "F17", "I1", "T1", "T2", "T3", "T5", "T6", "T7", "T8", "T9"};
  }

  @Test
  public void testMergeSort() {    

    MergeSort sorter = new MergeSort();
    long startTime = System.currentTimeMillis();
    sorter.sort(codes);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("Merge sort");
    System.out.println("Elapsed Time: " + elapsedTime+" ms");
    print(codes);
    
    for (int i = 0; i < codes.length - 1; i++) {
        if (!codes[i].equals(ans[i])) {
          fail("Merge Sort failed");
        }
      }
    assertTrue("Merge Sort passed",true);

  }

  //Alternatively we can use java collections API to sort, passing in NaturalOrderComparator

  @Test
  public void testStandardSort() {	
    long startTime = System.currentTimeMillis();
    Arrays.sort(codes, new NaturalOrderComparator());
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println("Collections API sort");
    System.out.println("Elapsed Time: " + elapsedTime+"ms");
    print(codes);
    for (int i = 0; i < codes.length - 1; i++) {
      if (!codes[i].equals(ans[i])) {
        fail("Collections sort failed");
      }
    }
    assertTrue("Collections sort passed",true);
  }
  
  private void print(String[] arr){
	  System.out.println("Sorted List:");
	  System.out.print("[");
	    for(int i=0;i<arr.length-1;i++){
	    	System.out.print(arr[i]+", ");
	    }
	    System.out.print(arr[arr.length-1]);
	    System.out.print("]");  
	    System.out.print("\n\n");  
  }

} 