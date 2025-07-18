package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Locators
    By signInLink = By.className("authorization-link");
    By createAccountLink = By.linkText("Create an Account");
    By firstNameField = By.id("firstname");
    By lastNameField = By.id("lastname");
    By emailField = By.id("email_address");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("password-confirmation");
    By createAccountButton = By.cssSelector("button[title='Create an Account']");

    By accountDropdown = By.xpath("//button[contains(@class, 'action switch')]");
    By signOutButton = By.linkText("Sign Out");

    By changePasswordLink = By.linkText("Change Password");
    By currentPasswordField = By.id("current-password");
    By newPasswordField = By.name("password");
    By confirmNewPasswordField = By.id("password-confirmation");
    By saveButton = By.cssSelector("button[title='Save']");

    By loginEmailField = By.id("email");
    By loginPasswordField = By.id("pass");
    By loginButton = By.id("send2");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickSignIn() {
        driver.findElement(signInLink).click();
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountLink).click();
    }

    public void fillSignUpForm(String firstName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void submitRegistration() {
        driver.findElement(createAccountButton).click();
    }

    public void openAccountSettings() {
        //driver.findElement(By.linkText("My Account")).click();
        driver.findElement(changePasswordLink).click();
    }

    public void changePassword(String currentPwd, String newPwd, String confirmPwd) {
        driver.findElement(currentPasswordField).sendKeys(currentPwd);
        driver.findElement(newPasswordField).sendKeys(newPwd);
        driver.findElement(confirmNewPasswordField).sendKeys(confirmPwd);
        driver.findElement(saveButton).click();
    }

    public void logout() {
        driver.findElement(accountDropdown).click();
        driver.findElement(signOutButton).click();
    }

    public void login(String email, String password) {
        driver.findElement(loginEmailField).sendKeys(email);
        driver.findElement(loginPasswordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
