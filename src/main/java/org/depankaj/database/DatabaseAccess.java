package org.depankaj.database;

import java.time.ZonedDateTime;

public interface DatabaseAccess {

    void insertLoginDetails(String username, String password, ZonedDateTime creationTime);

    boolean isPasswordMatching(String username, String password);

    void recordLoginActivity(String username, ZonedDateTime loginTime);

    void recordLogoutActivity(String username, ZonedDateTime logoutTime);

    boolean isUserLoggedIn(String username);

}
