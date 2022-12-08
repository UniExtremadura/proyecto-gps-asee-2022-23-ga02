package es.unex.trackstone10


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onData
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
import org.hamcrest.Matchers.anything
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class EditDeckTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun editDeckTest() {
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
                withId(R.id.ic_decks), withContentDescription("Decks"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navigation),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val appCompatButton3 = onView(
            allOf(
                withId(R.id.buttonCreateDeck), withText("Create deck"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment_container),
                        0
                    ),
                    0
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
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("test"), closeSoftKeyboard())

        val appCompatSpinner = onView(
            allOf(
                withId(R.id.mySpinner),
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
        appCompatSpinner.perform(click())

        val appCompatTextView = onData(anything())
            .inAdapterView(
                allOf(
                    withId(com.bumptech.glide.R.id.select_dialog_listview),
                    childAtPosition(
                        withId(com.bumptech.glide.R.id.contentPanel),
                        0
                    )
                )
            )
            .atPosition(5)
        appCompatTextView.perform(click())

        val appCompatButton4 = onView(
            allOf(
                withId(R.id.addCardButton), withText("Add Cards"),
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
        appCompatButton4.perform(click())

        val appCompatButton5 = onView(
            allOf(
                withId(R.id.buttonFinishDeck), withText("Finish"),
                childAtPosition(
                    allOf(
                        withId(R.id.Croot),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton5.perform(click())

        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.ic_decks), withContentDescription("Decks"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navigation),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())

        val appCompatButton6 = onView(
            allOf(
                withId(R.id.editDeckButton), withText("Edit"),
                childAtPosition(
                    allOf(
                        withId(R.id.deckConstraintlayout),
                        childAtPosition(
                            withId(R.id.recyclerViewDecks),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton6.perform(click())

        val appCompatButton7 = onView(
            allOf(
                withId(R.id.buttonCreateDeck), withText("Add Cards"),
                childAtPosition(
                    allOf(
                        withId(R.id.Croot),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton7.perform(click())

        val appCompatButton8 = onView(
            allOf(
                withId(R.id.AddCardDeckButton), withText("Add Card"),
                childAtPosition(
                    allOf(
                        withId(R.id.cardConstraintlayout),
                        childAtPosition(
                            withId(R.id.recyclerViewCards),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        Thread.sleep(4000)
        appCompatButton8.perform(click())

        val appCompatButton9 = onView(
            allOf(
                withId(R.id.AddCardDeckButton), withText("Add Card"),
                childAtPosition(
                    allOf(
                        withId(R.id.cardConstraintlayout),
                        childAtPosition(
                            withId(R.id.recyclerViewCards),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton9.perform(click())

        val appCompatButton10 = onView(
            allOf(
                withId(R.id.AddCardDeckButton), withText("Add Card"),
                childAtPosition(
                    allOf(
                        withId(R.id.cardConstraintlayout),
                        childAtPosition(
                            withId(R.id.recyclerViewCards),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton10.perform(click())

        val appCompatButton11 = onView(
            allOf(
                withId(R.id.AddCardDeckButton), withText("Add Card"),
                childAtPosition(
                    allOf(
                        withId(R.id.cardConstraintlayout),
                        childAtPosition(
                            withId(R.id.recyclerViewCards),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton11.perform(click())

        val appCompatButton12 = onView(
            allOf(
                withId(R.id.buttonCreateDeck), withText("Edit Deck"),
                childAtPosition(
                    allOf(
                        withId(R.id.Croot),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatButton12.perform(click())

        val appCompatButton13 = onView(
            allOf(
                withId(R.id.AddCardDeckButton), withText("Delete Card"),
                childAtPosition(
                    allOf(
                        withId(R.id.cardConstraintlayout),
                        childAtPosition(
                            withId(R.id.recyclerViewCards),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton13.perform(click())

        val appCompatButton14 = onView(
            allOf(
                withId(R.id.AddCardDeckButton), withText("Delete Card"),
                childAtPosition(
                    allOf(
                        withId(R.id.cardConstraintlayout),
                        childAtPosition(
                            withId(R.id.recyclerViewCards),
                            1
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton14.perform(click())

        val appCompatButton15 = onView(
            allOf(
                withId(R.id.buttonFinishDeck), withText("Finish"),
                childAtPosition(
                    allOf(
                        withId(R.id.Croot),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton15.perform(click())

        val appCompatButton16 = onView(
            allOf(
                withId(R.id.buttonFinishDeck), withText("Finish"),
                childAtPosition(
                    allOf(
                        withId(R.id.Croot),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatButton16.perform(click())
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
