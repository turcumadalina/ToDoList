package com.minimalToDo.tests;

import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.constants.Strings;
import com.minimalToDo.screens.AddNewItem;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.minimalToDo.constants.Strings.task1;


/**
 * Created by ioana.hoaghia on 2/9/2018.
 */

public class AddItemWithoutReminderTest extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)

    public void testAddItemsWithoutReminder() throws Exception {
        AddNewItem.addItemWithoutReminder(task1);
    }

}
