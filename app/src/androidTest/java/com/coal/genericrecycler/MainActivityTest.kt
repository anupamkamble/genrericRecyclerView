package com.coal.genericrecycler

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activitRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testActivity(){
        onView(withId(R.id.recyclerview))
            .inRoot(RootMatchers.withDecorView(
                Matchers.`is`(activitRule.activity.window.decorView)))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
            .check { view, noViewFoundException ->  ViewMatchers.withId(R.id.repoTitle).matches(
                withText("flutter/fulteriOS")) }

    }
}