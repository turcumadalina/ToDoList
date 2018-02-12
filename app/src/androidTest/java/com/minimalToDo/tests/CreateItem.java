package com.minimalToDo.tests;

import com.minimalToDo.constants.Timeouts;
import com.minimalToDo.screens.AddNewItem;
import com.minimalToDo.screens.Home;
import com.minimalToDo.screens.ToDoList;

import org.junit.Test;

/**
 * Created by valentin.boca on 2/9/2018.
 */

public class CreateItem extends EspressoTestBase{
    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testAddNewItem() throws Exception{
        Home.clickFAB();
        AddNewItem.clickEditText();
        AddNewItem.enterText( "fisier1" );
        AddNewItem.checkRemindMe();
        AddNewItem.clickCreate();
        ToDoList.checkAddedItem( "Fisier1" );
    }

    }
