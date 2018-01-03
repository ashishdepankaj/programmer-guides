package org.depankaj.service;

import org.depankaj.database.DatabaseAccess;
import org.depankaj.domain.LoginCredentials;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginServiceTest {

    private DatabaseAccess databaseAccess = new H2DatabaseAccess();
    private LoginService loginService = new LoginService(databaseAccess);

    @Test
    public void createNewLogin() throws Exception {
        loginService.createNewLogin(LoginCredentials.apply("testUser", "dummypassword"));
        assertTrue(databaseAccess.isPasswordMatching("testUser", "dummypassword"));
        assertFalse(databaseAccess.isPasswordMatching("testUser", "badpassword"));

        assertFalse(databaseAccess.isPasswordMatching("baduser", "badpassword"));
    }

    @Test
    public void loginUser() throws Exception {
        assertFalse(databaseAccess.isUserLoggedIn("testUser"));
        loginService.loginUser(LoginCredentials.apply("testUser", "dummypassword"));
        assertTrue(databaseAccess.isUserLoggedIn("testUser"));
    }

    @Test
    public void logoutUser() throws Exception {
        loginService.loginUser(LoginCredentials.apply("testUser", "dummypassword"));
        assertTrue(databaseAccess.isUserLoggedIn("testUser"));
        loginService.logoutUser("testUser");
        assertFalse(databaseAccess.isUserLoggedIn("testUser"));
    }

}