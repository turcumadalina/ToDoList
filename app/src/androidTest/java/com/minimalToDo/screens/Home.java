package com.minimalToDo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.tests.Helpers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class Home {

    private static boolean isYouDontHaveAnyTodosTextDisplayed() throws Exception {
        return Helpers.checkIfUIObjectIsVisible(allOf(withText(R.string.no_to_dos), isCompletelyDisplayed()), 10);
    }

    private static void deleteItems() throws Exception {
        int childCount = Helpers.getRecyclerViewChildCount(withId(R.id.toDoRecyclerView));

        for (int i = 0; i < childCount; i++) {
            onView(allOf(withId(R.id.listItemLinearLayout), Helpers.childAtPosition(withId(R.id.toDoRecyclerView), i))).check(matches(isDisplayed()));
            onView(allOf(withId(R.id.listItemLinearLayout), Helpers.childAtPosition(withId(R.id.toDoRecyclerView), i))).perform(swipeLeft());
        }
    }

    public static void deleteItemsAndCheckIfYouDontHaveAnyTodosTextIsDisplayed() throws Exception {
        deleteItems();
        isYouDontHaveAnyTodosTextDisplayed();
    }

}