package com.minimalToDo.tests;

import android.support.test.espresso.ViewInteraction;

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
import static com.minimalToDo.constants.Strings.TASK1;
import static com.minimalToDo.constants.Strings.TASK3;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by ioana.hoaghia on 2/13/2018.
 */

public class RenameItem extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)

    public void testAddItemsWithoutReminderAndRename() throws Exception {

        ViewInteraction firstItemAdded = onView(allOf(withId(R.id.listItemLinearLayout), Helpers.childAtPosition(withId(R.id.toDoRecyclerView), 0)));

        AddNewItem.addItemWithoutReminder(TASK3);
        firstItemAdded.check(matches(isDisplayed()));
        firstItemAdded.perform(click());
        onView(withId(R.id.userToDoEditText)).perform(replaceText(TASK1));
        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());
        onView(withId(R.id.toDoListItemTextview)).check(matches(withText(TASK1)));

    }

}