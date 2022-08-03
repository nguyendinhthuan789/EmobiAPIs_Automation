package emobi.auth;

import io.restassured.authentication.AuthenticationScheme;

public interface RestAuth {
    AuthenticationScheme getAuth();
}
