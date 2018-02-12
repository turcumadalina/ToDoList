package com.minimalToDo.tests;

import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.screens.AddNewItem;
import com.minimalToDo.screens.Home;
import com.minimalToDo.screens.ToDoList;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by valentin.boca on 2/9/2018.
 */

public class CreateItem extends EspressoTestBase {
    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testAddNewItemWithoutReminder() throws Exception {
        AddNewItem.createNewItem( "fisier1" );
        AddNewItem.clickCreate();
        Helpers.checkIfUIObjectIsVisible( allOf( withText( "Fisier1" ), isCompletelyDisplayed() ), 3 );
        Home.deleteItemsAndCheckIfYouDontHaveAnyTodosTextIsDisplayed();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testAddNewItemWithReminder() throws Exception {
        AddNewItem.createNewItem( "fisier2" );
        AddNewItem.clickRemindMe();
        AddNewItem.clickDate();
        AddNewItem.clickDateOK();
        AddNewItem.clickCreate();
        Helpers.checkIfUIObjectIsVisible( allOf( withText( "Fisier2" ), isCompletelyDisplayed() ), 3 );
        Home.deleteItemsAndCheckIfYouDontHaveAnyTodosTextIsDisplayed();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testRenameItem() throws Exception {
        AddNewItem.createNewItem( "Fisier2" );
        AddNewItem.clickCreate();
        AddNewItem.clickItem( "Fisier2" );
        AddNewItem.renameItem( "Fisier3" );
        Helpers.checkIfUIObjectIsVisible( allOf( withText( "Fisier3" ), isCompletelyDisplayed() ), 3 );
    }
}
