package com.minimalToDo.tests;

import android.support.test.espresso.AppNotIdleException;
import android.support.test.espresso.NoMatchingRootException;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiSelector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import com.minimalToDo.constants.Time;
import junit.framework.AssertionFailedError;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class Helpers extends EspressoTestBase {

    public static boolean isItemDisplayed(String text) throws Exception {
        return Helpers.checkIfUIObjectIsVisible(allOf(withText("text"), isCompletelyDisplayed()), 3);
    }
    public static boolean isDateDisplayed(int date1) throws Exception {
        return Helpers.checkIfUIObjectIsVisible(allOf(withId(date1), isCompletelyDisplayed()), 3);
    }

    /**
     * Checks if the object is visible, by giving as a parameter only its matcher
     *
     * @param matcher           matcher to check
     * @param waitTimeInSeconds max no of seconds to wait the object to get displayed
     * @return true, if the matcher is visible, false otherwise
     */
    public static boolean checkIfUIObjectIsVisible(Matcher<View> matcher, int waitTimeInSeconds) {
        boolean isVisible = false;
        long endTime;

        endTime = System.currentTimeMillis() + waitTimeInSeconds * Time.ONE_SECOND;

        while (!isVisible && System.currentTimeMillis() <= endTime) {
            try {
                onView( matcher ).check( matches( isDisplayed() ) );
                isVisible = true;
            } catch (NoMatchingViewException | AppNotIdleException | AssertionFailedError | NoMatchingRootException e) {
                // do nothing
            }
        }

        return isVisible;
    }

    public static void clickOn( int id1) throws Exception{

        onView(withId(id1)).perform(click());
    }

     /**
     * Gets the recycler view size
     *
     * @param matcher viewMatcher
     * @return the size of the recycler view
     */
    public static int getRecyclerViewChildCount(final Matcher<View> matcher) {
        final int[] count = {0};
        onView( matcher ).perform( new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom( android.support.v7.widget.RecyclerView.class );
            }

            @Override
            public String getDescription() {
                return "getting child count";
            }

            @Override
            public void perform(UiController uiController, View view) {
                android.support.v7.widget.RecyclerView rv = (android.support.v7.widget.RecyclerView) view;
                count[0] = rv.getChildCount();
            }
        } );
        return count[0];
    }

    /**
     * Gets the child matcher at the specified position
     *
     * @param parentMatcher parent matcher
     * @param position      position of the child view
     * @return the child matcher at the specified position
     */
    public static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText( "Child at position " + position + " in parent " );
                parentMatcher.describeTo( description );
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches( parent ) && view.equals( ((ViewGroup) parent).getChildAt( position ) );
            }
        };
    }

    /**
     * Gets the UIObject based on the UiSelector properties
     *
     * @param nameSpace  NameSpace for the resourceId Eg, com.groupon.dev
     * @param resourceId unique resource Id for the UI Object
     */
    public static UiObject getUiObjectByResourceId(String nameSpace, String resourceId) throws Exception {
        return device.findObject( new UiSelector().resourceId( nameSpace + ":id/" + resourceId ) );
    }
}
