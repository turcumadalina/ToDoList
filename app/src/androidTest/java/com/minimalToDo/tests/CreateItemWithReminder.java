package com.minimalToDo.tests;

import com.example.avjindersinghsekhon.minimaltodo.ToDoItem;
import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.screens.AddNewItem;
import com.minimalToDo.screens.Home;
import com.minimalToDo.screens.ToDoList;

import org.junit.Test;

/**
 * Created by valentin.boca on 2/12/2018.
 */

public class CreateItemWithReminder extends EspressoTestBase{

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testAddNewItemWithoutReminder() throws Exception{
        Home.clickFAB();
        AddNewItem.clickEditText();
        AddNewItem.enterText( "fisier2" );
        AddNewItem.clickRemindMe();
        AddNewItem.clickCreate();
        ToDoList.checkAddedItemWithReminder( "Fisier2" );

    }
}
