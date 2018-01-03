package org.depankaj.service;

import org.depankaj.database.DatabaseAccess;

import java.time.ZonedDateTime;

public class H2DatabaseAccess implements DatabaseAccess {

    @Override
    public void insertLoginDetails(String username, String password, ZonedDateTime creationTime) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean isPasswordMatching(String username, String password) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void recordLoginActivity(String username, ZonedDateTime loginTime) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void recordLogoutActivity(String username, ZonedDateTime logoutTime) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean isUserLoggedIn(String username) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
