package com.example.vk;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x1024";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        open("https://vk.com/");
        loginPage.login_before_captcha();
        Thread.sleep(15000); // заглушка для капчи, пока не реализовал подстановку кукис.
        loginPage.login_after_captcha();
    }

    @AfterMethod
    public void endTest() {
        System.out.println("afterMethod");
        closeWebDriver();
    }

    @Test(retryAnalyzer = Retry.class)
    public void user_can_create_new_chat() throws InterruptedException {
        mainPage.create_new_group();
        Thread.sleep(3000);   // пауза в 5 секунд для человека
        mainPage.delete_new_group(); // clean test_group
        Thread.sleep(3000);
        mainPage.delete_new_chat_from_group();
    }

    @Test(retryAnalyzer = Retry.class)
    public void user_can_attach_music_file_from_library() throws InterruptedException {
        mainPage.create_new_group();
        Thread.sleep(3000);
        mainPage.delete_new_group();
        Thread.sleep(3000);
        mainPage.go_to_chat();
        Thread.sleep(3000);
        mainPage.attach_music_file_from_library();
        Thread.sleep(3000);
        mainPage.delete_new_chat();
    }

    @Test(retryAnalyzer = Retry.class)
    public void user_can_attach_image_file_from_library() throws InterruptedException {
        mainPage.create_new_group();
        Thread.sleep(3000);
        mainPage.delete_new_group();
        Thread.sleep(3000);
        mainPage.go_to_chat();
        Thread.sleep(3000);
        mainPage.attach_image_file_from_library();
        Thread.sleep(3000);
        mainPage.delete_new_chat();
    }

    @Test(retryAnalyzer = Retry.class)
    public void user_can_attach_doc_file_from_library() throws InterruptedException {
        mainPage.create_new_group();
        Thread.sleep(3000);
        mainPage.delete_new_group();
        Thread.sleep(3000);
        mainPage.go_to_chat();
        Thread.sleep(3000);
        mainPage.attach_doc_file_from_library();
        Thread.sleep(3000);
        mainPage.delete_new_chat();
    }

    @Test(retryAnalyzer = Retry.class)
    public void user_can_attach_music_file_from_user_machine() throws InterruptedException {
        mainPage.create_new_group();
        Thread.sleep(3000);
        mainPage.delete_new_group();
        Thread.sleep(3000);
        mainPage.go_to_chat();
        Thread.sleep(3000);
        mainPage.attach_music_file_from_user_machine();
        Thread.sleep(5000);
        mainPage.sendMessage.pressEnter();
        mainPage.delete_new_chat();
    }
}
