package linkopinghackers.passwordtest;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withTagKey;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Alexander on 2016-11-10.
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTestClass {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureCorrectTextAndProgress(){
        onView(withId(R.id.psm)).perform(typeText("hjk"));
        onView(withId(R.id.progress)).check(matches(withText("Too short")));
        onView(withId(R.id.progressbar)).check(matches(withItemProgress(0)));
        onView(withId(R.id.psm)).perform(typeText("ghjkl"));
        onView(withId(R.id.progress)).check(matches(withText("Weak")));
        onView(withId(R.id.progressbar)).check(matches(withItemProgress(10)));
        onView(withId(R.id.psm)).perform(typeText("1"));
        onView(withId(R.id.progress)).check(matches(withText("Fair")));
        onView(withId(R.id.progressbar)).check(matches(withItemProgress(20)));
        onView(withId(R.id.psm)).perform(typeText("K"));
        onView(withId(R.id.progress)).check(matches(withText("Average")));
        onView(withId(R.id.progressbar)).check(matches(withItemProgress(30)));
        onView(withId(R.id.psm)).perform(typeText("-"));
        onView(withId(R.id.progress)).check(matches(withText("Good")));
        onView(withId(R.id.progressbar)).check(matches(withItemProgress(40)));
        onView(withId(R.id.psm)).perform(typeText("h"));
        onView(withId(R.id.progress)).check(matches(withText("Strong")));
        onView(withId(R.id.progressbar)).check(matches(withItemProgress(50)));
    }
    
    public static Matcher<View> withItemProgress(final int progress) {
        // use preconditions to fail fast when a test is creating an invalid matcher.
        //checkNotNull(progress);
        return new BaseMatcher<View>() {

            @Override
            public void describeTo(final Description description) {
                description.appendText("withItemProgress should return: " + progress);
            }

            @Override
            public boolean matches(final Object object) {
                final ProgressBar progressBar1 = (ProgressBar) object;
                return progress == progressBar1.getProgress();
            }

        };
    }

}
