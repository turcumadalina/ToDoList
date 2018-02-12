package com.minimalToDo.screens;


import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

/**
 * Created by madalina.turcu on 2/7/18.
 */

public class AddNewItem {
    public static void clickEditText() throws Exception {
        onView( withId( R.id.userToDoEditText)).perform(click());
    }
    public static void enterText(String text ) throws Exception {
        onView( withId( R.id.userToDoEditText)).perform(typeText(text));
    }
    public static void checkRemindMe() throws Exception {
        onView(allOf(withText(R.string.remind_me), isCompletelyDisplayed())).check(matches(isDisplayed()));
    }
    public static void clickRemindMe() throws Exception {
        onView( withId( R.id.toDoHasDateSwitchCompat)).perform(click());
    }
    public static void clickCreate() throws Exception {
        onView( withId( R.id.makeToDoFloatingActionButton)).perform(click());
    }




}

