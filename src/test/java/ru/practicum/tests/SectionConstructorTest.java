package ru.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.steps.SectionSteps;

import java.io.IOException;


public class SectionConstructorTest extends BaseTest {

    private SectionSteps sectionSteps;

    @Before
    public void prepareTest() throws IOException {
        sectionSteps = new SectionSteps(driver);
    }


    @Test
    @DisplayName("Buns Section Be Active By Default")
    @Description("When you open the Stellar Burger page, the Buns section is active by default")
    public void shouldBunsSectionBeActiveByDefaultTest() {
        sectionSteps.shouldBunsSectionBeActiveByDefault();
    }

    @Test
    @DisplayName("Buns Section Become Active When Clicked")
    @Description("The 'Buns' section becomes active when switching between sections in the 'Stellar Burger' " +
            "website builder")
    public void bunsSectionBecomeActiveWhenClickedTest() {
        sectionSteps.shouldBunsSectionBecomeActiveWhenClicked();
    }

    @Test
    @DisplayName("Sauces Section Become Active When Clicked")
    @Description("The 'Sauces' section becomes active when switching between sections in the 'Stellar Burger' " +
            "website builder")
    public void saucesSectionBecomeActiveWhenClickedTest() {
        sectionSteps.shouldSaucesSectionBecomeActiveWhenClicked();
    }

    @Test
    @DisplayName("Fillings Section Become Active When Clicked")
    @Description("The 'Fillings' section becomes active when switching between sections in the 'Stellar Burger' " +
            "website builder")
    public void fillingsSectionBecomeActiveWhenClickedTest() {
        sectionSteps.shouldFillingsSectionBecomeActiveWhenClicked();
    }
}