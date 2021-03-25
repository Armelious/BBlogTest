package bblog.stepdefinitions;

import bblog.pageobjects.ArticlePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArticleSteps {

    private ArticlePage articlePage;

    public ArticleSteps(ArticlePage articlePage) {
        this.articlePage = articlePage;
    }

    @Then("I verify I can view the articles content")
    public void i_verify_articles_content() {
        articlePage.verifyArticleContentExists();
    }

    @When("I enter the comment {string}")
    public void i_enter_comment(String commentText) {
        articlePage.enterCommentText(commentText);
    }

    @When("I click Post Comment Button")
    public void i_click_post_comment(){
        articlePage.clickPostComment();
    }

    @Then("I verify my comment {string} was added")
    public void i_verify_comment_exists(String commentText) {
        articlePage.verifyCommentExists(commentText);
    }
}
