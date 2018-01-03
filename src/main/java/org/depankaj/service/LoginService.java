package org.depankaj.service;

import org.depankaj.database.DatabaseAccess;
import org.depankaj.domain.LoginCredentials;

import java.time.ZonedDateTime;

public class LoginService {

    private DatabaseAccess databaseAccess;

    public LoginService(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public void createNewLogin(LoginCredentials loginCredentials) {
        databaseAccess.insertLoginDetails(loginCredentials.username(), loginCredentials.password(), ZonedDateTime.now());
    }

    public void loginUser(LoginCredentials loginCredentials) {
        if(databaseAccess.isPasswordMatching(loginCredentials.username(), loginCredentials.password())) {
            databaseAccess.recordLoginActivity(loginCredentials.username(), ZonedDateTime.now());
        }
    }

    public void logoutUser(String username) {
        if(databaseAccess.isUserLoggedIn(username)) {
            databaseAccess.recordLogoutActivity(username, ZonedDateTime.now());
        }
    }
}
