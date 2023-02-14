package models;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;


public class UnitTests {

    @Test
    public void checkConnection() throws SQLException {
        Assert.assertNotNull(User.connect());
    }

}
