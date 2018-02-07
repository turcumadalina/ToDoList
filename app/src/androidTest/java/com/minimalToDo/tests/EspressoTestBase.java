package com.minimalToDo.tests;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.example.avjindersinghsekhon.minimaltodo.MainActivity;
import org.junit.Rule;
import org.junit.runner.RunWith;

/**
 * Created by madalina.turcu on 2/7/18.
 */

@LargeTest
@RunWith(AndroidJUnit4.class)
public class EspressoTestBase {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);
}
