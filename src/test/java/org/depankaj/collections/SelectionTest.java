package org.depankaj.collections;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class SelectionTest {

    @Test
    public void testSelectingLargest() {
        Optional<Integer> first = new Selection().selectNthLargest(Lists.newArrayList(3, 1, 5, 10, -1, 10), 1);
        assertEquals(Optional.of(10), first);
    }

    @Test
    public void testSelecting2ndLargest() {
        Optional<Integer> second = new Selection().selectNthLargest(Lists.newArrayList(3, 1, 5, 10, -1, 10), 2);
        assertEquals(Optional.of(10), second);
    }

    @Test
    public void testSelectingSmallest() {
        Optional<Integer> smallest = new Selection().selectNthLargest(Lists.newArrayList(3, 1, 5, 10, -1, 10), 6);
        assertEquals(Optional.of(-1), smallest);
    }

    @Test
    public void testEdgeConditions() {
        assertEquals(Optional.empty(), new Selection().selectNthLargest(Lists.newArrayList(), 0));
        assertEquals(Optional.empty(), new Selection().selectNthLargest(null, 0));
    }

}