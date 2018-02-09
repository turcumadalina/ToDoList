package com.minimalToDo.tests;

import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.screens.Home;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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
}
