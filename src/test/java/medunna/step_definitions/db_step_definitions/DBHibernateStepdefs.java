package medunna.step_definitions.db_step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import medunna.hibernate.Room;
import medunna.hibernate.TestItem;
import medunna.step_definitions.ui_step_definitions.UIRoomStepdefs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBHibernateStepdefs {
    Configuration configuration;
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;
    List<Room> result;


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
        TestItem testItem = session.get(TestItem.class,DBTestItemStepDefs.testItemId);
        System.out.println("testItem = " + testItem);

    }

    @Then("verifies that the Test Item is created")
    public void verifiesThatTheTestItemIsCreated() {
    }

    @When("send query for created room")
    public void sendQueryForCreatedRoom() {
        String hqlQuery = "FROM Room R WHERE R.roomNumber ="+UIRoomStepdefs.roomNumber;
        Room room = session.createQuery(hqlQuery, Room.class).uniqueResult();
        int id = room.getId();
        room= session.get(Room.class, id);
        System.out.println(room);


    }

    @Then("validates created room from resultset")
    public void validatesCreatedRoomFromResultset() {
    }

    @And("closes the connection")
    public void closesTheConnection() {

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
