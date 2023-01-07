package com.example.vk;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

// page_url = https://www.vk.com/
public class MainPage {
    public SelenideElement groupButton = $("#l_gr");
    public SelenideElement createGroupButton = $(".ui_tabs_right_section .FlatButton__content");
    public SelenideElement groupsCreateTileInterests = $(".groups_create_tile_interests");
    public SelenideElement titleGroup = $("#groups_create_box_title");
    public SelenideElement selectDropdown = $(".groups_create_box_input_padded .selector_dropdown");
    public SelenideElement selectTopic = $("[val=\'3017\']");
    public SelenideElement groupCreateBoxChat = $("#groups_create_box_chat");
    public SelenideElement acceptCreateGroupButton = $("button:nth-child(2) .FlatButton__in");
    public SelenideElement avatar = $(".TopNavBtn__profileImg");
    public SelenideElement grWelcomeBoxClose = $(".groups_welcome_box_close");
    public SelenideElement pageName = $(".page_name");
    public SelenideElement pageActionBtnCh = $("div:nth-of-type(2) > div:nth-of-type(3) > a");
    public SelenideElement exitChatGroup = $("div button.ChatSettings__leave");
    public SelenideElement confirmExitChat = $(".box_controls div button:nth-child(2)");
    public SelenideElement createChat = $("#chat_creation");
    public SelenideElement confirmCreateChat = $(".Button--primary");
    public SelenideElement chatLink = $(".desc_info .group_name");
    public SelenideElement joinChatLink = $("._im_join_chat");
    public SelenideElement attachBtn = $(".ms_item_more_label");
    public SelenideElement attachAudio = $(".ms_item_audio");
    public SelenideElement testAudio = $(".ape_attach");
    public SelenideElement sendMessage = $("._im_text");
    public SelenideElement mediaInChat = $("div[class*='wall'] .post_media");
    public SelenideElement pageActionBtnGr = $(".page_actions_btn");
    public SelenideElement leaveGroup = $(".page_actions_inner a:nth-child(1) span");
    public SelenideElement confirmLeaveGroup = $(".box_controls button:nth-child(2)");
    public SelenideElement attachImage = $(".ms_item_photo");
    public SelenideElement testImage = $("#photos_choose_row655263065_457239250_");
    public SelenideElement imageInChat = $("._im_log_body");
    public SelenideElement attachItemDoc = $(".ms_item_doc");
    public SelenideElement testItemDoc = $("#docs_file_655263065_650634094");
    public SelenideElement docInChat = $(".page_doc_row");
    public SelenideElement uploadFile = $("input[type=file]");

    public void create_new_group() {
        groupButton.click();
        createGroupButton.click();
        groupsCreateTileInterests.click();
        titleGroup.sendKeys("test_group");
        selectDropdown.click();  //  не удалось реализовать метод selectOptionByValue()
        selectTopic.click();     //  не удалось реализовать метод selectOptionByValue()
//        groupCreateBoxChat.click();
        acceptCreateGroupButton.click();
//        grWelcomeBoxClose.click();    // автотест не вызывает WelcomeModalWindow.
        pageName.shouldHave(Condition.text("test_group"));
    }

    public void delete_new_chat_from_group() {
        chatLink.click();
        pageActionBtnCh.click();
        exitChatGroup.click();
        confirmExitChat.click();
    }

    public void delete_new_chat() {
        pageActionBtnCh.click();
        exitChatGroup.click();
        confirmExitChat.click();
    }

    public void create_chat_in_group() {
        createChat.click();
        confirmCreateChat.click();
        chatLink.scrollIntoView(false);
        chatLink.click();
        joinChatLink.click();
    }

    public void go_to_chat() {
        chatLink.click();
    }

    public void delete_new_group() {
        pageActionBtnGr.click();
        leaveGroup.click();
        confirmLeaveGroup.click();
    }

    public void attach_music_file_from_library() {
        attachBtn.click();
        attachAudio.click();
        testAudio.click();
        sendMessage.pressEnter();
        mediaInChat.shouldBe(visible);
    }

    public void attach_music_file_from_user_machine() {
        String filePath = "/Users/olegtoropov/IdeaProjects/VK_test/files/test.jpg";
        uploadFile.sendKeys(filePath);
    }

    public void attach_image_file_from_library() {
        attachBtn.click();
        attachImage.click();
        testImage.click();
        sendMessage.pressEnter();
        imageInChat.shouldBe(visible);
    }

    public void attach_doc_file_from_library() {
        attachBtn.click();
        attachItemDoc.click();
        testItemDoc.click();
        sendMessage.pressEnter();
        docInChat.shouldBe(visible);
    }
}
