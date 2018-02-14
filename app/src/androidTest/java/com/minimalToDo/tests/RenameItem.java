package com.minimalToDo.tests;

import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.screens.AddNewItem;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.minimalToDo.constants.Strings.task1;
import static com.minimalToDo.constants.Strings.task3;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by ioana.hoaghia on 2/13/2018.
 */

public class RenameItem extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)

    public void testAddItemsWithoutReminderAndRename() throws Exception {
        AddNewItem.addItemWithoutReminder(task3);
        onView(allOf(withId(R.id.listItemLinearLayout), Helpers.childAtPosition(withId(R.id.toDoRecyclerView), 0))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.listItemLinearLayout), Helpers.childAtPosition(withId(R.id.toDoRecyclerView), 0))).perform(click());
        onView(withId(R.id.userToDoEditText)).perform(replaceText(task1));
        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());
        onView(withId(R.id.toDoListItemTextview)).check(matches(withText(task1)));

    }

}
