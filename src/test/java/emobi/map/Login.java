package emobi.map;

import java.util.HashMap;

public class Login {
    private static final String EMAIL = "thuan@emobi.biz";
    private static final String PASSWORD = "thuan123456";

    public static HashMap<String, String> loginMap() {
        HashMap<String, String> postContent = new HashMap<>();
        postContent.put("email", EMAIL);
        postContent.put("password", PASSWORD);
        return postContent;
    }
}