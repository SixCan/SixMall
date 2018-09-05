package ca.six.mall

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import ca.six.mall.biz.splash.SplashActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SplashTest {
//    @get:Rule
    @Rule @JvmField
    var activityRule = ActivityTestRule(SplashActivity::class.java)

    @Test
    fun afterTwoSeconds_displayHomePage(){
        onView(withId(R.id.ivSplash))
                .check(matches(isDisplayed()))
    }
}