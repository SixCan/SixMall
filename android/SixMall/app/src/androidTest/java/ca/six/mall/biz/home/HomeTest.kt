package ca.six.mall.biz.home

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import ca.six.mall.core.http.HttpEngine
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import ca.six.mall.R
import org.junit.Before

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeTest {
    //    @get:Rule
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun init_showSolarMenu() {
        initEnv()
        onView(withId(R.id.menuMyAccount))
                .check(matches(isDisplayed()))
    }

    @Test
    fun init_getHintFromServer(){
        initEnv()
        onView(withId(R.id.etSearch))
                .check(matches(withHint("iphone")))
    }

    @Before
    fun initEnv(){
        HttpEngine.isMock = true
        HttpEngine.mockJson = """
{
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
        """.trimIndent()
    }



    @After
    fun reset() {
        HttpEngine.isMock = false
    }

}