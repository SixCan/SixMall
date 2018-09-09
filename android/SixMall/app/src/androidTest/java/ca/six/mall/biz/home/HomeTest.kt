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
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeTest : IIdlingFlag {

    @Rule
    @JvmField    //@get:Rule
    var activityRule = ActivityTestRule<HomeActivity>(HomeActivity::class.java)

    override fun isFinish(): Boolean {
        println("szw Test isFinish() : ${HttpEngine.isFinished}")
        return HttpEngine.isFinished
    }

//    @Test
//    fun init_showSolarMenu() {
//        initEnv()
//        onView(withId(R.id.menuMyAccount))
//                .check(matches(isDisplayed()))
//    }

    @Test
    fun init_getHintFromServer() {
        println("szw test 01")
        IdlingPolicies.setMasterPolicyTimeout(6, TimeUnit.SECONDS);
        IdlingPolicies.setIdlingResourceTimeout(10, TimeUnit.SECONDS);

        val idlingResource = AsyncIdlingRes(this);
        IdlingRegistry.getInstance().register(idlingResource)

        println("szw test 02")
        onView(withId(R.id.etSearch))
                .check(matches(withHint("iphone")))
        val hint = activityRule.activity.viewModel.keyWordHint
        println("szw test 03 ${hint.value}")

        idlingResource.removeListener(); // for memory leak
        IdlingRegistry.getInstance().unregister(idlingResource)
        println("szw test 04")
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
    "hotkey": "kitty",
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

