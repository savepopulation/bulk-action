package com.raqun.bulkaction;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.raqun.bulkaction.profile.ProfileActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by tyln on 21/06/2017.
 */
@RunWith(AndroidJUnit4.class)
public class ProfileEspressoTest {

    @Rule
    public ActivityTestRule<ProfileActivity> testRule
            = new ActivityTestRule<>(ProfileActivity.class, true, true);

    @Before
    public void init() {

    }

    @Test
    public void ensureTextViewNameIsNotNullAndVisible() {
        onView(withId(R.id.textview_name))
                .check(matches(isDisplayed()));
    }


}
