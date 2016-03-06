package swip.ch17datepicker.jquerydatepicker.v3;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import swip.ch15pageflow.framework.v2.Browser;
import swip.ch15pageflow.framework.v2.BrowserRunner;
import swip.framework.TestTimer;

import javax.inject.Inject;

import static java.time.Month.APRIL;
import static org.junit.Assert.assertEquals;

@RunWith(BrowserRunner.class)
public class JQueryDatepickerIT extends TestTimer {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Inject
    private Browser browser;

    private JQueryDatepicker jQueryDatepicker;

    @Before
    public void setup() {
        browser.get("/datepicker.html");
        jQueryDatepicker = new JQueryDatepicker(new JQueryCalendar(browser), new JQueryYearPicker(browser), new JQueryMonthPicker(browser), new JQueryDayPicker(browser));
    }

    @Test
    public void muchBetterDatePicker() {
        jQueryDatepicker.pick(APRIL, 1, 2012);
        assertEquals("04/01/2012", browser.findElement(By.id("datepicker")).getAttribute("value"));
    }
}
