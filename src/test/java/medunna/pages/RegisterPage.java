package medunna.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import medunna.utilities.Driver;

public class RegisterPage {


    public RegisterPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    /////////////// --  Register Page -- /////////////////////

    @FindBy(xpath = "//*[.='Register']")
    public WebElement registerButton;

    @FindBy(id = "ssn")
    public WebElement ssnTextBox;

    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "username")
    public WebElement userNameTextBox;


    @FindBy(id = "email")
    public WebElement emailTextBox;


    @FindBy(id = "firstPassword")
    public WebElement firstPasswordTextBox;

    @FindBy(id = "secondPassword")
    public WebElement secondPasswordTextBox;

    @FindBy(id = "register-submit")
    public WebElement registerSubmitButton;

    @FindBy(xpath = "//*[.='Registration Saved']")
    public WebElement registrationSavedText;

    ////////////////// -- Password Strength -- //////////////////////

    @FindBy (xpath = "//li[@style='background-color: rgb(255, 0, 0);']")
    public WebElement passwordStrengthRed;

    @FindBy (xpath = "//li[@style='background-color: rgb(255, 153, 0);']")
    public WebElement passwordStrengthOrange;

    @FindBy (xpath = "//li[@style='background-color: rgb(153, 255, 0);']")
    public WebElement passwordStrengthGreen1;

    @FindBy (xpath = "//li[@style='background-color: rgb(0, 255, 0);']")
    public WebElement passwordStrengthGreen2;

}
