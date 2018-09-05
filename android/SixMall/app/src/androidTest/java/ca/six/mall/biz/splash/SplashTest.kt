package ca.six.mall.biz.splash

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.IdlingPolicies
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import ca.six.mall.R
import ca.six.mall.biz.home.HomeActivity
import ca.six.mall.util.SleepIdler
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
@LargeTest
class SplashTest {
    //    @get:Rule
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(SplashActivity::class.java)

    @Test
    fun afterTwoSeconds_displayHomePage() {
        onView(withId(R.id.ivSplash))
                .check(matches(isDisplayed()))

        val activity = activityRule.activity
        val idle = SleepIdler("splash", activity.DURATION_SPLASH)
        IdlingPolicies.setMasterPolicyTimeout(5, TimeUnit.SECONDS)
        IdlingPolicies.setIdlingResourceTimeout(5, TimeUnit.SECONDS)
        Espresso.registerIdlingResources(idle)

        onView(withId(R.id.rvHome))
                .check(matches(isDisplayed()))

        Espresso.unregisterIdlingResources(idle)
    }
}