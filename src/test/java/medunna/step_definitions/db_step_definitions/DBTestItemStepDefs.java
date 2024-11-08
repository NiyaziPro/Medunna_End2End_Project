package medunna.step_definitions.db_step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import medunna.step_definitions.ui_step_definitions.NewUIStepdefs;
import medunna.step_definitions.ui_step_definitions.UIStepDefs;
import medunna.utilities.ConfigReader;

import java.sql.*;

import static org.junit.Assert.assertEquals;

public class DBTestItemStepDefs {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public static int testItemId;

    @Given("Admin connect to the DataBase")
    public void adminConnectToTheDataBase() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUser"),
                ConfigReader.getProperty("dbPassword"));
    }


    @When("send query for created test item")
    public void sendQueryForCreatedTestItem() throws SQLException {
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from c_test_item where name = '" + NewUIStepdefs.exPectedName+"'");
    }

    @Then("validates created test item from resultset")
    public void validatesCreatedTestItemFromResultset() throws SQLException {
        resultSet.next();
        //assertEquals(UIStepDefs.name, resultSet.getString("name"));
//        assertEquals(UIStepDefs.expectedPrice, resultSet.getString("price"));
//        assertEquals(UIStepDefs.expectedDescription, resultSet.getString("description"));
//        assertEquals(UIStepDefs.expectedMinValue, resultSet.getString("default_val_min"));
//        assertEquals(UIStepDefs.expectedMaxValue, resultSet.getString("default_val_max"));

        testItemId = resultSet.getInt("id");
    }
}
