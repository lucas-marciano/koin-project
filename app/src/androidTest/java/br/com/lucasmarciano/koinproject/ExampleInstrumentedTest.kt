package br.com.lucasmarciano.koinproject

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import br.com.lucasmarciano.koinproject.data.DataRepository
import br.com.lucasmarciano.koinproject.model.Currency
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.loadKoinModules

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : KoinTest {

    private val mockDataRepository = mock<DataRepository>()

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Before
    fun setup() {
        loadKoinModules(module(override = true) {
            factory("local") { mockDataRepository }
        })
    }

    @Test
    fun activityLaunches() {
        activity.launchActivity(null)
        onView(withId(R.id.rv_currencies))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkCurrenciesDisplay() {
        val currencies = CurrencyFactory.makeCurrencyList(5)
        stubDataRepositoryGetCurrencies(currencies)
        activity.launchActivity(null)

        checkCurrenciesAreDisplayed(currencies)
    }

    private fun checkCurrenciesAreDisplayed(currencies: List<Currency>) {
        currencies.forEachIndexed { index, currency ->
            onView(withId(R.id.rv_currencies))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(index))
            onView(RecyclerViewMatcher.withRecyclerView(R.id.rv_currencies).atPosition(index))
                .check(matches(hasDescendant(withText(currency.name))))
        }
    }

    private fun stubDataRepositoryGetCurrencies(currencies: List<Currency>) {
        whenever(mockDataRepository.getCurrencies(any()))
            .thenReturn(currencies)
    }
}
