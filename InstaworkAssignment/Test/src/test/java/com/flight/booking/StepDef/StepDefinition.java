package com.flight.booking.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StepDefinition {

    WebDriver driver = new ChromeDriver();
    @Given("^user is in Flight booking application$")
    public void user_is_in_Flight_booking_application() {
        driver.get("https://www.orbitz.com/");
    }

    @And("the user selects the flight option and Round trip")
    public void theUserSelectsTheFlightOptionAndRoundTrip() {
        driver.findElement(By.linkText("Flights")).click();
        driver.findElement(By.linkText("Roundtrip")).click();
    }

    @Given("^the user selects the flight option and Round trip$")
    public void the_user_selects_the_flight_option_and_Round_trip() {
        driver.findElement(By.linkText("Flights")).click();
        driver.findElement(By.linkText("Roundtrip")).click();
    }

    @When("^the user selects \"([^\"]*)\"$")
    public void the_user_selects(String location) {
        if(location.equalsIgnoreCase("Leaving from")){
            driver.findElement(By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[1]/div/div[1]/div/div/div/button[1]")).click();
        }
        else{
            driver.findElement(By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[1]/div/div[2]/div/div/div/button[1]")).click();
        }
    }

    @Then("^the user is provided with search option$")
    public void the_user_is_provided_with_search_option() {
        driver.findElement(By.xpath("//*[@id=\"app-layer-origin-flight\"]/div[2]/div/div[1]/section/div/input")).click();
    }

    @When("^the user search with \"([^\"]*)\"$")
    public void the_user_search_with(String location) {
        driver.findElement(By.xpath("//*[@id=\"app-layer-origin-flight\"]/div[2]/div/div[1]/section/div/input")).sendKeys(location);
    }

    @Then("^the user is provided with search result$")
    public void the_user_is_provided_with_search_result() {
        driver.findElement(By.xpath("//*[@id=\"app-layer-origin-flight\"]/div[2]/div/div[2]/ul/li[1]/button/div/div[1]/span/strong")).click();
    }

    @Then("^the user is provided with search results$")
    public void the_user_is_provided_with_search_results() {
        driver.findElement(By.xpath("//*[@id=\"wizard-flight-tab-roundtrip\"]/div[2]/div[1]/div/div[2]/div/div/div/button[1]")).click();
    }

    @Then("^the user selects the Departing date$")
    public void the_user_selects_the_Departing_date() throws InterruptedException {
        calculateDate(14);
    }

    @Then("^the user selects the Returning date$")
    public void the_user_selects_the_Returning_date() throws InterruptedException {
        calculateDate(21);
        }

    @When("^the user search the flight option$")
    public void the_user_search_the_flight_option() {
        driver.findElement(By.xpath("//*[@id=\"wizard-flight-pwa-1\"]/div[3]/div[2]/button")).click();
    }

    @When("^the user selects sort by \"([^\"]*)\" and \"([^\"]*)\" option from the filter$")
    public void the_user_selects_sort_by_and_option_from_the_filter(String sortName, String filter) {
        driver.findElement(By.xpath("//*[@id=\"app-layer-base\"]/div[2]/div[1]/div/div/section/div/div[2]/button/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"listings-sort\"]")).click();
        driver.findElement(By.linkText(sortName)).click();
        driver.findElement(By.xpath("//*[@id=\"stops-0\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"app-layer-sort-filter-dialog-layer\"]/div[2]/div/div[3]/button")).click();
    }

    @Then("^the user is provided with the flight options$")
    public void the_user_is_provided_with_the_flight_options() {
        String flight = driver.findElement(By.xpath("//*[@id=\"AQqgAgqKAnY1LXNvcy01ZjhjMjJlYjY0OGM0YjQ4YmYxZGM5ODk3YjE4MTc2ZC0zOS0yMi0xfjIuU35BUW9FQ0xta0JCSUhDTlFFRUE0WVZ5QUhJQUVnRENBTklBa29BbElFd1lnQ0FWZ0NjQUF-QVFvc0Npb0l4SmdCRWdNek1UQVlzbkVncVZFb3pZajdBVENWaV9zQk9FVkFBRmdCYWdsQ1FWTkpRMFZEVDA0S0xBb3FDTVNZQVJJRE16RTBHS2xSSUxKeEtMdmMtd0V3eU5fN0FUaEZRQUJZQVdvSlFrRlRTVU5GUTA5T0Vnb0lBUkFCR0FFcUFrUk1HQUVpQkFnQkVBRW9BaWdES0FRd0FREeF6FK5HGWNAIgEBKgUSAwoBMRI_ChYKCjIwMjEtMTAtMjcSA1NGTxoDTllDChYKCjIwMjEtMTEtMDMSA05ZQxoDU0ZPEgcSBUNPQUNIGgIQASAC\"]/div/div/div/button")).getText();
        Assert.assertSame(flight,"Select and show fare information for Delta flight, departing at 7:05am from San Francisco, arriving at 3:33pm in New York, Priced at $152.79 Roundtrip per traveler.  5 hours 28 minutes total travel time, Nonstop, 2 cleaning and safety practice.");

    }

    public void calculateDate(int noOfDays) throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, noOfDays);
        Date date = cal.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
        String formattedDate = formatter.format(date);
        String splitter[] = formattedDate.split("-");
        String monthYear = splitter[1];
        String day = splitter[0];
        selectDate(monthYear,day);
    }

    public void selectDate(String monthYear, String selectDate) throws InterruptedException
    {

        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"app-layer-datepicker-flights-departure-arrival-start\"]/div[2]/div/div/div[2]/div/div[1]/table"));
        for (int i=0; i<elements.size();i++)
        {
            System.out.println(elements.get(i).getText());
            if(elements.get(i).getText().equals(monthYear))
            {
                List<WebElement> days = driver.findElements(By.xpath("//div[@class='ui-datepicker-inline ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all ui-datepicker-multi ui-datepicker-multi-2']/div[2]/table/tbody/tr/td/a"));
                for (WebElement d:days)
                {
                    System.out.println(d.getText());
                    if(d.getText().equals(selectDate))
                    {
                        d.click();
                        Thread.sleep(10000);
                        return;
                    }
                }

            }

        }
    }
}