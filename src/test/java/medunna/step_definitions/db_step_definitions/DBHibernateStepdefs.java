package medunna.step_definitions.db_step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import medunna.hibernate.Room;
import medunna.hibernate.TestItem;
import medunna.step_definitions.ui_step_definitions.NewUIStepdefs;
import medunna.step_definitions.ui_step_definitions.UIRoomStepdefs;
import medunna.step_definitions.ui_step_definitions.UIStepDefs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DBHibernateStepdefs {
    Configuration configuration;
    SessionFactory sessionFactory;
    public static Session session;
    Transaction transaction;
    Room room;
    TestItem testItem;
    List<TestItem> resultList;

    @Given("user connects with the database")
    public void userConnectsWithTheDatabase() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml").addAnnotatedClass(TestItem.class).addAnnotatedClass(Room.class);

        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

    }

    @And("send query for test item")
    public void sendQueryForTestItem() {
        String hqlQuery = "FROM TestItem t WHERE t.name = '"+ NewUIStepdefs.exPectedName+"'";
          testItem= session.createQuery(hqlQuery, TestItem.class).uniqueResult();
        System.out.println("testItem = " + testItem);

    }

    @Then("verifies that the Test Item is created")
    public void verifiesThatTheTestItemIsCreated() {
        assertEquals(NewUIStepdefs.expectedPrice,testItem.getPrice());
        assertEquals(NewUIStepdefs.expectedDescription,testItem.getDescription());
        assertEquals(NewUIStepdefs.expectedMinValue,testItem.getDefaultValueMin());
        assertEquals(NewUIStepdefs.expectedMaxValue,testItem.getDefaultValueMax());
    }

    @When("send query for created room")
    public void sendQueryForCreatedRoom() {
        String hqlQuery = "FROM Room R WHERE R.roomNumber ="+UIRoomStepdefs.roomNumber;
        room = session.createQuery(hqlQuery, Room.class).uniqueResult();
        int id = room.getId();
        System.out.println(room);


    }

    @Then("validates created room from resultset")
    public void validatesCreatedRoomFromResultset() {
        assertEquals(UIRoomStepdefs.expectedRoomPrice,room.getPrice());
        assertEquals(UIRoomStepdefs.expectedRoomDescription,room.getDescription());
    }

    @And("closes the connection")
    public void closesTheConnection() {

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
