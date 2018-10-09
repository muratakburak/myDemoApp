package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public static boolean check( String[] a , String[] b ){
        if( a.length != b.length ) return false ;
        for( int i=0 ; i<a.length ; i++ ) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }
        return true ;
    }
    public void testSimple() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList( 1 , 2 , 3 , 4 ));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        String[] answers = {"1","2","5","6","7"} ;
        assertTrue(check( answers , new App().computeMyResult(arr1, arr2, 2 , 3)));
    }
    public void testAnotherSimple() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList( 131 , 221 , 34 , 41 ));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList( 415, 61, 73, 85));
        String[] answers = {"131","221","415","61","73"} ;
        assertTrue(check( answers , new App().computeMyResult(arr1, arr2, 2 , 3)));
    }
    public void testLengthsAreLower() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList( 7 , 1 ));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(12, 4, 5));
        String[] answers = {"7","1","12","4","5" } ;
        assertTrue(check( answers , new App().computeMyResult(arr1, arr2, 12 , 132)));
    }
    public void testAnotherLengthsAreLower() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList( 4542 , 3453 , 3246, 2342 ));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList( 2341, 474, 9567 , 467));
        String[] answers = {"4542","3453","3246","2342","2341" , "474" , "9567" , "467" } ;
        assertTrue(check( answers , new App().computeMyResult(arr1, arr2, 12423 , 1322)));
    }
    public void testZero() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList( 41 , 123 ));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList( 1234 , 414 , 2325 , 23 , 2));
        String[] answers = {"1234","414","2325","23","2" } ;
        assertTrue(check( answers , new App().computeMyResult(arr1, arr2, 0 , 7)));
    }

    //public void testFound() {
     //   ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    //    assertTrue(new App().search(array, 4));
    //}

    //public void testNotFound() {
    //    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    //    assertFalse(new App().search(array, 5));
    //}

    //public void testEmptyArray() {
    //    ArrayList<Integer> array = new ArrayList<>();
    //    assertFalse(new App().search(array, 1));
    //}

    //public void testNull() {
    //    assertFalse(new App().search(null, 1));
    //}

}
