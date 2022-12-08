package es.unex.trackstone10


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import es.unex.trackstone10.LoginActivity
import es.unex.trackstone10.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class RegisterAndLoginTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun registerAndLoginTest() {
        val appCompatButton = onView(
            allOf(
                withId(R.id.registerButton), withText("Register"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.editTextEmail),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("test@gmail.com"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editTextTextPersonName),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("test"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.editTextPassword),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("test"), closeSoftKeyboard())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.confirmPassword),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("test"), closeSoftKeyboard())

        val appCompatButton2 = onView(
            allOf(
                withId(R.id.registerButton), withText("Register"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.ic_profile), withContentDescription("Profile"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navigation),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val textView = onView(
            allOf(
                withId(R.id.textViewEmail), withText("test@gmail.com"),
                withParent(withParent(withId(R.id.fragment_container))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("test@gmail.com")))

        val textView2 = onView(
            allOf(
                withId(R.id.textViewUsername), withText("test"),
                withParent(withParent(withId(R.id.fragment_container))),
                isDisplayed()
            )
        )
        textView2.check(matches(withText("test")))

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.closeSessionButton), withText("Log out from Application"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment_container),
                        0
                    ),
                    10
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.editTextTextPersonName),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("test"), closeSoftKeyboard())

        val appCompatEditText6 = onView(
            allOf(
                withId(R.id.editTextPassword),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText6.perform(replaceText("test"), closeSoftKeyboard())

        val appCompatButton4 = onView(
            allOf(
                withId(R.id.loginButton), withText("Login"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton4.perform(click())

        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.ic_profile), withContentDescription("Profile"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navigation),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())

        val textView3 = onView(
            allOf(
                withId(R.id.textViewEmail), withText("test@gmail.com"),
                withParent(withParent(withId(R.id.fragment_container))),
                isDisplayed()
            )
        )
        textView3.check(matches(withText("test@gmail.com")))

        val textView4 = onView(
            allOf(
                withId(R.id.textViewUsername), withText("test"),
                withParent(withParent(withId(R.id.fragment_container))),
                isDisplayed()
            )
        )
        textView4.check(matches(withText("test")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
