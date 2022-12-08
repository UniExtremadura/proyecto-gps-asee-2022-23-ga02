package es.unex.trackstone10


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DeleteFavoriteCardTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun deleteFavoriteCardTest() {
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

        val appCompatImageView = onView(
            allOf(
                withId(com.bumptech.glide.R.id.search_button), withContentDescription("Search"),
                childAtPosition(
                    allOf(
                        withId(com.bumptech.glide.R.id.search_bar),
                        childAtPosition(
                            withId(R.id.svCard),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        Thread.sleep(4000)
        appCompatImageView.perform(click())

        val searchAutoComplete = onView(
            allOf(
                withId(com.bumptech.glide.R.id.search_src_text),
                childAtPosition(
                    allOf(
                        withId(com.bumptech.glide.R.id.search_plate),
                        childAtPosition(
                            withId(com.bumptech.glide.R.id.search_edit_frame),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        searchAutoComplete.perform(replaceText("Jailer"), closeSoftKeyboard())

        val searchAutoComplete2 = onView(
            allOf(
                withId(com.bumptech.glide.R.id.search_src_text), withText("Jailer"),
                childAtPosition(
                    allOf(
                        withId(com.bumptech.glide.R.id.search_plate),
                        childAtPosition(
                            withId(com.bumptech.glide.R.id.search_edit_frame),
                            1
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        searchAutoComplete2.perform(pressImeActionButton())

        val recyclerView = onView(
            allOf(
                withId(R.id.recyclerViewCards),
                childAtPosition(
                    withClassName(`is`("android.widget.LinearLayout")),
                    1
                ),
                isDisplayed()
            )
        )
        Thread.sleep(4000)
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(2, click()))

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.add_delete_favoriteButton), withText("Add to favorites"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatButton3.perform(click())

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.ic_favorites), withContentDescription("Favorites"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navigation),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val recyclerView2 = onView(
            allOf(
                withId(R.id.recyclerViewCards),
                childAtPosition(
                    withClassName(`is`("android.widget.LinearLayout")),
                    1
                ),
                isDisplayed()
            )
        )
        Thread.sleep(4000)
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val appCompatButton4 = onView(
            allOf(
                withId(R.id.add_delete_favoriteButton), withText("Delete from Favorites"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatButton4.perform(click())
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
