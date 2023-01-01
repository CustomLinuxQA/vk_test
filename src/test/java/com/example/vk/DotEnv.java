package com.example.vk;
import io.github.cdimascio.dotenv.Dotenv;


public class DotEnv {
    public String LOGIN_PHONE() {
        Dotenv dotenv = Dotenv.load();
            return (dotenv.get("LOGIN__PHONE"));
        }
    public String PASSWORD_PHONE() {
        Dotenv dotenv = Dotenv.load();
        return (dotenv.get("PASSWORD__PHONE"));
    }
    }
