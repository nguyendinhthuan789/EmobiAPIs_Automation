package emobi.apis.auth;

import io.restassured.authentication.AuthenticationScheme;

public interface RestAuth {
    AuthenticationScheme getAuth();
}
