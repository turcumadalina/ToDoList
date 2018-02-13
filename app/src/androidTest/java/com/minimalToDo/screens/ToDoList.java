package com.minimalToDo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Strings;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by madalina.turcu on 2/7/18.
 */

public class ToDoList {
    public static void clickMoreOptions() throws Exception{
        onView(withContentDescription( Strings.MORE_OPTIONS)).perform(click());
    }
    public static void checkAddedItem(String text ) throws Exception {
        onView(allOf(withText(text), isCompletelyDisplayed())).check(matches(isDisplayed()));
            }
    public static void checkAddedItemWithReminder(String text ) throws Exception {
        onView(allOf(withText(text), isCompletelyDisplayed())).check(matches(isDisplayed()));
        onView(allOf(withId( R.id.todoListItemTimeTextView), isCompletelyDisplayed())).check(matches(isDisplayed()));
    }
}
