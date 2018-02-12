package com.minimalToDo.screens;


import com.example.avjindersinghsekhon.minimaltodo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
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
    public static void createNewItem(String text) throws Exception {
        onView( withId( R.id.addToDoItemFAB ) ).perform( click() );
        onView( withId( R.id.userToDoEditText ) ).perform( click() );
        onView( withId( R.id.userToDoEditText ) ).perform( typeText( text ) );
    }

    public static void clickRemindMe() throws Exception {
        onView( withId( R.id.toDoHasDateSwitchCompat ) ).perform( click() );
    }

    public static void clickDate() throws Exception {
        onView( withId( R.id.newTodoDateEditText ) ).perform( click() );
    }

    public static void clickCreate() throws Exception {
        onView( withId( R.id.makeToDoFloatingActionButton ) ).perform( click() );
    }

    public static void renameItem(String text) throws Exception {
        onView( withId( R.id.userToDoEditText ) ).perform( replaceText( text ) );
    }

    public static void clickItem(String text) throws Exception {
        onView( withText( text ) ).perform( click() );
    }

    public static void clickDateOK() throws Exception {
        onView( withId( R.id.ok ) ).perform( click() );
    }


}

