package com.minimalToDo.tests;

import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.screens.AddNewItem;
import com.minimalToDo.screens.Home;

import org.junit.Test;

/**
 * Created by valentin.boca on 2/9/2018.
 */

public class CreateItem extends EspressoTestBase {
    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testAddNewItemWithoutReminder() throws Exception {
        AddNewItem.createNewItem("Fisier1");
        Helpers.clickOn(R.id.makeToDoFloatingActionButton);
        Helpers.isItemDisplayed("Fisier1");
        Home.deleteItemsAndCheckIfYouDontHaveAnyTodosTextIsDisplayed();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testAddNewItemWithReminder() throws Exception {
        AddNewItem.createNewItem("Fisier2");
        Helpers.clickOn(R.id.toDoHasDateSwitchCompat);
        Helpers.clickOn(R.id.newTodoDateEditText);
        Helpers.clickOn(R.id.ok);
        Helpers.clickOn(R.id.makeToDoFloatingActionButton);
        Helpers.isItemDisplayed("Fisier2");
        Home.deleteItemsAndCheckIfYouDontHaveAnyTodosTextIsDisplayed();
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testRenameItem() throws Exception {
        AddNewItem.createNewItem("Fisier2");
        Helpers.clickOn(R.id.makeToDoFloatingActionButton);
        AddNewItem.clickItem("Fisier2");
        AddNewItem.renameItem("Fisier3");
        Helpers.clickOn(R.id.makeToDoFloatingActionButton);
        Helpers.isItemDisplayed("Fisier3");
    }
}
