package emobi.apis.auth;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.BasicAuthScheme;

public class RestBasicAuth implements RestAuth{
    BasicAuthScheme basicAuthScheme;

    /**
     * Init basic emobi.apis.auth scheme
     */
    public RestBasicAuth() {
        basicAuthScheme = new BasicAuthScheme();
    }

    public void setUserName(String userName){
        basicAuthScheme.setUserName(userName);
    }

    public void setPassword(String password){
        basicAuthScheme.setPassword(password);
    }

    @Override
    public AuthenticationScheme getAuth() {
        return null;
    }
}
