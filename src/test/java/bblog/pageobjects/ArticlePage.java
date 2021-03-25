package bblog.pageobjects;

import bblog.helpers.WebDriverHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage {

    private WebDriverHelper driverHelper;
    private WebDriver driver;
    private int nth = 1;

    public ArticlePage(WebDriverHelper driverHelper) {
        this.driverHelper = driverHelper;
        this.driver = driverHelper.getDriver();
    }

    //Article Content
    private By titleBy = By.xpath("//app-article//h1");
    private By authorBy = By.xpath("//app-article-meta//a[@class=\"author\"]");
    private By dateBy = By.xpath("//app-article-meta//span[@class=\"date\"]");
    private By contentBy = By.xpath("//app-article//div[contains(@class,\"article-content\")]//p");

    //Comments
    private By addCommentTextBy = By.xpath("//app-add-comment//textarea");
    private By postCommentButtonBy = By.xpath("//app-add-comment//button[\"Post Comment\"]");
    private By commentBy = By.xpath("//app-article-comment[" + nth + "]//p");
    private By commentAutherBy = By.xpath("//app-article-comment[2]//a[@class=\"comment-author\"][2]");
    private By commentDatePostedBy = By.xpath("//app-article-comment[2]//span[@class=\"date-posted\"]");

    /**
     * Verify each element exists.
     * todo Create an aggregated assert function for validating more than one element exists.
     * if any one fails the test stops, should assert all before exiting
     */
    public void verifyArticleContentExists() {
        Assert.assertTrue(driver.findElement(titleBy).isDisplayed());
        Assert.assertTrue(driver.findElement(authorBy).isDisplayed());
        Assert.assertTrue(driver.findElement(dateBy).isDisplayed());
        Assert.assertTrue(driver.findElement(contentBy).isDisplayed());
    }

    /**
     * Enter the text into the Add Comment text area
     * @param commentText String text to be entered for the new comment.
     */
    public void enterCommentText(String commentText) {
        driver.findElement(addCommentTextBy).sendKeys(commentText);
    }

    /**
     * Click the Post Comment button
     */
    public void clickPostComment() {
        driverHelper.clickElement(postCommentButtonBy);
    }

    public void verifyCommentExists(String commentText) {
        By commentTextBy = By.xpath("//app-article-comment//p[contains(text(),\"" + commentText + "\")]");
        Assert.assertTrue(driver.findElement(commentTextBy).isDisplayed());
    }
}
