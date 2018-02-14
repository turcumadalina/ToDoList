package com.minimalToDo.tests;

import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.screens.AddNewItem;
import com.minimalToDo.screens.Home;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.minimalToDo.constants.Strings.task2;

/**
 * Created by ioana.hoaghia on 2/9/2018.
 */

public class AddItemWithReminderTest extends EspressoTestBase  {

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testAddItemsWithReminderDefaultDate() throws Exception {
        AddNewItem.addItemWithReminder(task2);
        //Check that the added item has reminder
       onView(withId(R.id.todoListItemTimeTextView)).check(matches(isDisplayed()));
    }
}
