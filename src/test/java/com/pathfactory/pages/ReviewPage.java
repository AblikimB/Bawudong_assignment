package com.pathfactory.pages;

import com.pathfactory.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage {
    public ReviewPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@id='tab-label-reviews-title']")
    public WebElement review;

    @FindBy(xpath = "//label[@id='Rating_3_label']")
    public WebElement rating;

    @FindBy(id = "nickname_field")
    public WebElement inputNickName;

    @FindBy(id = "summary_field")
    public WebElement inputSummary;

    @FindBy(id = "review_field")
    public WebElement inputReview;

    @FindBy(xpath = "//span[normalize-space()='Submit Review']")
    public WebElement submitReviewButton;


}
