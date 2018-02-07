package com.minimalToDo.tests;

import android.support.test.espresso.Espresso;
import android.support.test.filters.MediumTest;
import com.example.avjindersinghsekhon.minimaltodo.R;
import com.minimalToDo.constants.Timeouts;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by madalina.turcu on 2/7/18.
 */
@MediumTest
public class Demo extends EspressoTestBase {

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void fistTest2() throws Exception {
        onView(allOf(withText("Minimagfgl"), isCompletelyDisplayed())).check(matches(isDisplayed()));
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_SHORT)
    public void fistTest4() throws Exception {
        onView(allOf(withText("Tujtur"), isCompletelyDisplayed())).check(matches(isDisplayed()));
    }

    @Test(timeout = Timeouts.TEST_TIMEOUT_MEDIUM)
    public void fistTest() throws Exception {
        onView(allOf(withText(R.string.app_name), isCompletelyDisplayed())).check(matches(isDisplayed()));

        onView(allOf(withText("Tujtur"), isCompletelyDisplayed())).perform(click());

        Espresso.pressBack();

        onView(allOf(withText(R.string.remind_me), isCompletelyDisplayed())).check(matches(isDisplayed()));
    }
}