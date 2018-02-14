package com.minimalToDo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;



/**
 * Created by madalina.turcu on 2/7/18.
 */

public class AddNewItem {

    public static void addItemWithoutReminder(String string) throws Exception {
        // Tap 'Add Item'
        onView(withId(R.id.addToDoItemFAB)).perform(click());
        // Input item text
        onView(withId(R.id.userToDoEditText)).perform(typeText(string));
        // Tap 'Ok/Add'
        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());
    }

    public static void addItemWithReminder(String string) throws Exception {
        // Tap 'Add Item'
        onView(withId(R.id.addToDoItemFAB)).perform(click());
        // Input item text
        onView(withId(R.id.userToDoEditText)).perform(typeText(string));
        // Enable the 'Remind Me' toggle, date remains the default one
        onView(withId(R.id.toDoHasDateSwitchCompat)).perform(click());
        // Tap 'Ok/Add'
        onView(withId(R.id.makeToDoFloatingActionButton)).perform(click());

    }
}
