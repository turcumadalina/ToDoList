package com.minimalToDo.tests;

import android.support.test.uiautomator.UiObject;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.screens.Home;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MadalinaTests extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testAddAndDeleteItems() throws Exception {
        // TODO: Add a function for this functionality
        onView(withId(R.id.addToDoItemFAB)).perform(click());

        onView(withId(R.id.userToDoEditText)).perform(typeText("a"));

        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());

        onView(withId(R.id.addToDoItemFAB)).perform(click());

        onView(withId(R.id.userToDoEditText)).perform(typeText("b"));

        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());

        onView(withId(R.id.addToDoItemFAB)).perform(click());

        onView(withId(R.id.userToDoEditText)).perform(typeText("c"));

        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());

        Home.deleteItemsAndCheckIfYouDontHaveAnyTodosTextIsDisplayed();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testCheckbox() throws Exception {
        onView(withContentDescription("More options")).perform(click());

        onView(withText(R.string.action_settings)).perform(click());

        UiObject checkbox = Helpers.getUiObjectByResourceId("android", "checkbox");

        checkbox.click();
    }
}
