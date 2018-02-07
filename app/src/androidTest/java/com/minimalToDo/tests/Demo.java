package com.minimalToDo.tests;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.MediumTest;
import android.widget.ImageView;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Timeouts;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasSibling;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by madalina.turcu on 2/7/18.
 */
@MediumTest
public class Demo extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testDeleteItem() throws Exception {
        onView(allOf(withText("Item"), isCompletelyDisplayed())).check(matches(isDisplayed()));

        onView(allOf(withText("Item"), isCompletelyDisplayed())).perform(swipeLeft());
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void testAppNameClickItemAndCheckRemindMe() throws Exception {
        onView(allOf(withText(R.string.app_name), isCompletelyDisplayed())).check(matches(isDisplayed()));

        onView(allOf(withText("Test"), isCompletelyDisplayed())).perform(click());

        Espresso.pressBack();

        onView(allOf(withText(R.string.remind_me), isCompletelyDisplayed())).check(matches(isDisplayed()));
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void testMenuButton() throws Exception {
        ViewInteraction menu = onView(allOf(is(instanceOf(ImageView.class)), isCompletelyDisplayed(), withParent(hasSibling(withText(R.string.app_name)))));

        menu.check(matches(isDisplayed()));
        menu.perform(click());
    }
}