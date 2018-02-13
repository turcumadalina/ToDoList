package com.minimalToDo.screens;

import com.example.avjindersinghsekhon.minimaltodo.R;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by madalina.turcu on 2/7/18.
 */

public class AddNewItem {
    public static void createNewItem(String text) throws Exception {
        onView( withId( R.id.addToDoItemFAB ) ).perform( click() );
        onView( withId( R.id.userToDoEditText ) ).perform( click() );
        onView( withId( R.id.userToDoEditText ) ).perform( typeText( text ) );
    }

    public static void renameItem(String text) throws Exception {
        onView( withId( R.id.userToDoEditText ) ).perform( replaceText( text ) );
    }

    public static void clickItem(String text) throws Exception {
        onView( withText( text ) ).perform( click() );
    }
}