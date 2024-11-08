package medunna.pages;

import medunna.utilities.ConfigReader;
import medunna.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static medunna.utilities.WaitUtils.waitFor;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement userIcon;
    @FindBy(id = "login-item")
    public WebElement signInOption;
    @FindBy(id = "username")
    public WebElement usernameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSubmitButton;

    @FindBy(id = "entity-menu")
    public WebElement itemsdAndTitles;

    @FindBy( xpath = "//span[.='Test Item']")
    public WebElement testItemOption;

    public void clickOnItemsdAndTitles(){
        this.itemsdAndTitles.click();
    }
    public void clickOnTestItemOption(){
        this.testItemOption.click();
    }

    public void login(){
        this.userIcon.click();
        this.signInOption.click();

        this.usernameInput.sendKeys(ConfigReader.getProperty("medunna_username"));
        this.passwordInput.sendKeys(ConfigReader.getProperty("medunna_password"));
        this.signInSubmitButton.click();
    }


    public void login(String username,String password){
        this.userIcon.click();
        this.signInOption.click();
        this.usernameInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        waitFor(2);
        this.signInSubmitButton.click();
    }




}
