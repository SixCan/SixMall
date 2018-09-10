package ca.six.mall.biz.home

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.IdlingPolicies
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withHint
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import ca.six.mall.R
import ca.six.mall.core.AsyncIdlingRes
import ca.six.mall.core.IIdlingFlag
import ca.six.mall.core.http.HttpEngine
import ca.six.mall.util.SleepIdler
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeTest {

    @Rule
    @JvmField    //@get:Rule
    var activityRule = ActivityTestRule<HomeActivity>(HomeActivity::class.java)

//    @Test
//    fun init_showSolarMenu() {
//        initEnv()
//        onView(withId(R.id.menuMyAccount))
//                .check(matches(isDisplayed()))
//    }

    @Test
    fun init_getHintFromServer() {
        val activity = activityRule.activity
        val idle = SleepIdler("HomeHint", 3000)
        IdlingPolicies.setMasterPolicyTimeout(6, TimeUnit.SECONDS)
        IdlingPolicies.setIdlingResourceTimeout(10, TimeUnit.SECONDS)
        IdlingRegistry.getInstance().register(idle)

        onView(withId(R.id.etSearch))
                .check(matches(withHint("iphone")))
        val hint = activityRule.activity.viewModel.keyWordHint

        IdlingRegistry.getInstance().unregister(idle)
    }

    companion object {
        @BeforeClass
        @JvmStatic
        fun initEnv() {
            HttpEngine.isMock = true
            println("szw Test @BeforeClass : ${HttpEngine.isMock}")
            HttpEngine.mockJson = """
{
  "code": 200,
  "msg": "",
  "payload": {
    "hotkey": "iphone",
    "recommendations": [
      {
        "id": "33880013",
        "pic": "http://192.168.2.26:8899/images/items/cat3.webp",
        "title": "Kitty Adoption"
      },
      {
        "id": "33880014",
        "pic": "http://192.168.2.26:8899/images/items/cat4.webp",
        "title": "Kitty Adoption"
      }
    ]
  }
}
        """.trimIndent()
        }


        @AfterClass
        @JvmStatic
        fun reset() {
            HttpEngine.isMock = false
            println("szw Test @AfterClass : ${HttpEngine.isMock}")
        }

    } // end of companion object
}

