package models;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;


public class UnitTests {

    @Test
    public void checkConnection() throws SQLException {
        Assert.assertNotNull(User.connect());
    }



    @Test
    public void checkRegistrationAuthentication() throws SQLException {
        User user = new User();
        user.setEmail("email");
        user.setPassword("password");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setBirthday("birthday");
        user.setPhoneNumber("phoneNumber");
        user.delete();
        user.registration();

        Assert.assertEquals(user.authentication(), "password");

    }

}
