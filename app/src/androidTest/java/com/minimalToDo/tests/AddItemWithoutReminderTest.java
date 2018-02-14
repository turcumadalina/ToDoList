package com.minimalToDo.tests;

import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.screens.AddNewItem;

import org.junit.Test;

import static com.minimalToDo.constants.Strings.TASK1;


/**
 * Created by ioana.hoaghia on 2/9/2018.
 */

public class AddItemWithoutReminderTest extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)

    public void testAddItemsWithoutReminder() throws Exception {
        AddNewItem.addItemWithoutReminder(TASK1);
    }

}