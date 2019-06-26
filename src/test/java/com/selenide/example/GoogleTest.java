//        Открыть главную страницу automationpractice.com
//        Открыть форму регистрации нового клиента (Sign in )
//        В секции Create an account ввести корректный емейл
//        Нажать Create an account
//        На форме регистрации заполнить ВСЕ ОБЯЗАТЕЛЬНЫЕ поля , КРОМЕ
//        выпадающих списков
//
//        Нажать Register
//        Проверить что сообщение валидации содержит текст ,
//        например “There are 3 errors”

package com.selenide.example;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.TimeUnit;


public class GoogleTest {
    @Test
    public void userCanSearch() {

        //open("http://automationpractice.com");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\iyefr\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Click to the "Login" button
        try {
            WebElement loginElement = driver.findElement(By.cssSelector(" a[class='login']"));
            loginElement.click();
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element Login hasn't been found");
        }
        // Enter unique email into the email_create field
        try {
            WebElement inputEmailField = driver.findElement(By.xpath("//input[@id='email_create']"));
            inputEmailField.clear();
            inputEmailField.sendKeys(generateUniqueEmail());
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element EmailInputField hasn't been found");
        }
        // Click on the "Create an account button"
        try {
            WebElement createAnAccountButton = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
            createAnAccountButton.click();

        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element Create_an_Account_Button hasn't been found");
        }

        // fill in "YOUR PERSONAL INFORMATION" form
        // Fill in "First Name" field
        try {
            WebElement firstNameField = driver.findElement(By.xpath("//*[@id='customer_firstname']"));
            firstNameField.clear();
            firstNameField.sendKeys("First Name");
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element  \"customer first name\" hasn't been found");
        }

        // Fill in "Last name" field
        try {
            WebElement lastNameField = driver.findElement(By.xpath("//input[@id='customer_lastname']"));
            lastNameField.clear();
            lastNameField.sendKeys("Last Name");
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element  \"customer Last name\" hasn't been found");
        }

        // Fill in "Password" field
        try {
            WebElement passwordField = driver.findElement(By.xpath("//input[@id='passwd']"));
            passwordField.clear();
            passwordField.sendKeys("MyPassword");
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element  \"Password\" hasn't been found");
        }

        // Fill in "Address" field
        try {
            WebElement addressField = driver.findElement(By.xpath("//input[@id='address1']"));
            addressField.clear();
            addressField.sendKeys("My Address");
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element  \"Address\" hasn't been found");
        }

        // Fill in "Phone" field
        try {
            WebElement phoneField = driver.findElement(By.xpath("//input[@id='phone']"));
            phoneField.clear();
            phoneField.sendKeys("0961111111");
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element  \"Phone\" hasn't been found");
        }

        // Fill in "Post Code" field
        try {
            WebElement cityField = driver.findElement(By.xpath("//input[@id='city']"));
            cityField.clear();
            cityField.sendKeys("Vinnitsia");
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element  \"Post Code\" hasn't been found");
        }

        // Fill in "Post Code" field
        try {
            WebElement postCodeField = driver.findElement(By.xpath("//input[@id='postcode']"));
            postCodeField.clear();
            postCodeField.sendKeys("01234");
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element  \"Post Code\" hasn't been found");
        }


        // Click "Register" button
        try {
            WebElement registerButton = driver.findElement(By.xpath("//button[@id='submitAccount']"));
            registerButton.click();
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element Register Button hasn't been found");
        }

        // Read alert message
        try {
            WebElement alertPopUp = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
            String alertText = alertPopUp.getText();
            String str = "There is 1 error";
            if (StringUtils.containsIgnoreCase(alertText, str)) {
                System.out.println("Alert message is correct and contains \"There is 1 errors\" string");
            } else {
                System.out.println("Alert message is incorrect and doesn't contain \"There is 1 errors\" string");
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("The element alert hasn't been found");
        }

        driver.close();
    }

    static private String generateUniqueEmail() {
        int length = 10;
        return "mail" + RandomStringUtils.randomNumeric(length) + "@gmail.com";
    }
}
