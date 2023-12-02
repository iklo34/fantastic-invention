package com.iyhnica.LESS3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {
Task task;
    @Before
    public void setUp() throws Exception {
        task =new Task();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findMedianSortedArrays() {
        int[] a= {1,2,3};
        int[] b ={4,5,6};
        double actual = task.findMedianSortedArrays(a,b);
        double exp =3.5;
        assertEquals(exp,actual,1);
    }

    @Test
    public void twoSum() {
        int[] a= {1,2,3};
        int[] actual = task.twoSum(a,5);
        int[] exp = {1,2};
        assertArrayEquals(exp,actual);
    }

    @Test
    public void isPalindrome() {
        int x=343;
        boolean actual=task.isPalindrome(x);
        boolean exp= true;
        assertEquals(exp,actual);
    }
}