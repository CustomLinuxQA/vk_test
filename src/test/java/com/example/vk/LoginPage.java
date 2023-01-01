package com.example.vk;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

// page_url = https://www.vk.com/
public class LoginPage {
    DotEnv dotEnv = new DotEnv();
    MainPage mainPage = new MainPage();

    public SelenideElement login_form = $(".VkIdForm__input");
    public SelenideElement login_button = $(".VkIdForm__signInButton");
    public SelenideElement password_form = $("[name=password]");
    public SelenideElement password_accept = $(".vkuiButton__in");


    public void login() {  // обычный логин, если капча не лезет.
        login_form.sendKeys(dotEnv.LOGIN_PHONE());
        login_button.click();
        password_form.sendKeys(dotEnv.PASSWORD_PHONE());
        password_accept.click();
        mainPage.avatar.shouldBe(visible);
    }

    public void login_before_captcha() {  // логин с паузой. Заглушка до реализации подстановки кукис.
        login_form.sendKeys(dotEnv.LOGIN_PHONE());
        login_button.click();
    }

    public void login_after_captcha() {
        password_form.sendKeys(dotEnv.PASSWORD_PHONE());
        password_accept.click();
        mainPage.avatar.shouldBe(visible);
    }
}