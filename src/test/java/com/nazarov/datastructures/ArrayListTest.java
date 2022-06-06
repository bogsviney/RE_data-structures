package com.nazarov.datastructures;

import com.nazarov.datastructures.List.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    private ArrayList<Integer> list = new ArrayList();

    @BeforeEach
    void fillListWithData() {
        list.add(1);
        list.add(22);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(22);
        list.add(22);
    }

    @Test
    @DisplayName("Test: Add To List And Size Changing Check")
    void addToListAndSizeChangingTest() {
        assertEquals(7, list.size());
    }

    @Test
    @DisplayName("Test: Add To List By Index")
    void addToListByIndexTest() {
        list.add(5, 2022);
        assertEquals(2022, list.get(5));
    }

    @Test
    @DisplayName("Test: Get Element From The List")
    void getElementFromListTest() {
        assertEquals(3, list.get(2));
    }

    @Test
    @DisplayName("Test: Clear And Checking Is List Empty")
    void clearAndCheckingIsListEmptyTest() {
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Test: Throw Exception If Add Index Less Then Zero")
    void ThrowExceptionIfAddIndexLessThenZero() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2022, -1);
        });
    }

    @Test
    @DisplayName("Test: Throw Exception If Add Index Greater Then Size")
    void ThrowExceptionIfAddIndexGreaterThenSize() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2022, list.size() + 1);
        });
    }

    @Test
    @DisplayName("Test: Set Element Value By Index")
    void setElementValueByIndexTest() {
        list.set(5, 2022);
        assertEquals(2022, list.get(5));
    }

    @Test
    @DisplayName("Test: is Element Contains In List?")
    void isElementContainsInListTest() {
        assertTrue(list.contains(5));
    }

    @Test
    @DisplayName("Test: check IndexOf Returns Correct Index")
    void checkIndexOfReturnsCorrectIndexTest() {
        assertEquals(-1, list.indexOf(770001));
        assertEquals(1, list.indexOf(22));
    }

    @Test
    @DisplayName("Test: check LastIndexOf Returns Correct Index")
    void checkLastIndexOfReturnsCorrectIndexTest() {
        assertEquals(-1, list.lastIndexOf(770001));
        assertEquals(6, list.lastIndexOf(22));
    }

    @Test
    @DisplayName("Test: Get First And Get Last")
    void getFirstAndGetLastTest(){
        assertEquals(1, list.getFirst());
        assertEquals(22, list.getLast());
    }

    @Test
    @DisplayName("Test: Remove Element And Check Size")
    void removeElementAndCheckSizeTest(){
        list.remove(0);
        list.remove(3);
        assertEquals(5,list.size());
    }

    @Test
    @DisplayName("Test: To String")
    void toStringTest(){
        assertEquals("[1, 22, 3, 4, 5, 22, 22]",list.toString());
    }

//    @Test
//    @DisplayName("Test: ")
}
